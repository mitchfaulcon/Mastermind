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
    @FXML private JFXButton startButton;
    @FXML private JFXButton stopButton;
    @FXML private Button homeButton;

    private GameTimer gameTimer = GameTimer.getInstance();
    private GameLogic gameLogic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameLogic = new GameLogic();
        gameLogic.chooseWinning();
        //Set initial timer label
        timeDisplay.setText(gameTimer.getSspTime().get());

        //Listener for when ssp time changes in gameTimer
        gameTimer.getSspTime().addListener(observable -> {

            //Update label in application thread
            Platform.runLater(() -> timeDisplay.setText(gameTimer.getSspTime().get()));

        });
    }

    @FXML private void onClick(ActionEvent event){
        if (event.getSource().equals(startButton)){
            gameTimer.startTimer(0);
        } else if (event.getSource().equals(stopButton)){
            gameTimer.stopTimer();
        } else if (event.getSource().equals(homeButton)){
            //Stop the timer before changing to main menu
            gameTimer.stopTimer();
            changeToMenu();
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
}
