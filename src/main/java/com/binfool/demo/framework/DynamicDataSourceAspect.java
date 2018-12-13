package com.binfool.demo.framework;

import com.binfool.demo.constant.DBTypeEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 默认&增删改走master 查询走slave
 * @author bin
 * @date 2018/12/12 14:27
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(SetDataSource)")
    public void beforeSwitchDS(JoinPoint point) {

        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();

        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        DBTypeEnum dataSource = DBTypeEnum.MASTER;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(SetDataSource.class)) {
                SetDataSource annotation = method.getAnnotation(SetDataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDataSource(dataSource);

    }

    @After("@annotation(com.binfool.demo.framework.SetDataSource)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.removeDataSource();
    }
}
