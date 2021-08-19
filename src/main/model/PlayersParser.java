package model;

import java.util.ArrayList;
import java.util.List;

public class PlayersParser {
    private String lobbyText;
    private ArrayList<String> playerNames;

    public PlayersParser(String lobbyText) {
        this.lobbyText = lobbyText;
    }

    public String filterLobbyText() {
        return lobbyText.replaceAll("[\\d]", "");
    }

    public ArrayList<String> lobbyTextToPlayerNames() {

    }

    public ArrayList<Player> playerNamesToPlayers() {

    }

}
