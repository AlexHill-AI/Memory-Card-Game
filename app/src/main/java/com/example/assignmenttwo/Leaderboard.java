package com.example.assignmenttwo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard {

    private static Leaderboard leaderBoardInstance = null;

    private static int[] IMG_ARRAY = new int[5];
    private ArrayList<Player> leaderboard = new ArrayList<>();

    /**
     * Singleton instance of the leaderboard, only allowing for one to ever be created
     */
    private Leaderboard(){
       IMG_ARRAY[0] = R.drawable.img_card_front_coder;
       IMG_ARRAY[1] =  R.drawable.img_card_front_artist;
       IMG_ARRAY[2] = R.drawable.img_card_front_astronaut;
       IMG_ARRAY[3] = R.drawable.img_card_front_doctor;
       IMG_ARRAY[4] = R.drawable.img_card_front_scientist;
    }

    /**
     *
     * @return the instance of the leaderboard
     */
    public static Leaderboard getInstance() {
        if (leaderBoardInstance == null) {
            leaderBoardInstance = new Leaderboard();
        }
        return leaderBoardInstance;
    }

    /**
     *
     * @return Returns the image array
     */
    public static int[] getImageArray() {
        return IMG_ARRAY;
    }

    /**
     * Adds players to the leaderboard
     * @param currentPlayer the most recent player who will be added to the leaderboard
     */
    public void updateLeaderboard(Player currentPlayer){
        if(currentPlayer != null){
            leaderboard.add(currentPlayer);
        }
    }

    /**
     *
     * @param context
     */
    public void displayLeaderboard(Context context){
        // Getting the player name and linking it to the textviews
        TextView[] nameViews = new TextView[]{
                ((Activity) context).findViewById(R.id.tv_leaderboard_name1),
                ((Activity) context).findViewById(R.id.tv_leaderboard_name2),
                ((Activity) context).findViewById(R.id.tv_leaderboard_name3),
                ((Activity) context).findViewById(R.id.tv_leaderboard_name4),
                ((Activity) context).findViewById(R.id.tv_leaderboard_name5)
        };

//        // Getting the player avatars and linking them to imageviews
        ImageView[] avatarViews = new ImageView[]{
                ((Activity) context).findViewById(R.id.iv_leaderboard_avatar1),
                ((Activity) context).findViewById(R.id.iv_leaderboard_avatar2),
                ((Activity) context).findViewById(R.id.iv_leaderboard_avatar3),
                ((Activity) context).findViewById(R.id.iv_leaderboard_avatar4),
                ((Activity) context).findViewById(R.id.iv_leaderboard_avatar5)
        };

        // Getting the player scores and linking them to textviews
        TextView[] scoreViews = new TextView[]{
                ((Activity) context).findViewById(R.id.tv_leaderboard_score1),
                ((Activity) context).findViewById(R.id.tv_leaderboard_score2),
                ((Activity) context).findViewById(R.id.tv_leaderboard_score3),
                ((Activity) context).findViewById(R.id.tv_leaderboard_score4),
                ((Activity) context).findViewById(R.id.tv_leaderboard_score5)
        };

        // Loop through and assign the player names, avatars, and scores
        for (int i = 0; i < leaderboard.size(); i++) {
            if(leaderboard.get(i) != null){
                Player currentPlayer = leaderboard.get(i);

                // Set the player's name, avatar, and score
                nameViews[i].setText(currentPlayer.getPlayerName());
                avatarViews[i].setImageDrawable(currentPlayer.getPlayerAvatar());
                scoreViews[i].setText(String.valueOf(currentPlayer.getPlayerScore()));
            }

        }

    }
}
