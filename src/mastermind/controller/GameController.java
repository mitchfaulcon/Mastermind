package mastermind.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mastermind.model.GameTimer;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable{

    @FXML private Label timeDisplay;
    @FXML private JFXButton startButton;
    @FXML private JFXButton stopButton;

    private GameTimer gameTimer = GameTimer.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        }
    }
}
