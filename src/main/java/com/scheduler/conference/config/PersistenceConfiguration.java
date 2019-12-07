package com.scheduler.conference.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    // These are  environment variable in Edit Configurations. A good way to hide credentials is by using JNDI.
    @Value("${DB_URL}")
    private String db_url;

    @Value("${DB_Username}")
    private String db_username;

    @Value("${DB_Pw}")
    private String db_pw;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(db_url);
        builder.username(db_username);
        builder.password(db_pw);
        return builder.build();

    }
}
