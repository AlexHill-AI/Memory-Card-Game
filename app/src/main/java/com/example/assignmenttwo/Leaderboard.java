package com.example.assignmenttwo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard {

    private static Leaderboard leaderBoardInstance;

    private static int[] IMG_ARRAY = {
            R.drawable.img_card_front_coder,
            R.drawable.img_card_front_artist,
            R.drawable.img_card_front_astronaut,
            R.drawable.img_card_front_doctor,
            R.drawable.img_card_front_scientist,
    };
    private ArrayList<Player> leaderboard;

    /**
     * Singleton instance of the leaderboard, only allowing for one to ever be created
     */
    private Leaderboard(){
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


        //Getting the player name and linking it to the textview
        TextView nameV1 = ((Activity) context).findViewById(R.id.tv_leaderboard_name1);
        TextView nameV2 = ((Activity) context).findViewById(R.id.tv_leaderboard_name2);
        TextView nameV3 = ((Activity) context).findViewById(R.id.tv_leaderboard_name3);
        TextView nameV4 = ((Activity) context).findViewById(R.id.tv_leaderboard_name4);
        TextView nameV5 = ((Activity) context).findViewById(R.id.tv_leaderboard_name5);

        int[] playerName = new int[5];
        TextView[] nameViews = new TextView[]{nameV1, nameV2, nameV3, nameV4, nameV5};

        //Loop through and assign the variables
        for (int i = 0; i < leaderboard.size(); i++) {
            nameViews[i].setText(leaderboard.get(i));
        }

        ImageView avatarV1 = ((Activity) context).findViewById(R.id.iv_leaderboard_avatar1);
        ImageView avatarV2 = ((Activity) context).findViewById(R.id.iv_leaderboard_avatar2);
        ImageView avatarV3 = ((Activity) context).findViewById(R.id.iv_leaderboard_avatar3);
        ImageView avatarV4 = ((Activity) context).findViewById(R.id.iv_leaderboard_avatar4);
        ImageView avatarV5 = ((Activity) context).findViewById(R.id.iv_leaderboard_avatar5);

        int[] avatarID = new int[5];
        ImageView[] avatarViews = new ImageView[]{avatarV1, avatarV2, avatarV3, avatarV4, avatarV5};

        //Loop through and assign the variables
        for (int i = 0; i < leaderboard.size(); i++) {

        }

        TextView scoreV1 = ((Activity) context).findViewById(R.id.tv_leaderboard_score1);
        TextView scoreV2 = ((Activity) context).findViewById(R.id.tv_leaderboard_score2);
        TextView scoreV3 = ((Activity) context).findViewById(R.id.tv_leaderboard_score3);
        TextView scoreV4 = ((Activity) context).findViewById(R.id.tv_leaderboard_score4);
        TextView scoreV5 = ((Activity) context).findViewById(R.id.tv_leaderboard_score5);

        int[] playerScore = new int[5];
        TextView[] scoreViews = new TextView[]{scoreV1, scoreV2, scoreV3, scoreV4, scoreV5};

        //Loop through and assign the variables
        for (int i = 0; i < leaderboard.size(); i++) {

        }
    }
}
