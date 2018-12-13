package com.binfool.demo.framework;

import com.binfool.demo.constant.DBTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据源设置到每个线程上下文中
 * @author bin
 * @date 2018/12/12 13:20
 */
public class DataSourceContextHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();


    private DataSourceContextHolder(){}

    public static DBTypeEnum getDataSourceName() {
        return contextHolder.get();
    }

    public static void setDataSource(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum);
        LOGGER.info("数据源切换到==>{}", dbTypeEnum);
    }

    public static void removeDataSource() {
        contextHolder.remove();
        LOGGER.info("移出数据源");
    }

}
