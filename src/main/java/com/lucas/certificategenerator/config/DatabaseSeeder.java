package com.lucas.certificategenerator.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseSeeder {
    
    private final JdbcTemplate jdbcTemplate;

    public DatabaseSeeder(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.hibernate.dialect.PostgreSQLDialect");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/cg_nlw");
        dataSource.setUsername("admin");
        dataSource.setPassword("1234");

        DatabaseSeeder createSeed = new DatabaseSeeder(dataSource);
        createSeed.run(args);
    }

    public void run(String... args){
        executeSqlfile("src/main/resources/insert.sql");
    }

    private void executeSqlfile(String filePath){
        try{
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            jdbcTemplate.execute(sqlScript);
            System.out.println("Seed realizado com sucesso");
        }catch(IOException e){
            System.out.println("Erro ao executar o arquivo");
        }
        
    }

}
