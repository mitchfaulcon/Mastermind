package mastermind.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import mastermind.Main;
import mastermind.model.Leaderboard;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {

    @FXML private JFXButton backButton;

    @FXML private Label name1;
    @FXML private Label name2;
    @FXML private Label name3;
    @FXML private Label name4;
    @FXML private Label name5;
    @FXML private Label name6;
    @FXML private Label name7;
    @FXML private Label name8;
    @FXML private Label name9;
    @FXML private Label name10;

    @FXML private Label time1;
    @FXML private Label time2;
    @FXML private Label time3;
    @FXML private Label time4;
    @FXML private Label time5;
    @FXML private Label time6;
    @FXML private Label time7;
    @FXML private Label time8;
    @FXML private Label time9;
    @FXML private Label time10;

    private Leaderboard leaderboard = Leaderboard.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Populate top 10 name and time labels
        ArrayList<String> topNames = leaderboard.getTopNames();
        ArrayList<String> topTimes = leaderboard.getTopTimes();
        for (int index=0;index<=10;index++){
            switch (index){
                case 0:
                    name1.setText(topNames.get(index));
                    time1.setText(topTimes.get(index));
                    break;
                case 1:
                    name2.setText(topNames.get(index));
                    time2.setText(topTimes.get(index));
                    break;
                case 2:
                    name3.setText(topNames.get(index));
                    time3.setText(topTimes.get(index));
                    break;
                case 3:
                    name4.setText(topNames.get(index));
                    time4.setText(topTimes.get(index));
                    break;
                case 4:
                    name5.setText(topNames.get(index));
                    time5.setText(topTimes.get(index));
                    break;
                case 5:
                    name6.setText(topNames.get(index));
                    time6.setText(topTimes.get(index));
                    break;
                case 6:
                    name7.setText(topNames.get(index));
                    time7.setText(topTimes.get(index));
                    break;
                case 7:
                    name8.setText(topNames.get(index));
                    time8.setText(topTimes.get(index));
                    break;
                case 8:
                    name9.setText(topNames.get(index));
                    time9.setText(topTimes.get(index));
                    break;
                case 9:
                    name10.setText(topNames.get(index));
                    time10.setText(topTimes.get(index));
                    break;
            }
        }
    }

    @FXML private void onClick(ActionEvent event){
        if (event.getSource().equals(backButton)){
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

        }
    }
}
