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
        Orianna.setRiotAPIKey("RGAPI-ce596284-c665-4bdb-9f5a-1b357835e527"); // must be blank API key before committing

        playersParser = new PlayersParser("LeeWooJin joined the lobby\n" +
                "college board xd joined the lobby\n" +
                "UofT UBC McGill joined the lobby\n" +
                "DoinADoinBDoinZ joined the lobby\n" +
                "demoliser joined the lobby", "LeeWooJin");
    }

    @Test
    void testFilterLobbyText() {
        assertEquals("LeeWooJin\n" + "college board xd\n" + "UofT UBC McGill\n" + "DoinADoinBDoinZ\n" +
                "demoliser", playersParser.filterLobbyText());
    }

    @Test
    void testLobbyTextToPlayerNames() {
        List<String> names = new ArrayList<>(Arrays.asList("college board xd", "UofT UBC McGill", "DoinADoinBDoinZ", "demoliser"));
        playersParser.setPlayerNames();
        assertEquals(names, playersParser.getPlayerNames());
    }

    @Test
    void testPlayerNamesToPlayers() {
        List<Player> players = new ArrayList<>(Arrays.asList(new Player("college board xd"),
                new Player("UofT UBC McGill"), new Player("DoinADoinBDoinZ"), new Player("demoliser")));

        playersParser.setPlayerNames();

        assertEquals(players, playersParser.getPlayers());
    }
}
