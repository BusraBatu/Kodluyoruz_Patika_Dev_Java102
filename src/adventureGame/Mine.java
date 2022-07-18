package adventureGame;

import java.util.Random;

public class Mine extends BattleLoc {

    static Random random = new Random();

    public Mine(Player player) {
        super(player, "Mine", new Snake(random.nextInt(3) + 4), "Money/Gun/Armor", 5);
    }
}
