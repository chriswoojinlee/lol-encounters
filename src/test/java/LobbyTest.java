import com.merakianalytics.orianna.Orianna;
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
        List<Player> players = new ArrayList<>();

        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        user = new User("LeeWooJin");
        player1 = new Player("college board xd");
        player2 = new Player("UofT UBC McGill");
        player3 = new Player("DoinADoinBDoinZ");
        player4 = new Player("Tactical");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        lobby = new Lobby(players, user);
    }

    @Test
    public void testFindBlacklistedPlayersInLobby() {
        List<Player> blacklistedPlayers = new ArrayList<>();
        blacklistedPlayers.add(new Player("UofT UBC McGill"));
        blacklistedPlayers.add(new Player("Tactical"));

        user.addToBlacklist("UofT UBC McGill");
        user.addToBlacklist("Tactical");

        assertEquals(blacklistedPlayers, lobby.findBlacklistedPlayersInLobby());
    }


}
