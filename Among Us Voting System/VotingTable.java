import java.util.ArrayList;

public class VotingTable{

    public static void main(String[] args) {
        ArrayList<Player> players = generatePlayers();
        int[] votes = new int[11];

        for(Player p : players){
            Player voted_out = p.random_vote(players);
            if(voted_out == null){
                votes[10] += 1;
            }
            else{
                int index = players.indexOf(voted_out);
                votes[index] += 1;
            }
        }
        System.out.print(votes.toString());

        int max = 0;
        int max_index = 0;
        for(int x = 0; x < votes.length; x++){
            if(votes[x] > max){
                max = votes[x];
                max_index = x;
            }
        }

        Player ejected = players.get(max_index);

        System.out.println("Ejected " + ejected.color);
    }

    public static ArrayList<Player> generatePlayers(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Red", false));
        players.add(new Player("Green", false));
        players.add(new Player("Blue", false));
        players.add(new Player("Lime", true));
        players.add(new Player("Orange", false));
        players.add(new Player("Black", false));
        players.add(new Player("White", true));
        players.add(new Player("Dark Blue", false));
        players.add(new Player("Yellow", false));
        players.add(new Player("Cyan", false));
        return players;
    }
}