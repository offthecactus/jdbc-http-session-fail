package com.fail.session;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableAutoConfiguration
public class Config {

    @Bean(name = "sillyDatasource1")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).addScript("/session-db-schema.sql").build();
    }

    @Bean(name = "sillyDatasource2")
    public EmbeddedDatabase dataSource2() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).addScript("/session-db-schema.sql").build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("sillyDatasource1") EmbeddedDatabase dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
