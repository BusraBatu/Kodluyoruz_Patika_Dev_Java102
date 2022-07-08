package adventureGame;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are in " + this.getName());
        System.out.println("Be Careful! " + this.randomObstacleNumber() + " " + this.getObstacle().getName() + " live in here!");
        System.out.println("<F>ight or <R>un");
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)) {

            System.out.println("You beat the all enemies in " + this.getName());
            return true;


        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i >= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<F>ight or <R>un");
                String selectCombat = scan.nextLine().toUpperCase();
                if (selectCombat.equals("F")) {
                    System.out.println();
                    obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Obstacle hit you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You win!");
                System.out.println("You earned " + this.getObstacle().getAward() + " money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Current money: " + this.getPlayer().getMoney());

            } else {
                return false;
            }

        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + "'s Health: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Values: ");
        System.out.println("-----------------------");
        System.out.println("Health:" + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Player Values");
        System.out.println("---------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInv().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInv().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInv().getArmor().getBlock());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println();

    }

    public int randomObstacleNumber() {
        Random r = new Random();

        return r.nextInt(this.getMaxObstacle()) + 1;

    }
}
