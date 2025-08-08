package com.example;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class PositDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.posit")
    public DataSourceProperties positDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource positDataSource() {
        return positDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}