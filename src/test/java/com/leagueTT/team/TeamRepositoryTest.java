package com.leagueTT.team;

import com.leagueTT.hall.Hall;
import com.leagueTT.hall.HallRepository;
import com.leagueTT.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository underTest;

    @Autowired
    HallRepository hallRepository;

    @Test
    void getTeamById(){
        // given
        int id = 1;
        Hall hall = new Hall("Gdansk", "73-240", "Lipcowa", 16,1600);
        Team expectedTeam = new Team("nameExpected",2000,"Tibhar","Tibhar", "LogoURL", hall, null);
        hallRepository.save(hall);
        underTest.save(expectedTeam);

        // when
        Team actualTeam = underTest.getTeamById(id);

        // then
        assertEquals(expectedTeam, actualTeam);
    }

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

}
