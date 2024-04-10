package com.leagueTT.player;

import com.leagueTT.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController( PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String players(Model model){
        model.addAttribute("players", playerService.getPlayers());
        return "public/players";
    }

    @GetMapping("/{id}")
    public String player(Model model, @PathVariable int id){
        model.addAttribute("player", playerService.getPlayer(id));
        return "public/player";
    }

}
