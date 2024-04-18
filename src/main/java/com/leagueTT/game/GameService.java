package com.leagueTT.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leagueTT.game.Game;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {this.gameRepository = gameRepository;}

    public List getGames(){
        return gameRepository.getAllGames();
    }

    public int saveGame(Game game){
        gameRepository.save(game);
        return 1;
    }

}
