package mastermind.model;

import javafx.scene.control.Button;

import java.util.Random;

public class GameLogic {

    //Array for winning combination of pegs
    private CodePeg[] winningCombo = new CodePeg[4];

    //Array for current guess
    private CodePeg[] currentGuess = new CodePeg[4];

    private Random random = new Random();

    private enum CodePeg {
        BLUE, RED, GREEN, YELLOW, PURPLE, ORANGE, NONE;
    }
    private enum KeyPeg {
        Black, White;
    }

    public GameLogic() {
        resetCurrentGuess();
    }

    public void chooseWinning(){
        //Pick 4 pegs for winning combination
        for (int i=0;i<4;i++){
            winningCombo[i] = getRandomPeg();
        }
    }

    private CodePeg getRandomPeg(){

        //Get random index in MainPeg enum
        int randIndex = random.nextInt(CodePeg.class.getEnumConstants().length);

        //Return value in random index of enum
        return CodePeg.class.getEnumConstants()[randIndex];
    }

    public void resetCurrentGuess(){
        //Change all four current guess pegs to be 'NONE'
        for (int i=0;i<4;i++){
            System.out.println(currentGuess[i]);
            currentGuess[i] = CodePeg.NONE;
        }
    }

    public void updateGuess(Button button){

        String buttonStyle = button.getStyleClass().get(0);
        CodePeg pegGuess = stringToCodePeg(buttonStyle);

        //Only update if peg is a colour
        if (!pegGuess.equals(CodePeg.NONE)) {

            //Add peg to correct index of current guess array
            if (button.toString().contains("a,")) {
                currentGuess[0] = pegGuess;
            } else if (button.toString().contains("b,")) {
                currentGuess[1] = pegGuess;
            } else if (button.toString().contains("c,")) {
                currentGuess[2] = pegGuess;
            } else if (button.toString().contains("d,")) {
                currentGuess[3] = pegGuess;
            }
        }
    }

    private CodePeg stringToCodePeg(String pegStyle){

        //Return correct CodePeg enum depending on pegStyle input string
        switch (pegStyle){
            case "RedPeg":
                return CodePeg.RED;
            case "BluePeg":
                return CodePeg.BLUE;
            case "GreenPeg":
                return CodePeg.GREEN;
            case "OrangePeg":
                return CodePeg.ORANGE;
            case "YellowPeg":
                return CodePeg.YELLOW;
            case "PurplePeg":
                return CodePeg.PURPLE;
        }

        //Return none if no colour selected
        return CodePeg.NONE;
    }
}
