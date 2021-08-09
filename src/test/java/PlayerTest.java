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
        Orianna.setRiotAPIKey("RGAPI-99810730-272d-43e8-8a77-cc788ad835f1"); // must be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        player = new Player(summoner);
    }

    @Test
    void testGetName() {
        assertEquals("LeeWooJin", player.getName());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI50", player.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals(60.3, player.getWinRate());
    }

    @Test
    void testGetWinStreak() {
        assertFalse(player.getWinStreak());
    }

    @Test
    void testGetLossStreak() {
        assertFalse(player.getLossStreak());
    }

    @Test
    void testGetLastTenGameOutcomes() {
        ArrayList<String> matches = new ArrayList<>();
        matches.add("W");
        for(int i = 0; i < 4; i++) {
            matches.add("L");
        }
        matches.add("W");
        matches.add("L");
        for(int i = 0; i < 2; i++) {
            matches.add("W");
        }
        matches.add("L");
        assertEquals(matches, player.getLastTenGameOutcomes());
    }

    @Test
    void testGetPreferredPosition() {
        assertEquals("JUNGLE", player.getPreferredPosition());
    }
}