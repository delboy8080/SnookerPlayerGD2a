import java.util.ArrayList;

public class MainApp
{
    public static void main(String[] args) {
        ArrayList<SnookerPlayer> players = new ArrayList<>();
        players.add(new SnookerPlayer("John Doe", "Irish",0,0,0));
        players.add(new SnookerPlayer("Tony Stark", "Welsh",0,0,0));
        players.add(new SnookerPlayer("Steve Rodgers", "American",0,0,0));

        Tournament worldChampionships = new Tournament(players, "World Championship",3000000);
        worldChampionships.display();
        worldChampionships.increaseAll(10000);
        worldChampionships.display();
        players.get(0).updatePerformance(true);
        players.get(1).updatePerformance(false);

        players.get(0).updatePerformance(true);
        players.get(2).updatePerformance(false);
        players.get(2).updatePerformance(true);
        players.get(1).updatePerformance(false);

        worldChampionships.display();

        worldChampionships.addPlayer(new SnookerPlayer("Bruce Banner", "Greek", 0,5, 10));
        worldChampionships.display();

        Tournament ukMas = new Tournament("UK Masters");
        ukMas.addPlayer(players.get(1));
        ukMas.addPlayer(players.get(2));

        ukMas.display();

        worldChampionships.sort();

        worldChampionships.Result("Tony Stark", "Bruce Banner");
        worldChampionships.sort();

    }
}
