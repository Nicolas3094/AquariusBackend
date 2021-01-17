package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PostgresDatasource {

    @Bean
    @ConfigurationProperties("app.datasource")
    @Profile("dev")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
    @Bean
    @ConfigurationProperties("prod.datasource")
    @Profile("prod")
    public HikariDataSource hikariDataSourceProd(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
}
