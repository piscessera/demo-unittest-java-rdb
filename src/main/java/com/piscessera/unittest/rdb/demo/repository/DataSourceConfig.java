package com.piscessera.unittest.rdb.demo.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ToString
public class DataSourceConfig {
    @Getter @Setter
    private DataSourceConfig instance;
    @Getter @Setter
    private String driver;
    @Getter @Setter
    private String jdbc;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public void loadConfig(Class clazz) {
        if (instance == null) {
            instance = new DataSourceConfig();

            InputStream inputStream = clazz.getClassLoader().getResourceAsStream("project.properties");
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                instance.driver = properties.getProperty("datasource.driver");
                instance.jdbc = properties.getProperty("datasource.jdbc");
                instance.username = properties.getProperty("datasource.username");
                instance.password = properties.getProperty("datasource.password");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
