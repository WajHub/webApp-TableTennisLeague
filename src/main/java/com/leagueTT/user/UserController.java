package com.leagueTT.user;

import com.leagueTT.game.GameService;
import com.leagueTT.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class UserController {

    private final GameService gameService;

    private final TeamService teamService;

    @Autowired
    public UserController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin/content")
    public String adminContent(Model model){
        model.addAttribute("games", gameService.getGames());
        model.addAttribute("teams", teamService.getTeams());
        return "adminContent";
    }
    
}
