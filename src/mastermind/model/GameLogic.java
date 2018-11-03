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
        BLUE, RED, GREEN, YELLOW, PURPLE, ORANGE, NONE
    }

    public GameLogic() {
        resetCurrentGuess();
    }

    public void chooseWinning(){
        //Pick 4 pegs for winning combination
        for (int i=0;i<4;i++){
            winningCombo[i] = getRandomPeg();
            /**
             *
             *
             *
             *
             *
             *
             */
            //System.out.println(winningCombo[i]);
        }
    }

    private CodePeg getRandomPeg(){

        //Random peg colour to be returned
        CodePeg randomPeg = CodePeg.NONE;

        //Keep choosing random peg until it is not 'NONE'
        while (randomPeg.equals(CodePeg.NONE)){

            //Get random index in MainPeg enum
            int randIndex = random.nextInt(CodePeg.class.getEnumConstants().length);

            //Get value in random index of enum
            randomPeg = CodePeg.class.getEnumConstants()[randIndex];

        }

        return randomPeg;
    }

    public void resetCurrentGuess(){
        //Change all four current guess pegs to be 'NONE'
        for (int i=0;i<4;i++){
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

    public boolean legalGuess(){

        //Loop through current guess array
        for (CodePeg peg : currentGuess) {
            if (peg.equals(CodePeg.NONE)) {
                //Return false if any pegs are not coloured
                return false;
            }
        }

        return true;
    }

    public int[] getFeedback(){

        //Count for number of black and white feedback pegs
        //  [0] = black count
        //  [1] = white count
        int[] feedbackCount = {0,0};

        //Arrays to keep track of which pegs have had feedback pegs assigned
        boolean[] guessPegsChecked = {false,false,false,false};
        boolean[] winningPegsChecked = {false,false,false,false};

        //Compare guess to winning to assign black pegs (correct colour, correct position)
        for (int index=0;index<4;index++){

            //Check if entered guess matches winning combination
            if (currentGuess[index].equals(winningCombo[index])){

                //Increase black peg count
                feedbackCount[0]++;

                //Set guess and winning peg at index to 'checked'
                guessPegsChecked[index] = true;
                winningPegsChecked[index] = true;
            }
        }

        //Compare guess to winning to assign white pegs (correct colour, incorrect position)
        for (int guessIndex=0;guessIndex<4;guessIndex++){

            //Only check peg in guess array if it was not a correct guess
            if (!guessPegsChecked[guessIndex]){

                //Run through winning combination to look for a match in a different position
                for (int winningIndex=0;winningIndex<4;winningIndex++){

                    //Check if colour matches & peg hasn't had a peg assigned from it
                    if (currentGuess[guessIndex].equals(winningCombo[winningIndex]) && !winningPegsChecked[winningIndex] && !guessPegsChecked[guessIndex]){

                        //Increase white peg count
                        feedbackCount[1]++;

                        //Set guess and winning peg at index to 'checked'
                        guessPegsChecked[guessIndex] = true;
                        winningPegsChecked[winningIndex] = true;
                    }
                }
            }
        }

        return feedbackCount;
    }
}
