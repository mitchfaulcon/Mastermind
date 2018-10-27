package mastermind.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Leaderboard {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private final String leaderBoardFileName = "Top10Times.txt";
    private static Leaderboard instance = new Leaderboard();

    public static Leaderboard getInstance() {
        return instance;
    }

    private Leaderboard() {
    }

    public void updateLists(){
        try {
            File top10File = new File(leaderBoardFileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(top10File));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                //Split line at tab
                String nameAndTime[] = line.split("\t");

                //Add first index of split to names array
                names.add(nameAndTime[0]);

                //Add second index of split to time array
                times.add(nameAndTime[1]);
            }
        }
        catch (IOException ex){

        }
    }

    public ArrayList<String> getTopNames(){
        return names;
    }

    public ArrayList<String> getTopTimes(){
        return times;
    }
}
