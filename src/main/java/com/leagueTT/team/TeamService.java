package com.leagueTT.team;

import com.leagueTT.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(){
        List<Team> teams = teamRepository.getAllTeams();
        for(int i=0;i<teams.size();i++){
            Team temp = teams.get(i);
            temp.setNumberOfWins(teamRepository.getNumberOfWinsByTeam(i+1));
            temp.setNumberOfLosses(teamRepository.getNumberOfLosesByTeam(i+1));
            temp.setNumberOfPoints(temp.getNumberOfLosses()+temp.getNumberOfWins()*2);
            temp.setNumberOfMatches(teamRepository.getNumberOfMatchesByTeam(i+1));
        }
        return teams;
    }
    public Team getTeam(int id) {
        Team temp = teamRepository.getTeamById(id);
        temp.setNumberOfWins(teamRepository.getNumberOfWinsByTeam(id));
        temp.setNumberOfLosses(teamRepository.getNumberOfLosesByTeam(id));
        temp.setNumberOfPoints(temp.getNumberOfLosses()+temp.getNumberOfWins()*2);
        temp.setNumberOfMatches(teamRepository.getNumberOfMatchesByTeam(id));
        return temp;}

    public List<Player> getPlayers(int idTeam){
        return teamRepository.getPlayersFromTeam(idTeam);
    }

    public List getGames(int idTeam) {
        return teamRepository.getGames(idTeam);
    }


}
