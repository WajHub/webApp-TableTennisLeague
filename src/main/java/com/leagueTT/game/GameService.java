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

    public Game getGame(long id){
        return  gameRepository.getGame(id);
    }

    public int delete(int id) {
        gameRepository.delete(id);
        return 1;
    }

    public int incrementResultHome(Long gameId) {
        gameRepository.incrementResultHome(gameId);
        return 1;
    }

    public int  incrementResultGuest(Long game) {
        gameRepository.incrementResultGuest(game);
        return 1;
    }
}
