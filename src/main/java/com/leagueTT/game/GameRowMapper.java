package com.leagueTT.game;

import com.leagueTT.team.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getLong("Id"));
        game.setRound(rs.getInt("Round"));
        game.setDateOfMatch(rs.getDate("DateOfMatch").toLocalDate());
        game.setNumberOfSupporters(rs.getInt("NumberOfSupporters"));
        game.setResultHome(rs.getInt("ResultHome"));
        game.setResultGuest(rs.getInt("ResultGuest"));

        // NIEPEŁNE UTWORZENIE OBJEKTÓW TEAM!!!
        Team teamHome = new Team();
        teamHome.setId(rs.getLong("th.Id"));
        teamHome.setNameT(rs.getString("th.NameT"));
        teamHome.setLogoURL(rs.getString("th.LogoURL"));
        Team teamGuest = new Team();
        teamGuest.setId(rs.getLong("tg.Id"));
        teamGuest.setNameT(rs.getString("tg.NameT"));
        teamGuest.setLogoURL(rs.getString("tg.LogoURL"));

        game.setTeamHome(teamHome.getId());
        game.setTeamGuest(teamGuest.getId());
        return game;
    }
}
