/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.zaxxer.hikari.HikariDataSource
 *  org.springframework.beans.factory.annotation.Qualifier
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 *  org.springframework.context.annotation.Primary
 *  org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
 */
package com.example.Replications.Configs;

import com.example.Replications.DataSource.RoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

@Configuration
public class DatabaseConfig {
    @Bean
    @ConfigurationProperties(value="app.datasource.master")
    public HikariDataSource masterDataSource() {
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties(value="app.datasource.replica")
    public HikariDataSource replicaDataSource() {
        return new HikariDataSource();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier(value="masterDataSource") DataSource master, @Qualifier(value="replicaDataSource") DataSource replica) {
        HashMap<String, DataSource> dataSources = new HashMap<String, DataSource>();
        dataSources.put("MASTER", master);
        dataSources.put("REPLICA", replica);
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setTargetDataSources(dataSources);
        routingDataSource.setDefaultTargetDataSource(master);
        routingDataSource.afterPropertiesSet();
        return routingDataSource;
    }

    @Bean
    @Primary
    public DataSource dataSource(@Qualifier(value="routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}
