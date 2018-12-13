package com.binfool.demo.config;

import com.binfool.demo.constant.DBTypeEnum;
import com.binfool.demo.constant.NumberConstants;
import com.binfool.demo.framework.DynamicRoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 主从mysql配置
 * @author bin
 * @date 2018/12/11 23:49
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.binfool.demo.mapper", sqlSessionTemplateRef  = "sqlSessionTemplate")
public class DataSourceConfig {

    @Resource(name = "dynamicRoutingDataSource")
    private DataSource dynamicRoutingDataSource;

    @Bean(name = "master")
    @ConfigurationProperties("spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicRoutingDataSource")
    public DataSource dynamicRoutingDataSource(
            @Qualifier("master") DataSource masterDataSource
            , @Qualifier("slave") DataSource slave1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(NumberConstants.INIT_CAPACITY);
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE, slave1DataSource);
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        dynamicRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicRoutingDataSource.setTargetDataSources(targetDataSources);
        return dynamicRoutingDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicRoutingDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-page-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicRoutingDataSource);
    }
}
