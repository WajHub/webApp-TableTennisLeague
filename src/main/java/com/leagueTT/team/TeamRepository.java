package com.leagueTT.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Team> getAll(){
        return jdbcTemplate.query("Select * FROM Team",
                BeanPropertyRowMapper.newInstance(Team.class));
    }
}
