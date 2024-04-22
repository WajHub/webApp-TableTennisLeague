package com.leagueTT.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leagueTT.game.Game;
import com.leagueTT.game.GameService;
import com.leagueTT.player.PlayerService;
import com.leagueTT.singlesMatch.SingleMatchService;
import com.leagueTT.singlesMatch.SinglesMatch;
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
    private final PlayerService playerService;
    private final SingleMatchService singleMatchService;

    @Autowired
    public UserController(GameService gameService, TeamService teamService, PlayerService playerService,SingleMatchService singleMatchService) {
        this.gameService = gameService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.singleMatchService = singleMatchService;
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin/content")
    public String adminContent(Model model){
        model.addAttribute("games", gameService.getGames());
        model.addAttribute("teams", teamService.getTeams());
        model.addAttribute("players", playerService.getPlayers());
//        model.addAttribute("singleMatches", singleMatchService.getAll());
        return "adminContent";
    }

    // TODO: Sprawdzenie poprawnosci danych
    @PostMapping("/admin/addMatch")
    public String addMatch(@RequestBody String body){
        JsonObject data = JsonParser.parseString(body).getAsJsonObject();
        int homeId = data.get("homeTeamId").getAsInt();
        int guestId = data.get("guestTeamId").getAsInt();
        Team homeTeam = teamService.getTeam(homeId);
        Team guestTeam = teamService.getTeam(guestId);
        int round = data.get("round").getAsInt();

        String dateString = data.get("date").getAsString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =  LocalDate.parse(dateString, formatter);
        gameService.saveGame(new Game(round,  date, -1, 0, 0, homeTeam.getId(), guestTeam.getId()));
        return "redirect:/api/admin";
    }


    @PostMapping("/admin/deleteMatch/{id}")
    public String deleteMatch(@PathVariable("id") int id){
        singleMatchService.deleteMatches(id);
        gameService.delete(id);
        return "redirect:/api/admin";
    }

    // TODO: Sprawdzenie poprawnosci danych
    @PostMapping("/admin/addSingleMatch")
    public String addSingleMatch(@RequestBody String param){
        JsonObject data = JsonParser.parseString(param).getAsJsonObject();
        int resultHome = data.get("resultPlayerHome").getAsInt();
        int resultGuest = data.get("resultPlayerGuest").getAsInt();
        long idGame = data.get("idGame").getAsInt();
        long playerHome = data.get("playerHome").getAsInt();
        long playerGuest = data.get("playerGuest").getAsInt();
        singleMatchService.save(new SinglesMatch(resultHome, resultGuest, idGame, playerHome, playerGuest));
        return "redirect:/api/admin";
    }
    
}
