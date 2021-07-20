import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;

public class main {
    public static void main(String args[]) {
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
    }
}
