package adventureGame;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inv;

    public Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar() {
        System.out.println("--------------------------------------------");
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter each : charList) {
            System.out.println("Characters");
            System.out.println("--------------------------------------------");
            System.out.println("ID: " + each.getID() +
                    "\t Character: " + each.getName() +
                    "\t Damage: " + each.getDamage() +
                    "\t Health: " + each.getHealth() +
                    "\t Money: " + each.getMoney());
        }
        System.out.println("--------------------------------------------");
        System.out.println("Please select a character: ");
        int selectChar = scan.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println("Character: " + this.getCharName() +
                ", Damage: " + this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());


    }

    public void initPlayer(GameCharacter gameCharacter) {

        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setOrjinalHealth(gameCharacter.getHealth());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void selectLocation() {
        Location location = null;
        while (true) {
            if (isWin(this)) {
                System.out.println("You won the game!");
                break;
            }
            System.out.println("--------------------------------------------");
            System.out.println("*********** Locations ************");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Cave");
            System.out.println("4- Forest");
            System.out.println("5- River");
            System.out.println("6- Mine");
            System.out.println("0- Exit");
            System.out.print("Please select your location: ");
            int selectLoc = scan.nextInt();
            while (selectLoc < 0 || selectLoc > 6) {
                System.out.print("Please enter a valid input : ");
                selectLoc = scan.nextInt();
            }
            switch (selectLoc) {

                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    if (!this.getInv().isFirewood())
                        location = new Forest(this);
                    else {
                        System.out.println("You cannot enter that area again! ");
                    }
                    break;
                case 4:
                    if (!this.getInv().isFood())
                        location = new Cave(this);
                    else {
                        System.out.println("You cannot enter that area again! ");
                    }
                    break;
                case 5:
                    if (!this.getInv().isWater())
                        location = new River(this);
                    else {
                        System.out.println("You cannot enter that area again! ");
                    }
                    break;
                case 6:
                    location = new Mine(this);
                    break;
                default:
                    location = new SafeHouse(this);
                    break;

            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (this.getInv().isFirewood() && this.getInv().isFood() && this.getInv().isWater()) {
                    System.out.println("CONGRATULATIONS ON YOUR WIN.");
                    break;
                }
            }
            if (!location.onLocation()) {
                System.out.println("Game Over !");
                break;
            }
        }
    }


    public boolean isWin(Player player) {
        return getInv().isWater() && getInv().isFood() && getInv().isFirewood();

    }


    public void printInfo() {
        System.out.println("Weapon: " + this.getInv().getWeapon().getName() +
                ", Armor: " + this.getInv().getArmor().getName() +
                ", Block: " + this.getInv().getArmor().getBlock() +
                ", Damage: " + this.getTotalDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInv().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }


}
