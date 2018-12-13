package com.binfool.demo.framework;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 动态数据源 获取路由数据源
 * @author bin
 * @date 2018/12/12 0:18
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource{

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceName();
    }
}
