package com.leagueTT.player;

import com.leagueTT.team.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getLong("p.Id"));
        player.setPesel(rs.getString("p.Pesel"));
        player.setNameP(rs.getString("p.NameP"));
        player.setSurname(rs.getString("p.Surname"));
        player.setDateOfBirth(rs.getDate("p.DateOfBirth"));
        player.setNationality(rs.getString("p.Nationality"));
        player.setHeight(rs.getInt("p.Height"));
        player.setWeight(rs.getInt("p.WeightP"));
        player.setHand(rs.getString("p.Hand"));
        player.setBlade(rs.getString("p.Blade"));
        player.setImgUrl(rs.getString("p.ImgURL"));

        Team team = new Team();
        team.setId(rs.getLong("th.Id"));
        team.setNameT(rs.getString("th.NameT"));
        team.setLogoURL(rs.getString("th.LogoURL"));

        player.setTeam(team);
        return player;
    }
}
