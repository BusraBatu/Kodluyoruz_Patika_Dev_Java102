package adventureGame;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public Scanner scan = new Scanner(System.in);

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public boolean onLocation() {

        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are in " + this.getName());
        System.out.println("Be Careful! " + this.randomObstacleNumber() + " " + this.getObstacle().getName() + " live in here!");
        System.out.println("Fight<Y> or Run<N>");
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("Y")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " you have won on this map.");
                if (this.award.equals("Food") && getPlayer().getInv().isFood() == false) {
                    this.getPlayer().getInv().setFood(true);
                    System.out.println(this.award + " inventory added!");
                } else if (this.award.equals("Water") && getPlayer().getInv().isWater() == false) {
                    System.out.println(this.award + " inventory added!");
                    this.getPlayer().getInv().setWater(true);
                } else if (this.award.equals("Firewood") && getPlayer().getInv().isFirewood() == false) {
                    System.out.println(this.award + " inventory added!");
                    this.getPlayer().getInv().setFirewood(true);
                }
                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died!");
            return false;
        }
        return true;
    }
    /*

     public int printStart() {
        int obsCount = obstacle.count();
        System.out.println("You are here now : " + this.getName());
        System.out.println("Be aware ! " + obsCount + " " + obstacle.getName() + "s lives there!");
        System.out.print("<F>ight or <R>un :");
        return obsCount;
    }

     public boolean getLocationMines() {
        Scanner scan = new Scanner(System.in);
        int obsCount = printStart();
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("F")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " has been cleared !");

                Random random = new Random();
                int luckyNumber = random.nextInt(101);

                if (luckyNumber >= 55) {
                    System.out.println("You've won nothing");
                } else if (luckyNumber >= 30) {
                    System.out.println("You won random amount of money!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("You won 1 money! ");
                        player.setMoney(player.getMoney() + 1);
                    } else if (luckyNumber >= 20) {
                        System.out.println("You won 3 money! ");
                        player.setMoney(player.getMoney() + 3);
                    } else {
                        System.out.println("Jackpot! You won 10 money! ");
                        player.setMoney(player.getMoney() + 10);
                    }
                } else if (luckyNumber >= 15) {
                    System.out.println("You won random armour!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("You won light armour! ");
                        if (player.getInventory().getArmorDefence() > 1) {
                            System.out.println("But you have better armour! No changes");
                        } else {
                            player.getInventory().setArmorDefence(1);
                            System.out.println("You equipped your armour !");
                        }
                    } else if (luckyNumber >= 20) {
                        System.out.println("You won medium armour! ");
                        if (player.getInventory().getArmorDefence() > 3) {
                            System.out.println("But you have better armour! No changes");
                        } else {
                            player.getInventory().setArmorDefence(3);
                            System.out.println("You equipped your armour !");
                        }
                    } else {
                        System.out.println("You won heavy armour! ");
                        if (player.getInventory().getArmorDefence() > 5) {
                            System.out.println("But you have better armour! No changes");
                        } else {
                            player.getInventory().setArmorDefence(5);
                            System.out.println("You equipped your armour !");
                        }
                    }
                } else {
                    System.out.println("You won random weapon!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("You won gun! ");
                        if (player.getInventory().getWeaponDamage() > 2) {
                            System.out.println("But you have better weapon! No changes");
                        } else {
                            player.getInventory().setWeaponDamage(2);
                            System.out.println("You equipped your weapon !");
                        }
                    } else if (luckyNumber >= 20) {
                        System.out.println("You won medium weapon! ");
                        if (player.getInventory().getWeaponDamage() > 3) {
                            System.out.println("But you have better armour! No changes");
                        } else {
                            player.getInventory().setWeaponDamage(3);
                            System.out.println("You equipped your armour !");
                        }
                    } else {
                        System.out.println("You won heavy armour! ");
                        if (player.getInventory().getWeaponDamage() > 7) {
                            System.out.println("But you have better armour! No changes");
                        } else {
                            player.getInventory().setWeaponDamage(7);
                            System.out.println("You equipped your armour !");
                        }
                    }
                }

                return true;
            }

            if (player.getHealthy() <= 0) {
                System.out.println("You died !");
                return false;
            }

        }
        return true;
    }
     */

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("Fight<Y> or Run<N>");
                String selectCombat = scan.nextLine().toUpperCase();
                if (selectCombat.equals("Y")) {
                    System.out.println();
                    System.out.println("You hit obstacle!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
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
                System.out.println("You won!");
                System.out.println("You earned " + this.getObstacle().getAward() + " money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Current money: " + this.getPlayer().getMoney());
                this.getObstacle().setHealth(obstacle.getOriginalHealth());

            } else {
                return false;
            }

        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + "'s Health: " + this.getObstacle().getHealth());
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Values: ");
        System.out.println("--------------------------------------------");
        System.out.println("Health:" + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Player Values");
        System.out.println("--------------------------------------------");
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


}
