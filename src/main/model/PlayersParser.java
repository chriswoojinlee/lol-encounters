package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayersParser {
    private String lobbyText;
    private String userName;
    private List<String> playerNames;

    public PlayersParser(String lobbyText, String userName) {
        this.lobbyText = lobbyText;
        this.userName = userName;
    }

    public List<Player> getPlayers() {
        setPlayerNames();
        List<Player> players = new ArrayList<>();

        for(String name : playerNames) {
            if(new Player(name) != null) {
                players.add(new Player(name));
            }
        }

        return players;
    }

    public void setPlayerNames() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(filterLobbyText().split(System.getProperty("line.separator"))));

        playerNames = filterOutUser(names);
    }

    public List<String> filterOutUser(ArrayList<String> names) {
        for(int i = 0; i < names.size(); i++) {
            if(names.get(i).equals(userName)) {
                names.remove(i);
            }
        }

        return names;
    }

    public String filterLobbyText() {
        return lobbyText.replaceAll(" joined the lobby", "\n");
    }
}
