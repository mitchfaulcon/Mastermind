package mastermind.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mastermind.Main;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

    @FXML private JFXButton newGameButton;
    @FXML private JFXButton leaderboardButton;
    @FXML private JFXButton quitButton;

    @FXML private void onClick(ActionEvent event){
        if (event.getSource().equals(newGameButton)){
            changeToGame();
        } else if (event.getSource().equals(leaderboardButton)){
            changeToLeaderboard();
        } else if (event.getSource().equals(quitButton)){
            quit();
        }
    }

    private void changeToGame(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mastermind/view/Game.fxml")));
            Scene newGame = new Scene(root,750,500);
            Main.ChangeScene(newGame);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void changeToLeaderboard(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mastermind/view/Leaderboard.fxml")));
            Scene leaderBoard = new Scene(root,750,500);
            Main.ChangeScene(leaderBoard);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void keyReleased(KeyEvent keyEvent) {
        //Esc shortcut for quitting application
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)){
            quitButton.fire();
        }
    }

    private void quit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit MasterMind?", ButtonType.YES, ButtonType.NO);
        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            //Quit
            System.exit(1);
        }
    }
}
