import java.util.Objects;

public class PlayerInfo extends Player {
    private String notes;
    private String reasons;

    public PlayerInfo(String playerName) {
        super(playerName);
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setReasonsForBlacklist(String reasons) {
        this.reasons = reasons;
    }

    public String getNotes() {
        return notes;
    }

    public String getReasonsForBlacklist() {
        return reasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInfo that = (PlayerInfo) o;
        return Objects.equals(notes, that.notes) && Objects.equals(reasons, that.reasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes, reasons);
    }
}


