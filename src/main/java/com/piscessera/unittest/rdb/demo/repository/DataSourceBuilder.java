package com.piscessera.unittest.rdb.demo.repository;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceBuilder {

    public static DataSource createDataSource(DataSourceConfig config) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(config.getInstance().getJdbc());
        dataSource.setDriverClassName(config.getInstance().getDriver());
        dataSource.setUsername(config.getInstance().getUsername());
        dataSource.setPassword(config.getInstance().getPassword());
        return dataSource;
    }
}
