import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Summoner summoner;
    Player player;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey(""); // should be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        player = new Player(summoner);
    }

    @Test
    void testGetWins() {
        assertEquals(63, player.getWins());
    }

    @Test
    void testGetLosses() {
        assertEquals(38, player.getLosses());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI53", player.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals("62.3%", player.getWinRate());
    }

    @Test
    void testGetPreviousRanks() {
        ArrayList<String> ranks = new ArrayList<>();
        ranks.add(0, "MASTER");
        ranks.add(1, "PLATINUM");
        assertEquals(ranks, player.getPreviousRanks());
    }
}
