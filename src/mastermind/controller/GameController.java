package mastermind.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import mastermind.Main;
import mastermind.model.GameLogic;
import mastermind.model.GameTimer;
import mastermind.model.Leaderboard;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable{

    //Label for clock timer
    @FXML private Label timeDisplay;

    //Return to menu button
    @FXML private Button backButton;

    //Enter guess button
    @FXML private Button enterButton;

    //Buttons for changing selected colour
    @FXML private Button redSelect;
    @FXML private Button greenSelect;
    @FXML private Button blueSelect;
    @FXML private Button orangeSelect;
    @FXML private Button purpleSelect;
    @FXML private Button yellowSelect;

    //Buttons for game row 1
    @FXML private Button gamePeg1a;
    @FXML private Button gamePeg1b;
    @FXML private Button gamePeg1c;
    @FXML private Button gamePeg1d;
    //Buttons for game row 2
    @FXML private Button gamePeg2a;
    @FXML private Button gamePeg2b;
    @FXML private Button gamePeg2c;
    @FXML private Button gamePeg2d;
    //Buttons for game row 3
    @FXML private Button gamePeg3a;
    @FXML private Button gamePeg3b;
    @FXML private Button gamePeg3c;
    @FXML private Button gamePeg3d;
    //Buttons for game row 4
    @FXML private Button gamePeg4a;
    @FXML private Button gamePeg4b;
    @FXML private Button gamePeg4c;
    @FXML private Button gamePeg4d;
    //Buttons for game row 5
    @FXML private Button gamePeg5a;
    @FXML private Button gamePeg5b;
    @FXML private Button gamePeg5c;
    @FXML private Button gamePeg5d;
    //Buttons for game row 6
    @FXML private Button gamePeg6a;
    @FXML private Button gamePeg6b;
    @FXML private Button gamePeg6c;
    @FXML private Button gamePeg6d;
    //Buttons for game row 7
    @FXML private Button gamePeg7a;
    @FXML private Button gamePeg7b;
    @FXML private Button gamePeg7c;
    @FXML private Button gamePeg7d;
    //Buttons for game row 8
    @FXML private Button gamePeg8a;
    @FXML private Button gamePeg8b;
    @FXML private Button gamePeg8c;
    @FXML private Button gamePeg8d;
    //Buttons for game row 9
    @FXML private Button gamePeg9a;
    @FXML private Button gamePeg9b;
    @FXML private Button gamePeg9c;
    @FXML private Button gamePeg9d;
    //Buttons for game row 10
    @FXML private Button gamePeg10a;
    @FXML private Button gamePeg10b;
    @FXML private Button gamePeg10c;
    @FXML private Button gamePeg10d;
    //Buttons for game row 11
    @FXML private Button gamePeg11a;
    @FXML private Button gamePeg11b;
    @FXML private Button gamePeg11c;
    @FXML private Button gamePeg11d;
    //Buttons for game row 12
    @FXML private Button gamePeg12a;
    @FXML private Button gamePeg12b;
    @FXML private Button gamePeg12c;
    @FXML private Button gamePeg12d;

    //GridPanes for each row
    @FXML private GridPane row1;
    @FXML private GridPane row2;
    @FXML private GridPane row3;
    @FXML private GridPane row4;
    @FXML private GridPane row5;
    @FXML private GridPane row6;
    @FXML private GridPane row7;
    @FXML private GridPane row8;
    @FXML private GridPane row9;
    @FXML private GridPane row10;
    @FXML private GridPane row11;
    @FXML private GridPane row12;
    private ArrayList<GridPane> rows = new ArrayList<>();

    //Feedback display circles for row 1
    @FXML private Circle black1a;
    @FXML private Circle black1b;
    @FXML private Circle black1c;
    @FXML private Circle black1d;
    private ArrayList<Circle> row1Black = new ArrayList<>();
    @FXML private Circle white1a;
    @FXML private Circle white1b;
    @FXML private Circle white1c;
    @FXML private Circle white1d;
    private ArrayList<Circle> row1White = new ArrayList<>();

    //Feedback display circles for row 2
    @FXML private Circle black2a;
    @FXML private Circle black2b;
    @FXML private Circle black2c;
    @FXML private Circle black2d;
    private ArrayList<Circle> row2Black = new ArrayList<>();
    @FXML private Circle white2a;
    @FXML private Circle white2b;
    @FXML private Circle white2c;
    @FXML private Circle white2d;
    private ArrayList<Circle> row2White = new ArrayList<>();

    //Feedback display circles for row 3
    @FXML private Circle black3a;
    @FXML private Circle black3b;
    @FXML private Circle black3c;
    @FXML private Circle black3d;
    private ArrayList<Circle> row3Black = new ArrayList<>();
    @FXML private Circle white3a;
    @FXML private Circle white3b;
    @FXML private Circle white3c;
    @FXML private Circle white3d;
    private ArrayList<Circle> row3White = new ArrayList<>();

    //Feedback display circles for row 4
    @FXML private Circle black4a;
    @FXML private Circle black4b;
    @FXML private Circle black4c;
    @FXML private Circle black4d;
    private ArrayList<Circle> row4Black = new ArrayList<>();
    @FXML private Circle white4a;
    @FXML private Circle white4b;
    @FXML private Circle white4c;
    @FXML private Circle white4d;
    private ArrayList<Circle> row4White = new ArrayList<>();

    //Feedback display circles for row 5
    @FXML private Circle black5a;
    @FXML private Circle black5b;
    @FXML private Circle black5c;
    @FXML private Circle black5d;
    private ArrayList<Circle> row5Black = new ArrayList<>();
    @FXML private Circle white5a;
    @FXML private Circle white5b;
    @FXML private Circle white5c;
    @FXML private Circle white5d;
    private ArrayList<Circle> row5White = new ArrayList<>();

    //Feedback display circles for row 6
    @FXML private Circle black6a;
    @FXML private Circle black6b;
    @FXML private Circle black6c;
    @FXML private Circle black6d;
    private ArrayList<Circle> row6Black = new ArrayList<>();
    @FXML private Circle white6a;
    @FXML private Circle white6b;
    @FXML private Circle white6c;
    @FXML private Circle white6d;
    private ArrayList<Circle> row6White = new ArrayList<>();

    //Feedback display circles for row 7
    @FXML private Circle black7a;
    @FXML private Circle black7b;
    @FXML private Circle black7c;
    @FXML private Circle black7d;
    private ArrayList<Circle> row7Black = new ArrayList<>();
    @FXML private Circle white7a;
    @FXML private Circle white7b;
    @FXML private Circle white7c;
    @FXML private Circle white7d;
    private ArrayList<Circle> row7White = new ArrayList<>();

    //Feedback display circles for row 8
    @FXML private Circle black8a;
    @FXML private Circle black8b;
    @FXML private Circle black8c;
    @FXML private Circle black8d;
    private ArrayList<Circle> row8Black = new ArrayList<>();
    @FXML private Circle white8a;
    @FXML private Circle white8b;
    @FXML private Circle white8c;
    @FXML private Circle white8d;
    private ArrayList<Circle> row8White = new ArrayList<>();

    //Feedback display circles for row 9
    @FXML private Circle black9a;
    @FXML private Circle black9b;
    @FXML private Circle black9c;
    @FXML private Circle black9d;
    private ArrayList<Circle> row9Black = new ArrayList<>();
    @FXML private Circle white9a;
    @FXML private Circle white9b;
    @FXML private Circle white9c;
    @FXML private Circle white9d;
    private ArrayList<Circle> row9White = new ArrayList<>();

    //Feedback display circles for row 10
    @FXML private Circle black10a;
    @FXML private Circle black10b;
    @FXML private Circle black10c;
    @FXML private Circle black10d;
    private ArrayList<Circle> row10Black = new ArrayList<>();
    @FXML private Circle white10a;
    @FXML private Circle white10b;
    @FXML private Circle white10c;
    @FXML private Circle white10d;
    private ArrayList<Circle> row10White = new ArrayList<>();

    //Feedback display circles for row 11
    @FXML private Circle black11a;
    @FXML private Circle black11b;
    @FXML private Circle black11c;
    @FXML private Circle black11d;
    private ArrayList<Circle> row11Black = new ArrayList<>();
    @FXML private Circle white11a;
    @FXML private Circle white11b;
    @FXML private Circle white11c;
    @FXML private Circle white11d;
    private ArrayList<Circle> row11White = new ArrayList<>();

    //Feedback display circles for row 12
    @FXML private Circle black12a;
    @FXML private Circle black12b;
    @FXML private Circle black12c;
    @FXML private Circle black12d;
    private ArrayList<Circle> row12Black = new ArrayList<>();
    @FXML private Circle white12a;
    @FXML private Circle white12b;
    @FXML private Circle white12c;
    @FXML private Circle white12d;
    private ArrayList<Circle> row12White = new ArrayList<>();

    //ArrayList to hold black ArrayLists
    private ArrayList<ArrayList<Circle>> allBlack = new ArrayList<>();

    //ArrayList to hole white ArrayLists
    private ArrayList<ArrayList<Circle>> allWhite = new ArrayList<>();

    //To control logic & timing for game
    private GameTimer gameTimer = new GameTimer();
    private GameLogic gameLogic = new GameLogic();

    //Colour style of currently selected peg
    private String currentPegColourStyle;
    //Display for currently selected colour
    @FXML private Button currentColour;

    //Current guessing row
    private int currentRow = 1;

    //Has game been won or not
    private boolean gameWon = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Add black display circles to ArrayLists
        row1Black.add(black1a);row1Black.add(black1b);row1Black.add(black1c);row1Black.add(black1d);
        row2Black.add(black2a);row2Black.add(black2b);row2Black.add(black2c);row2Black.add(black2d);
        row3Black.add(black3a);row3Black.add(black3b);row3Black.add(black3c);row3Black.add(black3d);
        row4Black.add(black4a);row4Black.add(black4b);row4Black.add(black4c);row4Black.add(black4d);
        row5Black.add(black5a);row5Black.add(black5b);row5Black.add(black5c);row5Black.add(black5d);
        row6Black.add(black6a);row6Black.add(black6b);row6Black.add(black6c);row6Black.add(black6d);
        row7Black.add(black7a);row7Black.add(black7b);row7Black.add(black7c);row7Black.add(black7d);
        row8Black.add(black8a);row8Black.add(black8b);row8Black.add(black8c);row8Black.add(black8d);
        row9Black.add(black9a);row9Black.add(black9b);row9Black.add(black9c);row9Black.add(black9d);
        row10Black.add(black10a);row10Black.add(black10b);row10Black.add(black10c);row10Black.add(black10d);
        row11Black.add(black11a);row11Black.add(black11b);row11Black.add(black11c);row11Black.add(black11d);
        row12Black.add(black12a);row12Black.add(black12b);row12Black.add(black12c);row12Black.add(black12d);

        //Add all black rows to one ArrayList
        allBlack.add(row1Black);allBlack.add(row2Black);allBlack.add(row3Black);allBlack.add(row4Black);
        allBlack.add(row5Black);allBlack.add(row6Black);allBlack.add(row7Black);allBlack.add(row8Black);
        allBlack.add(row9Black);allBlack.add(row10Black);allBlack.add(row11Black);allBlack.add(row12Black);

        //Add white display circles to ArrayLists
        row1White.add(white1a);row1White.add(white1b);row1White.add(white1c);row1White.add(white1d);
        row2White.add(white2a);row2White.add(white2b);row2White.add(white2c);row2White.add(white2d);
        row3White.add(white3a);row3White.add(white3b);row3White.add(white3c);row3White.add(white3d);
        row4White.add(white4a);row4White.add(white4b);row4White.add(white4c);row4White.add(white4d);
        row5White.add(white5a);row5White.add(white5b);row5White.add(white5c);row5White.add(white5d);
        row6White.add(white6a);row6White.add(white6b);row6White.add(white6c);row6White.add(white6d);
        row7White.add(white7a);row7White.add(white7b);row7White.add(white7c);row7White.add(white7d);
        row8White.add(white8a);row8White.add(white8b);row8White.add(white8c);row8White.add(white8d);
        row9White.add(white9a);row9White.add(white9b);row9White.add(white9c);row9White.add(white9d);
        row10White.add(white10a);row10White.add(white10b);row10White.add(white10c);row10White.add(white10d);
        row11White.add(white11a);row11White.add(white11b);row11White.add(white11c);row11White.add(white11d);
        row12White.add(white12a);row12White.add(white12b);row12White.add(white12c);row12White.add(white12d);

        //Add all white rows to one ArrayList
        allWhite.add(row1White);allWhite.add(row2White);allWhite.add(row3White);allWhite.add(row4White);
        allWhite.add(row5White);allWhite.add(row6White);allWhite.add(row7White);allWhite.add(row8White);
        allWhite.add(row9White);allWhite.add(row10White);allWhite.add(row11White);allWhite.add(row12White);

        //Add GridPaneRows to ArrayList
        rows.add(row1);rows.add(row2);rows.add(row3);rows.add(row4);rows.add(row5);rows.add(row6);
        rows.add(row7);rows.add(row8);rows.add(row9);rows.add(row10);rows.add(row11);rows.add(row12);

        //Decide winning combination of pegs
        gameLogic.chooseWinning();

        //Set initial timer label
        timeDisplay.setText(gameTimer.getSspTime().get());

        //Listener for when ssp time changes in gameTimer
        gameTimer.getSspTime().addListener(observable -> {
            //Update label in application thread
            Platform.runLater(() -> timeDisplay.setText(gameTimer.getSspTime().get()));
        });

        //Start the timer from 0 seconds
        gameTimer.startTimer(0);

        //Set currentSelected peg display to be white
        currentPegColourStyle = "PlaceholderPeg";
        updatePeg(currentColour);

        //Update grey highlight of current row
        updateRow();

        //Disable enter button initially
        enterButton.setDisable(true);
    }

    @FXML private void onClick(ActionEvent event){

        Button clicked = (Button)event.getSource();
        if (clicked.equals(backButton)){

            //Alert to make sure user wants to end the game
            Alert quitConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to end the game?",ButtonType.YES,ButtonType.NO);
            quitConfirmation.showAndWait();

            if (quitConfirmation.getResult().equals(ButtonType.YES)) {
                //Stop the timer before changing to main menu
                gameTimer.stopTimer();
                //Change to menu
                changeToMenu();
            }
        } else if (clicked.equals(redSelect)){
            currentPegColourStyle = "RedPeg";
            updatePeg(currentColour);
        } else if (clicked.equals(greenSelect)){
            currentPegColourStyle = "GreenPeg";
            updatePeg(currentColour);
        } else if (clicked.equals(blueSelect)){
            currentPegColourStyle = "BluePeg";
            updatePeg(currentColour);
        } else if (clicked.equals(orangeSelect)){
            currentPegColourStyle = "OrangePeg";
            updatePeg(currentColour);
        } else if (clicked.equals(purpleSelect)){
            currentPegColourStyle = "PurplePeg";
            updatePeg(currentColour);
        } else if (clicked.equals(yellowSelect)) {
            currentPegColourStyle = "YellowPeg";
            updatePeg(currentColour);
        } else if (clicked.equals(enterButton)){

                //Display the correct black & white pegs depending on guess
                setFeedbackPegs();

                //Increase row count
                currentRow++;
                //Change grey highlight
                updateRow();

                //Disable enter button
                enterButton.setDisable(true);

                if (gameWon){
                    //Change current guessing row to be out of bounds if game was won
                    currentRow = 13;

                    //Stop the timer
                    gameTimer.stopTimer();

                    //Get winning time
                    String time = gameTimer.getSspTime().get();

                    //Show dialog to get user's name
                    TextInputDialog winningDialogue = new TextInputDialog();
                    //Disable cancel button
                    winningDialogue.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
                    //Change displayed text
                    winningDialogue.setTitle("Congratulations! You have won!");
                    winningDialogue.setHeaderText("Your time was " + time);
                    winningDialogue.setContentText("Enter name:\n");
                    //Change size of dialog
                    winningDialogue.getDialogPane().setPrefSize(280,200);
                    //Wait until name is entered & ok is clicked
                    winningDialogue.showAndWait().ifPresent(name -> {
                        //Add the name and time to leaderboard
                        Leaderboard leaderboard = Leaderboard.getInstance();
                        leaderboard.addWinningTime(name, time);
                    });

                    //Change back to main menu
                    changeToMenu();

                } else if (currentRow == 13){

                    //Alert to check if user wants to try again or go back to menu
                    Alert losingDialogue = new Alert(Alert.AlertType.NONE,"You lose",ButtonType.YES,ButtonType.NO);
                    //Set button text
                    ((Button) losingDialogue.getDialogPane().lookupButton(ButtonType.YES)).setText("New Game");
                    ((Button) losingDialogue.getDialogPane().lookupButton(ButtonType.NO)).setText("Back to Main Menu");
                    losingDialogue.setTitle("Better luck next time");
                    losingDialogue.showAndWait();

                    if (losingDialogue.getResult().equals(ButtonType.YES)){
                        //Restart game
                        restartGame();
                    } else if (losingDialogue.getResult().equals(ButtonType.NO)){
                        //Change to the main menu
                        changeToMenu();
                    }
                }

                //Reset current guess to be blank
                gameLogic.resetCurrentGuess();

        } else if (clicked.equals(gamePeg1a)||clicked.equals(gamePeg1b)||clicked.equals(gamePeg1c)||clicked.equals(gamePeg1d)){
            //Button from row 1 was clicked

            //Update peg if current guessing row is 1
            if (currentRow == 1){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg2a)||clicked.equals(gamePeg2b)||clicked.equals(gamePeg2c)||clicked.equals(gamePeg2d)){
            //Button from row 2 was clicked

            //Update peg if current guessing row is 2
            if (currentRow == 2){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg3a)||clicked.equals(gamePeg3b)||clicked.equals(gamePeg3c)||clicked.equals(gamePeg3d)){
            //Button from row 3 was clicked

            //Update peg if current guessing row is 3
            if (currentRow == 3){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg4a)||clicked.equals(gamePeg4b)||clicked.equals(gamePeg4c)||clicked.equals(gamePeg4d)){
            //Button from row 4 was clicked

            //Update peg if current guessing row is 4
            if (currentRow == 4){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg5a)||clicked.equals(gamePeg5b)||clicked.equals(gamePeg5c)||clicked.equals(gamePeg5d)){
            //Button from row 5 was clicked

            //Update peg if current guessing row is 5
            if (currentRow == 5){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg6a)||clicked.equals(gamePeg6b)||clicked.equals(gamePeg6c)||clicked.equals(gamePeg6d)){
            //Button from row 6 was clicked

            //Update peg if current guessing row is 6
            if (currentRow == 6){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg7a)||clicked.equals(gamePeg7b)||clicked.equals(gamePeg7c)||clicked.equals(gamePeg7d)){
            //Button from row 7 was clicked

            //Update peg if current guessing row is 7
            if (currentRow == 7){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg8a)||clicked.equals(gamePeg8b)||clicked.equals(gamePeg8c)||clicked.equals(gamePeg8d)){
            //Button from row 8 was clicked

            //Update peg if current guessing row is 8
            if (currentRow == 8){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg9a)||clicked.equals(gamePeg9b)||clicked.equals(gamePeg9c)||clicked.equals(gamePeg9d)){
            //Button from row 9 was clicked

            //Update peg if current guessing row is 9
            if (currentRow == 9){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg10a)||clicked.equals(gamePeg10b)||clicked.equals(gamePeg10c)||clicked.equals(gamePeg10d)){
            //Button from row 10 was clicked

            //Update peg if current guessing row is 10
            if (currentRow == 10){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg11a)||clicked.equals(gamePeg11b)||clicked.equals(gamePeg11c)||clicked.equals(gamePeg11d)){
            //Button from row 11 was clicked

            //Update peg if current guessing row is 11
            if (currentRow == 11){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        } else if (clicked.equals(gamePeg12a)||clicked.equals(gamePeg12b)||clicked.equals(gamePeg12c)||clicked.equals(gamePeg12d)){
            //Button from row 12 was clicked

            //Update peg if current guessing row is 12
            if (currentRow == 12){
                updatePeg(clicked);
                gameLogic.updateGuess(clicked);
            }
        }

        //Only enable enter button if all pegs are filled in
        if (!gameLogic.legalGuess()){
            enterButton.setDisable(true);
            //Change a button that isn't the back button to be highlighted
            currentColour.requestFocus();
        } else {
            enterButton.setDisable(false);
            //Change enter button to be highlighted
            enterButton.requestFocus();
        }

    }

    private void changeToMenu(){
        //Change back to main menu
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mastermind/view/Home.fxml")));
            Scene menu = new Scene(root,750,500);
            Main.ChangeScene(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void restartGame(){
        //Change to game scene again
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mastermind/view/Game.fxml")));
            Scene menu = new Scene(root,750,500);
            Main.ChangeScene(menu);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //Update input button based on current selected peg colour
    private void updatePeg(Button button){
        button.getStyleClass().clear();
        button.getStyleClass().add(currentPegColourStyle);
    }

    private void updateRow(){

        int index = currentRow - 1;

        if (currentRow > 1 && currentRow <= 13){
            //Clear grey highlight of previous row
            rows.get(index - 1).getStyleClass().clear();
        }
        if (currentRow <= 12 && !gameWon){
            //Only if game has not been won
            //Change current row to be a grey highlight
            rows.get(index).getStyleClass().clear();
            rows.get(index).getStyleClass().add("CurrentRow");
        }

    }

    private void setFeedbackPegs(){
        //Get the number of black and white pegs that need to be displayed
        int[] blackWhiteCount = gameLogic.getFeedback();

        //Count to keep track of total pegs displayed
        int totalPegs = 0;

        for (int blackPeg=0;blackPeg<blackWhiteCount[0];blackPeg++){
            //Set next black peg to be visible
            allBlack.get(currentRow-1).get(totalPegs).setVisible(true);

            //Increase count for pegs visible
            totalPegs++;
        }
        for (int whitePeg=0;whitePeg<blackWhiteCount[1];whitePeg++){

            //Set next white peg to be visible
            allWhite.get(currentRow-1).get(totalPegs).setVisible(true);

            //Increase count for pegs visible
            totalPegs++;
        }

        //Check if guess was correct
        if (blackWhiteCount[0]==4){
            gameWon = true;
        }
    }

    @FXML
    private void keyReleased(KeyEvent keyEvent) {
        //Numpad shortcuts for changing colour selection
        if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.NUMPAD1)){
            redSelect.fire();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.NUMPAD2)){
            greenSelect.fire();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.NUMPAD3)){
            blueSelect.fire();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT4) || keyEvent.getCode().equals(KeyCode.NUMPAD4)){
            orangeSelect.fire();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT5) || keyEvent.getCode().equals(KeyCode.NUMPAD5)){
            purpleSelect.fire();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT6) || keyEvent.getCode().equals(KeyCode.NUMPAD6)){
            yellowSelect.fire();
        }
        //ASDF shortcuts for entering colour guess
        else if (keyEvent.getCode().equals(KeyCode.A)){
            gamePeg1a.fire();gamePeg2a.fire();gamePeg3a.fire();gamePeg4a.fire();gamePeg5a.fire();gamePeg6a.fire();
            gamePeg7a.fire();gamePeg8a.fire();gamePeg9a.fire();gamePeg10a.fire();gamePeg11a.fire();gamePeg12a.fire();
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            gamePeg1b.fire();gamePeg2b.fire();gamePeg3b.fire();gamePeg4b.fire();gamePeg5b.fire();gamePeg6b.fire();
            gamePeg7b.fire();gamePeg8b.fire();gamePeg9b.fire();gamePeg10b.fire();gamePeg11b.fire();gamePeg12b.fire();
        } else if (keyEvent.getCode().equals(KeyCode.D)){
            gamePeg1c.fire();gamePeg2c.fire();gamePeg3c.fire();gamePeg4c.fire();gamePeg5c.fire();gamePeg6c.fire();
            gamePeg7c.fire();gamePeg8c.fire();gamePeg9c.fire();gamePeg10c.fire();gamePeg11c.fire();gamePeg12c.fire();
        } else if (keyEvent.getCode().equals(KeyCode.F)){
            gamePeg1d.fire();gamePeg2d.fire();gamePeg3d.fire();gamePeg4d.fire();gamePeg5d.fire();gamePeg6d.fire();
            gamePeg7d.fire();gamePeg8d.fire();gamePeg9d.fire();gamePeg10d.fire();gamePeg11d.fire();gamePeg12d.fire();
        }
        //Esc shortcut for going back to main menu
        else if (keyEvent.getCode().equals(KeyCode.ESCAPE)){
            backButton.fire();
        }
    }
}
