package mastermind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage _stage;

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

        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));
        primaryStage.setTitle("MasterMind");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
        primaryStage.setResizable(false);

        _stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }

    //change scene
    public static void ChangeScene(Scene scene) {
        _stage.setScene(scene);
        _stage.sizeToScene();
    }

    //    private void shutdown(){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit MasterMind?", ButtonType.YES, ButtonType.NO);
//        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
//            //Quit
//            System.exit(1);
//        }
//    }
}

