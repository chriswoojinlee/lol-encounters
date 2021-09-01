package model;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
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
        Orianna.setRiotAPIKey("");
        user = new User("LeeWooJin");
    }

    @Test
    public void testFindPreviouslyEncounteredPlayers() {
        List<Match> matches = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        matches.add(user.getMatch(0));
        matches.add(user.getMatch(1));
        matches.add(user.getMatch(4));
        matches.add(user.getMatch(5));
        matches.add(user.getMatch(6));

        player1 = new Player("Why am l Bad");
        player2 = new Player("FirstTimeCaitlyn");
        player3 = new Player("Doojeeboy");
        player4 = new Player("Mavedon");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        lobby = new Lobby(players, user);

        assertEquals(matches, lobby.findPreviouslySharedMatches());
    }


}
