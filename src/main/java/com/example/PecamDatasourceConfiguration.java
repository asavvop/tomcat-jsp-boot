package com.example;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PecamDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.pecam")
    public DataSourceProperties pecamDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource pecamDataSource() {
        return pecamDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
