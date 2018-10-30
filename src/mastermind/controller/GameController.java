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
    @FXML private Button backButton;

    //Buttons for changing selected colour
    @FXML private Button redSelect;
    @FXML private Button greenSelect;
    @FXML private Button blueSelect;
    @FXML private Button orangeSelect;
    @FXML private Button purpleSelect;
    @FXML private Button yellowSelect;

    private GameTimer gameTimer = new GameTimer();
    private GameLogic gameLogic = new GameLogic();

    //Colour style of currently selected peg
    private String currentPegColourStyle;
    //Display for currently selected colour
    @FXML private Button currentColour;

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
        currentPegColourStyle = "WhitePeg";
        updateCurrentPeg();
    }

    @FXML private void onClick(ActionEvent event){
        if (event.getSource().equals(backButton)){
            //Stop the timer before changing to main menu
            gameTimer.stopTimer();
            changeToMenu();
        } else if (event.getSource().equals(redSelect)){
            currentPegColourStyle = "RedPeg";
            updateCurrentPeg();
        } else if (event.getSource().equals(greenSelect)){
            currentPegColourStyle = "GreenPeg";
            updateCurrentPeg();
        } else if (event.getSource().equals(blueSelect)){
            currentPegColourStyle = "BluePeg";
            updateCurrentPeg();
        } else if (event.getSource().equals(orangeSelect)){
            currentPegColourStyle = "OrangePeg";
            updateCurrentPeg();
        } else if (event.getSource().equals(purpleSelect)){
            currentPegColourStyle = "PurplePeg";
            updateCurrentPeg();
        } else if (event.getSource().equals(yellowSelect)) {
            currentPegColourStyle = "YellowPeg";
            updateCurrentPeg();
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

    private void updateCurrentPeg(){
        currentColour.getStyleClass().clear();
        currentColour.getStyleClass().add(currentPegColourStyle);
    }
}
