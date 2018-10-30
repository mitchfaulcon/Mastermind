package mastermind.model;

import java.util.Random;

public class GameLogic {

    private MainPeg[] winningCombo = new MainPeg[4];
    private Random random = new Random();

    private enum MainPeg {
        BLUE, RED, GREEN, YELLOW, PURPLE, ORANGE;
    }
    private enum FeedbackPeg {
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

    private MainPeg getRandomPeg(){

        //Get random index in MainPeg enum
        int randIndex = random.nextInt(MainPeg.class.getEnumConstants().length);

        //Return value in random index of enum
        return MainPeg.class.getEnumConstants()[randIndex];
    }
}
