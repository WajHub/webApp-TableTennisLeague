package com.leagueTT.hall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HallRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Hall hall){
    jdbcTemplate.update("INSERT INTO Hall(city,postcode, street, buildingNumber, fanCapacity)" +
            "VALUES (?,?,?,?,?)", hall.getCity(),hall.getPostcode(),hall.getStreet(),hall.getBuildingNumber(),hall.getFanCapacity());
        return 1;
    }

}
