package mastermind.model;

import java.util.Random;

public class GameLogic {

    private CodePeg[] winningCombo = new CodePeg[4];
    private Random random = new Random();

    private enum CodePeg {
        BLUE, RED, GREEN, YELLOW, PURPLE, ORANGE;
    }
    private enum KeyPeg {
        Black, White;
    }

    public GameLogic() {
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
}
