package org.example.contactbookspring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/contactsjdbs");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("");
        hikariConfig.setDriverClassName(org.postgresql.Driver.class.getName());
        return hikariConfig;
    }

    @Bean
    public DataSource dataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}


