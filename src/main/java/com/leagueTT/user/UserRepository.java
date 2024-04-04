package com.leagueTT.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> findByName(String name){
        String sql = "SELECT * FROM _user WHERE username = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(User.class),
                name));
    }


}
