package com.leagueTT.hall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HallRepositoryTest {

    @Autowired
    HallRepository hallRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static class HallRowMapper implements RowMapper<Hall> {
        @Override
        public Hall mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Hall(rs.getString("city"), rs.getString("postcode"), rs.getString("street"),
                    rs.getInt("buildingNumber"), rs.getInt("fanCapacity"));
        }
    }
    @Test
    void save() {
        //given
        Hall hall = new Hall("City", "74-240", "Street", 10, 1000);

        //when
        int result = hallRepository.save(hall);
        Hall savedHall = jdbcTemplate.queryForObject("SELECT * FROM Hall WHERE id=?", new HallRowMapper(),5);

        //then
        assertEquals(1, result);
        assertEquals(hall, savedHall);
    }


}