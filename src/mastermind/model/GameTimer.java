package mastermind.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    //Time variables
    private SimpleStringProperty sspTime = new SimpleStringProperty("00:00:00");
    private long time;

    //Timer variables
    private Timer t = new Timer();
    private TimerTask tt;
    private boolean timing = false;

    public GameTimer() {
    }

    public void startTimer(final long time) {
        this.time = time;
        timing = true;

        tt = new TimerTask() {
            @Override
            public void run() {
                if (!timing) {
                    try {
                        tt.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    updateTime();
                }
            }
        };
        //Timer hits every 1000 ms, starting after 1000ms
        t.scheduleAtFixedRate(tt, 1000,1000);
    }

    public void stopTimer() {
        timing = false;
    }

    public void resumeTimer() {
        timing = true;
    }

    private void updateTime() {
        this.time = this.time + 1000;
        String[] split = getHMSTimeFormat();

        //Add extra '0' before number if only one digit
        sspTime.set((split[0].length() == 1 ? "0" + split[0] : split[0].substring(0, 2)) + ":" +
                    (split[1].length() == 1 ? "0" + split[1] : split[1].substring(0, 2)) + ":" +
                    (split[2].length() == 1 ? "0" + split[2] : split[2].substring(0, 2)));
    }

    public SimpleStringProperty getSspTime() {
        return sspTime;
    }

    private String[] getHMSTimeFormat(){
        String[] hms = new String[3];
        //Get total seconds
        long totalSecs = this.time/1000;

        //Convert total seconds to hours, minutes, seconds
        long hours = (totalSecs / 3600);
        long minutes = (totalSecs / 60) % 60;
        long seconds = totalSecs % 60;

        //Put hours, minutes, seconds into string array
        hms[0] = Integer.toString((int)hours);
        hms[1] = Integer.toString((int)minutes);
        hms[2] = Integer.toString((int)seconds);

        return hms;
    }
}