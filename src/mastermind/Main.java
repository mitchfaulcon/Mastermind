package mastermind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    private static Stage _stage;
    private final String leaderBoardFileName = "Top10Times.txt";

    @Override
    public void start(Stage primaryStage) throws Exception{

//        //set event handler for when user presses 'x' button on stage.
//        primaryStage.setOnCloseRequest(evt -> {
//            // prevent window from closing
//            evt.consume();
//
//            // execute own shutdown procedure
//            shutdown();
//        });


        //Change to home screen
        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));
        primaryStage.setTitle("MasterMind");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
        primaryStage.setResizable(false);

        _stage = primaryStage;

        createLeaderboardFile();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void ChangeScene(Scene scene) {
        //Change to input scene
        _stage.setScene(scene);
        _stage.sizeToScene();
    }

    private void createLeaderboardFile(){
        File leaderboardFile = new File(leaderBoardFileName);

        try {
            //Creates 'Top10Times.txt' file if it does not exist
            if (leaderboardFile.createNewFile()){
                //If file did not exist, populate with dummy data
                populateLeaderboard();
            }
        } catch (IOException e) {

        }
    }

    private void populateLeaderboard(){

        try {
            //Writer to write to leaderboard txt file
            FileWriter fileWriter = new FileWriter(leaderBoardFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i=1;i<=10;i++){
                String entry = "Player " + i + "\t0:" + (i+9) + ":00";
                bufferedWriter.write(entry);

                //Add newline char if not last entry
                if (i<10){
                    bufferedWriter.write("\n");
                }
            }

            //Close files
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException ex){

        }
    }

    //    private void shutdown(){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit MasterMind?", ButtonType.YES, ButtonType.NO);
//        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
//            //Quit
//            System.exit(1);
//        }
//    }
}

