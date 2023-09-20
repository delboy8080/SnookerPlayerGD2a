public class SnookerPlayer implements Comparable<SnookerPlayer>
{

    String name;
    String nationality;
    double prizeMoney;
    int gamesWon;
    int gamesPlayed;

    public SnookerPlayer(String name, String nationality, double prizeMoney, int gamesWon, int gamesPlayed) {
        this.name = name;
        this.nationality = nationality;
        this.prizeMoney = prizeMoney;
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
    }
    public SnookerPlayer()
    {
        this.name = "Default";
        this.nationality = "Irish";
        this.prizeMoney = this.gamesPlayed = this.gamesWon = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(double prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public void increasePrizeMoney(double amnt)
    {
        this.prizeMoney += amnt;
    }

    public void updatePerformance(boolean won)
    {
        if(won)
            gamesWon++;
        gamesPlayed++;
    }
    @Override
    public String toString() {
        return "SnookerPlayer{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", prizeMoney=" + prizeMoney +
                ", gamesWon=" + gamesWon +
                ", gamesPlayed=" + gamesPlayed +
                '}';
    }

    @Override
    public int compareTo(SnookerPlayer o)
    {
        if(o.getGamesWon() > gamesWon)
        {
            return 1;
        }
        else if(o.getGamesWon() < gamesWon)
        {
            return -1;
        }
        else
        {
            return  gamesPlayed - o.getGamesPlayed();
        }
    }
}
