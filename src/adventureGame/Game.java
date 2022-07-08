package adventureGame;

import java.util.Scanner;

public class Game {
    private Scanner scan= new Scanner(System.in);

    Location location;
    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please input your name: ");
        String playerName = scan.next();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + " Welcome to Dark World! Here Is The Real Side!");

        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("*********** Locations ************");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Cave");
            System.out.println("4- Forest");
            System.out.println("5- River");
            System.out.println("0- Exit");
            System.out.print("Please select your location: ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location= new River(player);
                    break;
                default:
                    System.out.println("Please select valid location!");
                    break;
            }
            if(location==null){
                System.out.println("Game Over");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }


        }
    }
}
