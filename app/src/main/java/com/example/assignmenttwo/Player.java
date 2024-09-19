package com.example.assignmenttwo;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * The player class to hold the players information
 */
public class Player {
    private String playerName;
    private Drawable playerAvatar;
    private int playerScore;

    /**
     * Initialising the player constructor
     * @param context, the context of the current application state
     * @param name, the name of the player
     * @param avatarID, the image the player will select
     * @param score, the players score
     */
    public Player(Context context, String name, int avatarID, int score){
        playerName = name;
        playerAvatar = context.getResources().getDrawable((Leaderboard.getInstance().getImageArray()[avatarID]),context.getTheme());
        playerScore = score;
    }

    /**
     * This method will return the players name
     * @return the name of the player
     */
    public String getPlayerName(){
        return playerName;
    }

    /**
     * This method will return the players avatar
     * @return the avatar of the player
     */
    public Drawable getPlayerAvatar(){
        return playerAvatar;
    }

    /**
     * This method will return the players score
     * @return the score of the player
     */
    public int getPlayerScore(){
        return playerScore;
    }

}
