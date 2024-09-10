package com.example.assignmenttwo;

public class Leaderboard {


    private static Leaderboard leaderBoardInstance = null;

    public static Leaderboard getInstance() {
        if (leaderBoardInstance == null) {
            leaderBoardInstance = new Leaderboard();
        }
        return leaderBoardInstance;
    }
}
