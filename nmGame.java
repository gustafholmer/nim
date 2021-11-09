package com.example.NmGame;
// Gustaf Holmer
//gustafholmeri@gmail.com

import java.util.Scanner;
import java.util.Random;

abstract class Player {

    abstract int playerTurn (int turnInput, int plNr);

    boolean inputCheck(int currentSticks, int input){
        boolean returnOk = false;

        if (input > (currentSticks / 2) || input <= 0) {
            returnOk = true;
        }
        return returnOk;
    }
}

class HumanPlayer extends Player {
    @Override
    int playerTurn (int turnInput, int plNr) {
        int answer = 0;
        boolean inputOk = true;

        if (turnInput == 1) {
            System.out.println("Player " + plNr + " lost.");
            answer = 0;
            return answer;
        }

        while (inputOk) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Player " + plNr + ", enter how many matches you want to pick: ");
            answer = reader.nextInt();

            inputOk = inputCheck(turnInput, answer);

            if (inputOk)
                System.out.println("Illegal move! Please choose at least one match and at most, half of the current matches");
        }

        System.out.println("Player " + plNr +" picked: " + answer + " matches ");
        return answer;
    }
}

class ComputerPlayer extends Player {
    @Override
    int playerTurn (int turnInput, int plNr) {
        int answer = 0;
        boolean inputOk = true;

        if (turnInput == 1) {
            System.out.println("Player " + plNr + " lost.");
            answer = 0;
            return answer;
        }

        while (inputOk) {
            Random r = new Random();
            int low = 1;
            int high = turnInput - (turnInput / 2) + 1;
            answer = r.nextInt(high-low) + low;

            inputOk = inputCheck(turnInput, answer);
        }
        System.out.println("Player " + plNr +" picked: " + answer + " matches ");
        return answer;
    }
}

class Game {
    void activate(int startValue) {
        int answer1;

        System.out.println("--------------------------\nWelcome to Nm! Matches: " + startValue +
                "\n--------------------------\n");

        // change to HumanPlayer() or ComputerPlayer()
        Player p1 = new ComputerPlayer();
        Player p2 = new HumanPlayer();

        while (startValue >= 1) {
            // player1
            answer1 = p1.playerTurn(startValue, 1);
            if (answer1 == 0) {
                System.out.println("Player 2 won!");
                break;
            } else startValue -= answer1;
            System.out.println("Total matches in the game: " + startValue + "\n");
            //player2
            answer1 = p2.playerTurn(startValue, 2);
            if (answer1 == 0) {
                System.out.println("Player 1 won!");
                break;
            } else startValue -= answer1;
            System.out.println("Total matches in the game: " + startValue + "\n");
        }
    }
}

public class nmGame {
    public static void main (String[] arg) { // starts the program
        int startValue = Integer.parseInt(arg[0]);
        Game g = new Game();
        g.activate(startValue);
    }
}
