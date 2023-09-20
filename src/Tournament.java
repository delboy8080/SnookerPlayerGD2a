import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tournament
{
    private ArrayList<SnookerPlayer> players;
    private String name;
    private  double prize;

    public Tournament(String name) {
        this.name = name;
        this.prize = 10000;
        players = new ArrayList<>();
    }

    public Tournament(ArrayList<SnookerPlayer> players, String name, double prize) {
        this.players = players;
        this.name = name;
        this.prize = prize;
    }

    public void increaseAll(double amnt)
    {
        for(SnookerPlayer p : players )
        {
            p.increasePrizeMoney(amnt);
        }
    }
    public void addPlayer(SnookerPlayer plyr)
    {
        players.add(plyr);
    }
    public void display()
    {
        System.out.println("=========================="+name+"================================");
        System.out.printf("%20s%5s%5s%10s\n", "Name", "W", "P", "Amount");
        for(SnookerPlayer p : players )
        {
            System.out.printf("%20s%5d%5d%10.2f\n", p.getName(), p.getGamesWon(), p.getGamesPlayed(),
                    p.getPrizeMoney());
        }
        System.out.println("\n\n");
    }
    public void sort()
    {
        Collections.sort(players);
        display();
    }
    public double getTotalPrizeOfPlayers()
    {
        double total = 0;
        for(SnookerPlayer sp: players)
        {
            total += sp.getPrizeMoney();
        }
        return total;
    }

    public void Result(String winner, String loser)
    {
        boolean foundWinner = false;
        boolean foundLoser = false;

        for(SnookerPlayer p : players)
        {
            if(p.getName().equalsIgnoreCase(winner))
            {
                p.updatePerformance(true);
                foundWinner = true;
            }
            else  if(p.getName().equalsIgnoreCase(loser))
            {
                p.updatePerformance(false);
                foundLoser = true;
            }
        }
        if(!foundWinner){
            System.out.println("Winner could not be found");
        }
        else if(!foundLoser) {
            System.out.println("Loser could not be found!");
        }
    }

    public void playTournament()
    {
        Random rand = new Random();
        for(int i = 0; i < players.size();i++)
            for(int j = i+1; j < players.size();j++)
            {
                SnookerPlayer p1 = players.get(i);
                SnookerPlayer p2 = players.get(j);
                int score1 = rand.nextInt(10);
                int score2 = rand.nextInt(10);
                if(score1 > score2)
                {
                    Result(p1.getName(), p2.getName());
                }
                else if(score1 < score2)
                {
                    Result(p2.getName(), p1.getName());
                }
                else
                {
                    p1.updatePerformance(true);
                    p2.updatePerformance(true);
                }

            }
    }
    @Override
    public String toString() {
        return "Tournament{" +
                "players=" + players +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }
}
