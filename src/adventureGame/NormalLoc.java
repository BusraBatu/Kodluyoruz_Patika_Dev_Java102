package adventureGame;

public class NormalLoc extends Location{
    public NormalLoc(Player player, String name){
        super(player, name);

    }
     public boolean onLocation() {

        return true;
    }
}
