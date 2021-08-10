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
        Orianna.setRiotAPIKey("RGAPI-250b3e41-ff88-4a22-af9d-81a7f55a5bec"); // must be blank API key before committing
        player = new Player("LeeWooJin");
        playerInfo = new PlayerInfo("LeeWooJin");
    }

    @Test
    public void testPlayerInfo() {
        assertEquals("LeeWooJin", playerInfo.getName());
        assertEquals(60.3, playerInfo.getWinRate());
    }
}
