package com.leagueTT.team;

import com.leagueTT.game.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private TeamService teamService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }



}