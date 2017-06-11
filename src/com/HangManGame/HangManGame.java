package com.HangManGame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HangManGame {

    private String secretWord = "HELLO"; //the secret word to be predicted
    private int noOfGuesses=5;
    private List<Character> guessedCharacter = new ArrayList<Character>();
    private Map<Integer, String> matchedCharacters = new HashMap<Integer, String>();

    public HangManGame() {
        initializeMap();
    }

    private void initializeMap() {
        int len = secretWord.length();
        for (int i = 1; i <= len; i++) {
            matchedCharacters.put(i, "_ ");
        }
    }

    public Map display() {
        return matchedCharacters;
    }

    public String checkCharacter(Character c) {

        if (guessedCharacter.contains(c)) {
            return "Already Guessed";
        }
        else {
            guessedCharacter.add(c);
            int i = 1;
            boolean check=false;
            for (char ch : secretWord.toCharArray()) {
                if (ch == c) {
                    check=true;
                    matchedCharacters.put(i, String.valueOf(ch));
                }
                i++;
            }
            if(check == false)  {
                noOfGuesses--;
                return "You Guess Wrong"+"\nNO. Of Chances:"+noOfGuesses;
            }


        }

        return "\n";
    }

    public MessageHangMan hasWinOrLostExit(){
        MessageHangMan m = new MessageHangMan();
        if (noOfGuesses < 1) {
            m.setMessage("You Loss the game.");
            m.setExit(true);
        }
        boolean chk=true;
        int j=1;
        for(char c:secretWord.toCharArray()){
            if(matchedCharacters.get(j).charAt(0)!=c){
                chk=false;
                break;
            }
            j++;
        }
        if(chk){
            m.setMessage("You Won");
            m.setExit(true);
        }
        return m;

    }
}
