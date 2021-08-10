import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerInfoTest {
    private PlayerInfo playerInfo;
    private Summoner summoner;
    private Player player;

    @BeforeEach
    public void setup() {
        Orianna.setRiotAPIKey("RGAPI-3f69808b-690a-4c8d-8119-d73f5b23b23f"); // must be blank API key before committing
        summoner = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        player = new Player(summoner);
        playerInfo = new PlayerInfo(summoner);
    }

    @Test
    public void testPlayerInfo() {
        assertEquals("LeeWooJin", playerInfo.getName());
        assertEquals(60.3, playerInfo.getWinRate());
    }
}
