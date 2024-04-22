package com.leagueTT.singlesMatch;

import com.leagueTT.game.Game;
import com.leagueTT.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleMatchService {
    private final SinglesMatchRepository singlesMatchRepository;
    private final GameService gameService;
    @Autowired
    public SingleMatchService(SinglesMatchRepository singlesMatchRepository, GameService gameService) {
        this.singlesMatchRepository = singlesMatchRepository;
        this.gameService = gameService;
    }

    public int save(SinglesMatch singlesMatch) {
        int i = singlesMatch.getResultPlayerHome() == 3 ? gameService.incrementResultHome(singlesMatch.getGame()) : gameService.incrementResultGuest(singlesMatch.getGame());
        if(singlesMatch.getResultPlayerGuest()<3 && singlesMatch.getResultPlayerHome()<3) return -1;
        return singlesMatchRepository.save(singlesMatch);
    }

    public int getAll(){
        return singlesMatchRepository.
                getAll();
    }

    public int deleteMatches(int id) {
        return singlesMatchRepository.deleteMatches(id);
    }
}
