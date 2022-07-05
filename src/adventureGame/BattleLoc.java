package adventureGame;

public abstract class BattleLoc extends Location {
    Obstacle obstacle;
    public BattleLoc(Obstacle o){

    }

    @Override
    public boolean onLocation() {
        return true;
    }
    public void combat(){

    }
}
