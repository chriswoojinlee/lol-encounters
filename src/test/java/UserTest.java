import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey("RGAPI-99810730-272d-43e8-8a77-cc788ad835f1"); // must be blank API key before committing
        user = new User("LeeWooJin");
    }

    @Test
    void testUser() {
        assertEquals("LeeWooJin", user.getUser().getName());
        assertEquals(60.3, user.getUser().getWinRate());
    }

}
