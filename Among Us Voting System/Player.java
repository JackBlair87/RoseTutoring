import java.util.ArrayList;

public class Player {

    public String color;
    public boolean imposter;

    public Player(String colorType, boolean isImposter){
        imposter = isImposter;
        color = colorType;
    }

    public Player random_vote(ArrayList<Player> players){
        int random = (int) (Math.random() * (players.size()+1)) - 1;
        if(random == -1)
            return null;
        return players.get(random);
    }
}
