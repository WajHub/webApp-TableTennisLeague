package com.leagueTT.singlesMatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SinglesMatchRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public SinglesMatchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(SinglesMatch singlesMatch) {
        String sql = "INSERT INTO SinglesMatch(ResultPlayerHome, ResultPlayerGuest," +
                                                "IdGame," +
                                                "IdPlayerHome, IdPlayerGuest)" +
                "VALUES(?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, singlesMatch.getResultPlayerHome(), singlesMatch.getResultPlayerGuest(),
                                    singlesMatch.getGame(),
                                    singlesMatch.getPlayerHome(), singlesMatch.getPlayerGuest());
        return 1;
    }

    public int getAll(){
        String sql = "SELECT * FROM SinglesMatch";
        jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(SinglesMatch.class));
        return 1;
    }

    public int deleteMatches(int id) {
        String sql = "DELETE FROM SinglesMatch WHERE IdGame=?";
        return jdbcTemplate.update(sql, id);
    }
}
