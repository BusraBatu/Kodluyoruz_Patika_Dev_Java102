package adventureGame;

import java.util.Scanner;

public class Game {
    public Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please input your name: ");
        String playerName = scan.next();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + " Welcome to Dark World! Here Is The Real Side!");
        System.out.println("Please select a character: ");
        player.selectChar();
        player.selectLocation();
        player.printInfo();

    }
}
