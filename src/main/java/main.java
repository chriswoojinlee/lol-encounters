import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;

public class main {
    public static void main(String args[]) {
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        Orianna.setRiotAPIKey("RGAPI-54494af6-09cb-415e-804f-3af3bd4b4df6");
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
    }
}
