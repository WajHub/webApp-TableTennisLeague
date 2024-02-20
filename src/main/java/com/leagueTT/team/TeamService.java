package com.leagueTT.team;

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
        return teamRepository.getAll();
    }

    public Team getTeam(int id) { return teamRepository.getTeamById(id);}
}
