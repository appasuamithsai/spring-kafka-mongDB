package com.amith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories("com.amith.repository")
@ComponentScan("com.amith.*")
public class SpringBootApplicationLibrarayManagement
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootApplicationLibrarayManagement.class, args);
    }
}
