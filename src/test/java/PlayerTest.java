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
        Orianna.setRiotAPIKey("RGAPI-d1022d42-ce8a-497e-8921-5ac1366bc39a"); // must be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        player = new Player(summoner);
    }

    @Test
    void testGetWins() {
        assertEquals(68, player.getWins());
    }

    @Test
    void testGetLosses() {
        assertEquals(42, player.getLosses());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI76", player.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals("61.8%", player.getWinRate());
    }

    @Test
    void testGetWinStreak() {
        assertFalse(player.getWinStreak(summoner));
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
}