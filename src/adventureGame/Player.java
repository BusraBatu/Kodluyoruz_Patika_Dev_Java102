package adventureGame;

import java.util.Scanner;

public class Player {
    Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner scan = new Scanner(System.in);

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
        this.health = health;
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

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        System.out.println("--------------------------------------------");
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter each : charList) {
            System.out.println("Characters");
            System.out.println("ID: "+ each.getID()+
                    "\t Character: " + each.getName() +
                    "\t Damage: " + each.getDamage() +
                    "\t Health: " + each.getHealth() +
                    "\t Money: " + each.getMoney());
        }
        System.out.println("-----------------------------");
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
        System.out.println("Character: "+ this.getCharName() +
                ", Damage: "+ this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());


    }
    public void initPlayer(GameCharacter gameCharacter){

        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }
}
