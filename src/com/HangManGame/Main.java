package com.HangManGame;

import java.util.Scanner;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HangManGame hangmanGame = new HangManGame();

        while (true){
            Map<Integer,String> dis = hangmanGame.display();

            for(Integer key: dis.keySet()){
                System.out.print(dis.get(key));
            }
            Scanner input= new Scanner(System.in);
            char chr= input.next().charAt(0);

            String msg= hangmanGame.checkCharacter(chr);
            System.out.println(msg);

            MessageHangMan mg=hangmanGame.hasWinOrLostExit();
            if(mg.isExit()){
                System.out.println(mg.getMessage());
                break;
            }
        }
    }
}
