import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Summoner summoner;
    Player player;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        player = new Player(summoner);
    }

    @Test
    void testGetWins() {
        assertEquals(69, player.getWins());
    }

    @Test
    void testGetLosses() {
        assertEquals(42, player.getLosses());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI94", player.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals("62.1%", player.getWinRate());
    }

    @Test
    void testGetWinStreak() {
        assertTrue(player.getWinStreak(summoner));
    }

    @Test
    void testGetLossStreak() {
        assertFalse(player.getLossStreak(summoner));
    }

    @Test
    void testGetLastTenGames() {
        ArrayList<String> matches = new ArrayList<>();
        matches.add("W");
        for(int i = 0; i < 3; i++) {
            matches.add("L");
        }
        matches.add("W");
        matches.add("L");
        for(int i = 0; i < 4; i++) {
            matches.add("W");
        }

        assertEquals(matches, player.getLastTenGameOutcomes(summoner));
    }

    @Test
    void testGetLanes() {
        ArrayList<String> lanes = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            lanes.add("JUNGLE");
        }

        assertEquals(lanes, player.getLanes(summoner));
    }

    @Test
    void testGetRoles() {
        ArrayList<String> roles = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            roles.add("JUNGLE");
        }

        assertEquals(roles, player.getRoles(summoner));
    }
}