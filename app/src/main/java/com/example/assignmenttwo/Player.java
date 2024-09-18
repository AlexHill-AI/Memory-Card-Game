package com.example.assignmenttwo;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Player {
    private String playerName;
    private Drawable playerAvatar;
    private int playerScore;

    /**
     *
     * @param context
     * @param name
     * @param avatarID
     * @param score
     */
    public Player(Context context, String name, int avatarID, int score){
        playerName = name;
        playerAvatar = context.getResources().getDrawable((Leaderboard.getInstance().getImageArray()[avatarID]),context.getTheme());
        playerScore = score;
    }

    /**
     *
     * @return
     */
    public String getPlayerName(){
        return playerName;
    }

    /**
     * 
     * @return
     */
    public Drawable getPlayerAvatar(){
        return playerAvatar;
    }

    /**
     *
     * @return
     */
    public int getPlayerScore(){
        return playerScore;
    }

}
