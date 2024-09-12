package com.example.assignmenttwo;

import android.content.Context;

public class Leaderboard {

    private Leaderboard leaderBoardInstance;

    /**
     * Singleton instance of the leaderboard, only allowing for one to ever be created
     */
    private Leaderboard(){

    }

    /**
     *
     * @return
     */
    public Leaderboard getInstance() {
        if (leaderBoardInstance == null) {
            leaderBoardInstance = new Leaderboard();
        }
        return leaderBoardInstance;
    }

    /**
     *
     */
    public int[] getImageArray() {
        return getImageArray();
    }

    /**
     *
     * @param currentPlayer
     */
    public void updateLeaderboard(Player currentPlayer){

    }

    /**
     *
     * @param context
     */
    public void displayLeaderboard(Context context){

    }
}
