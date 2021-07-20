import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(62, player.getWins());
    }

    @Test
    void testGetLosses() {
        assertEquals(38, player.getLosses());
    }
}
