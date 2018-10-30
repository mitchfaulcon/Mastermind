package mastermind.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mastermind.Main;
import mastermind.model.GameLogic;
import mastermind.model.GameTimer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable{

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

    private GameTimer gameTimer = new GameTimer();
    private GameLogic gameLogic = new GameLogic();

    //Colour style of currently selected peg
    private String currentPegColourStyle;
    //Display for currently selected colour
    @FXML private Button currentColour;

    private int currentRow = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
    }

    @FXML private void onClick(ActionEvent event){
        Button clicked = (Button)event.getSource();
        if (clicked.equals(backButton)){
            //Stop the timer before changing to main menu
            gameTimer.stopTimer();
            changeToMenu();
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
            currentRow++;
            //TODO enter guess to gameLogic and get black & white peg count back
        } else if (clicked.equals(gamePeg1a)||clicked.equals(gamePeg1b)||clicked.equals(gamePeg1c)||clicked.equals(gamePeg1d)){
            //Button from row 1 was clicked

            //Update peg if current guessing row is 1
            if (currentRow == 1){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg2a)||clicked.equals(gamePeg2b)||clicked.equals(gamePeg2c)||clicked.equals(gamePeg2d)){
            //Button from row 2 was clicked

            //Update peg if current guessing row is 2
            if (currentRow == 2){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg3a)||clicked.equals(gamePeg3b)||clicked.equals(gamePeg3c)||clicked.equals(gamePeg3d)){
            //Button from row 3 was clicked

            //Update peg if current guessing row is 3
            if (currentRow == 3){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg4a)||clicked.equals(gamePeg4b)||clicked.equals(gamePeg4c)||clicked.equals(gamePeg4d)){
            //Button from row 4 was clicked

            //Update peg if current guessing row is 4
            if (currentRow == 4){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg5a)||clicked.equals(gamePeg5b)||clicked.equals(gamePeg5c)||clicked.equals(gamePeg5d)){
            //Button from row 5 was clicked

            //Update peg if current guessing row is 5
            if (currentRow == 5){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg6a)||clicked.equals(gamePeg6b)||clicked.equals(gamePeg6c)||clicked.equals(gamePeg6d)){
            //Button from row 6 was clicked

            //Update peg if current guessing row is 6
            if (currentRow == 6){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg7a)||clicked.equals(gamePeg7b)||clicked.equals(gamePeg7c)||clicked.equals(gamePeg7d)){
            //Button from row 7 was clicked

            //Update peg if current guessing row is 7
            if (currentRow == 7){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg8a)||clicked.equals(gamePeg8b)||clicked.equals(gamePeg8c)||clicked.equals(gamePeg8d)){
            //Button from row 8 was clicked

            //Update peg if current guessing row is 8
            if (currentRow == 8){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg9a)||clicked.equals(gamePeg9b)||clicked.equals(gamePeg9c)||clicked.equals(gamePeg9d)){
            //Button from row 9 was clicked

            //Update peg if current guessing row is 9
            if (currentRow == 9){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg10a)||clicked.equals(gamePeg10b)||clicked.equals(gamePeg10c)||clicked.equals(gamePeg10d)){
            //Button from row 10 was clicked

            //Update peg if current guessing row is 10
            if (currentRow == 10){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg11a)||clicked.equals(gamePeg11b)||clicked.equals(gamePeg11c)||clicked.equals(gamePeg11d)){
            //Button from row 11 was clicked

            //Update peg if current guessing row is 11
            if (currentRow == 11){
                updatePeg(clicked);
            }
        } else if (clicked.equals(gamePeg12a)||clicked.equals(gamePeg12b)||clicked.equals(gamePeg12c)||clicked.equals(gamePeg12d)){
            //Button from row 12 was clicked

            //Update peg if current guessing row is 12
            if (currentRow == 12){
                updatePeg(clicked);
            }
        }
    }

    private void changeToMenu(){
        //Change back to main menu
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mastermind/view/Home.fxml")));
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
}
