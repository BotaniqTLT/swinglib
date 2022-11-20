package DAO;

import DTO.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TestDAO {

    public static final String SELECT_ID_NAME_AGE = "SELECT id, name, age FROM person";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getPerson(){

        String sql  = SELECT_ID_NAME_AGE;

        List<Person> query = jdbcTemplate.query(SELECT_ID_NAME_AGE, new BeanPropertyRowMapper<>(Person.class));

        return query;

    }

}
