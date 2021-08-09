import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Summoner summoner;
    User user;
    Player player;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        user = new User(summoner);
        player = new Player(user, summoner);
    }

    @Test
    void testGetName() {
        assertEquals("LeeWooJin", player.getName());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI45", player.getCurrentRank());
    }

    @Test
    void testGetLastTenGameOutcomes() {

    }
}