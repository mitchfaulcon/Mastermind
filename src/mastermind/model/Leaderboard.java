package mastermind.model;

import java.io.*;
import java.util.ArrayList;

public class Leaderboard {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private final String leaderboardFileName = "Top10Times.txt";
    private static Leaderboard instance = new Leaderboard();

    public static Leaderboard getInstance() {
        return instance;
    }

    private Leaderboard() {
    }

    public void updateLists(){
        try {
            File top10File = new File(leaderboardFileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(top10File));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                //Split line at ','
                String nameAndTime[] = line.split(",");

                //Add first index of split to names array
                names.add(nameAndTime[0]);

                //Add second index of split to time array
                times.add(nameAndTime[1]);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getTopNames(){
        return names;
    }

    public ArrayList<String> getTopTimes(){
        return times;
    }

    public void addWinningTime(String newName, String newTime){

        //Run through top times array
        for (int index=0;index<times.size();index++){
            String time = times.get(index);
            //Check if time is less than current index
            if (newTime.compareTo(time) < 0){

                //Insert newTime and newName into correct position
                times.add(index,newTime);
                names.add(index,newName);

                //Remove 10th entry
                times.remove(10);
                names.remove(10);

                //Update text file
                updateTxt();

                break;
            }
        }
    }

    private void updateTxt(){

        try {
            FileWriter fileWriter = new FileWriter(leaderboardFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //Write names and times to file
            for (int index=0;index<names.size();index++){
                String line = names.get(index) + "," + times.get(index);
                bufferedWriter.write(line);

                //Add newline char if not last entry
                if (index!=names.size()-1){
                    bufferedWriter.write("\n");
                }
            }

            //Close files
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
