package ua.aleksanid.foxmasterbot.parser.giveaway;

public class Giveaway {
    private String gameName;
    private String link;

    public Giveaway() {
    }

    public Giveaway(String gameName, String link) {
        this.gameName = gameName;
        this.link = link;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Giveaway{" +
                "gameName='" + gameName + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
