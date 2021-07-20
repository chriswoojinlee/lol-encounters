import java.util.Set;

// Represents current game lobby of all 5 summoners including the user
public class Lobby {
    private Set<Player> summoners;  // summoners in the current lobby

    // create a new lobby with all summoners loaded in and without criteria points calculated
    public Lobby(Set<Player> summoners) {
        this.summoners = summoners;
    }
}
