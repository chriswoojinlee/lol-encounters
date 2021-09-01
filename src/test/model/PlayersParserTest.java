package model;

import com.merakianalytics.orianna.Orianna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersParserTest {
    PlayersParser playersParser;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey("RGAPI-9cf02e96-0ea2-4606-9c0b-0cb79be20ffb"); // must be blank API key before committing

//        playersParser = new PlayersParser("LeeWooJin joined the lobby\n" +
//                "college board xd joined the lobby\n" +
//                "UofT UBC McGill joined the lobby\n" +
//                "DoinADoinBDoinZ joined the lobby\n" +
//                "demoliser joined the lobby", "LeeWooJin");

        playersParser = new PlayersParser("LeeWooJin joined the lobby" + "college board xd joined the lobby"
                + "UofT UBC McGill joined the lobby" + "DoinADoinBDoinZ joined the lobby" +
                "demoliser joined the lobby", "LeeWooJin");

    }

    @Test
    void testFilterLobbyText() {
        assertEquals("LeeWooJin\n" + "college board xd\n" + "UofT UBC McGill\n" + "DoinADoinBDoinZ\n" +
                "demoliser\n", playersParser.filterLobbyText());
    }


    @Test
    void testPlayerNamesToPlayers() {
        List<Player> players = new ArrayList<>(Arrays.asList(new Player("college board xd"),
                new Player("UofT UBC McGill"), new Player("DoinADoinBDoinZ"), new Player("demoliser")));

        assertEquals(players, playersParser.getPlayers());
    }
}
