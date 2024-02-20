package com.leagueTT.team;

import com.leagueTT.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Team team){
        jdbcTemplate.update("INSERT INTO Team(nameT, yearOfFundation, tables, balls, logoURL, IdHall)" +
                    "VALUES(?,?,?,?,?,?)",team.getNameT(),team.getYearOfFundation(),team.getTables(),team.getBalls(),team.getLogoURL(),team.getHall().getId());
    return 1;
    }

    public List<Team> getAll(){
        return jdbcTemplate.query(
                "SELECT Team.Id, Team.nameT,Team.logoURL,(count(Game.Id)) AS numberOfMatches,\n" +
                "\t-- Number of Wins\n" +
                "\t(count(CASE WHEN \n" +
                "\t(Game.ResultHome > 2 AND Game.IdHome=Team.Id) OR (Game.ResultGuest > 2 AND Game.IdGuest=Team.Id)\n" +
                "\tTHEN 1 END)) AS numberOfWins,\n" +
                "    -- Number of Losses\n" +
                "    (count(CASE WHEN \n" +
                "\t(Game.ResultHome < 3 AND Game.IdHome=Team.Id) OR (Game.ResultGuest < 3 AND Game.IdGuest=Team.Id)\n" +
                "\tTHEN 1 END)) AS numberOfLosses,\n" +
                "    -- Number Of Points\n" +
                "    (sum(CASE \tWHEN(Game.ResultHome=3 AND Game.IdHome=Team.Id AND Game.ResultGuest=2)THEN 1 -- Win 3:2 home\n" +
                "\t\t\t\tWHEN(Game.ResultHome=3 AND Game.IdHome=Team.Id AND Game.ResultGuest<2)THEN 2 -- Win 3:1 or 3:0 home\n" +
                "                WHEN(Game.ResultGuest=3 AND Game.IdGuest=Team.Id AND Game.ResultHome=2)THEN 1 -- Win 3:2 guest\n" +
                "\t\t\t\tWHEN(Game.ResultGuest=3 AND Game.IdGuest=Team.Id AND Game.ResultHome<2)THEN 2 -- Win 3:1 or 3:0 guest\n" +
                "                ELSE 0\n" +
                "    END)) AS numberOfPoints\n" +
                " FROM Team\n" +
                "LEFT JOIN Game ON Team.Id=Game.IdHome OR Team.Id=Game.IdGuest\n" +
                "group by Team.Id, Team.nameT,Team.logoURL;\n",BeanPropertyRowMapper.newInstance(Team.class));
    }

    public Team getTeamById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Team WHERE Id=?", BeanPropertyRowMapper.newInstance(Team.class), id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM Team");
    }
}
