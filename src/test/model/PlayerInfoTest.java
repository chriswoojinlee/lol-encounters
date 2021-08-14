package model;

import com.merakianalytics.orianna.Orianna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerInfoTest {
    private PlayerInfo playerInfo;

    @BeforeEach
    public void setup() {
        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        playerInfo = new PlayerInfo("LeeWooJin");
    }

    @Test
    public void testPlayerInfo() {
        assertEquals("LeeWooJin", playerInfo.getName());
        assertEquals(60.3, playerInfo.getWinRate());
    }
}
