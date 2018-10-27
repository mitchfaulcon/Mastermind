package Mastermind.Model;

public class Timer {
    private static Timer instance = new Timer();

    public static Timer getInstance() {
        return instance;
    }

    private Timer() {
    }
}
