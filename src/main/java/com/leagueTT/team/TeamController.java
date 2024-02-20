package com.leagueTT.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("teams",teamService.getTeams());
        return "teams";
    }

    @GetMapping("/{id}")
    public Team teamView(Model model, @PathVariable("id") int id){
        //model.addAttribute("team",teamService.getTeam(id));
       // return "team";
        return teamService.getTeam(id);
    }

}
