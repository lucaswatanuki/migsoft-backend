package migsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class PostgreSQLConfig {
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource source = new DriverManagerDataSource();
//        source.setDriverClassName("org.postgresql.Driver");
//        source.setUrl("jdbc:postgresql://localhost:5432/migsoft");
//        source.setUsername("postgres");
//        source.setPassword("postgres");
//        return source;
//    }
//
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource());
//        return namedParameterJdbcTemplate;
//    }
}
