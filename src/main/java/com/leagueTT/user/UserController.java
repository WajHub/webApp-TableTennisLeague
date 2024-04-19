package com.leagueTT.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leagueTT.game.Game;
import com.leagueTT.game.GameService;
import com.leagueTT.team.Team;
import com.leagueTT.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




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

    @PostMapping("/admin/addMatch")
    public String addMatch(@RequestBody String body){
        JsonObject data = JsonParser.parseString(body).getAsJsonObject();
        int homeId = data.get("homeTeamId").getAsInt();
        int guestId = data.get("guestTeamId").getAsInt();
        Team homeTeam = teamService.getTeam(homeId);
        Team guestTeam = teamService.getTeam(guestId);

        String dateString = data.get("date").getAsString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =  LocalDate.parse(dateString, formatter);
        gameService.saveGame(new Game(-1,  date, -1, 0, 0, homeTeam.getId(), guestTeam.getId()));
        return "redirect:/api/admin";
    }

    @PostMapping("/admin/deleteMatch/{id}")
    public String deleteMatch(@PathVariable("id") int id){
        gameService.delete(id);
        return "redirect:/api/admin";
    }
    
}
