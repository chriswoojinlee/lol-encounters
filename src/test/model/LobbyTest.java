package model;

import com.merakianalytics.orianna.types.core.match.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LobbyTest {
    private Lobby lobby;
    private User user;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    public void setup() {
        user = new User("LeeWooJin");
    }

    @Test
    public void testFindPreviouslySharedMatches() {
        List<Match> matches = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        player1 = new Player("Nicht Nichts");
        player2 = new Player("jungle player");
        player3 = new Player("OPEN BOT");
        player4 = new Player("Native Turtle");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        matches.add(user.getMatch(0));

        lobby = new Lobby(user);

        assertEquals(matches, lobby.findPreviouslySharedMatches("Nicht Nichts"));
        assertEquals(matches, lobby.findPreviouslySharedMatches("jungle player"));
        assertEquals(matches, lobby.findPreviouslySharedMatches("OPEN BOT"));
        assertEquals(matches, lobby.findPreviouslySharedMatches("Native Turtle"));
    }


}
