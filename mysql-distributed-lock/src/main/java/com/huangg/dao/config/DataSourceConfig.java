package com.huangg.dao.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static DataSource dataSource=null;
    @Bean(name = "dblockDataSource")
    @Qualifier("dblockDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dblock")
    public DataSource xenderflixDataSource() {
        dataSource=DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "dblockJdbcTemplate")
    public JdbcTemplate xenderflixJdbcTemplate(@Qualifier("dblockDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public DataSource getDblockDataSource(){
        return dataSource;
    }
}
