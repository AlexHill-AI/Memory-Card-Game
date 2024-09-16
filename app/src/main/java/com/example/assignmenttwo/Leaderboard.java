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
        // Add a loop for 5 players
//        for (int i = 0; i < 5; i++) {
//            Player player = leaderboard.get(i);
//
//            String playerName = player.getPlayerName();
//            Drawable playerAvatar = player.getPlayerAvatar();
//            int playerScore = player.getPlayerScore();
//
//
//            int nameResId = context.getResources().getIdentifier("tv_leaderboard_name" + i, "id", context.getPackageName());
//            int avatarResId = context.getResources().getIdentifier("tv_leaderboard_score" + i, "id", context.getPackageName());
//            int scoreResId = context.getResources().getIdentifier("iv_leaderboard_avatar" + i, "id", context.getPackageName());
//
//            TextView nameV = ((Activity) context).findViewById(nameResId);
//            ImageView avatarV = ((Activity) context).findViewById(avatarResId);
//            TextView scoreV = ((Activity) context).findViewById(scoreResId);
//
//            nameV.setText(playerName);
//            avatarV.setImageDrawable(playerAvatar);
//            scoreV.setText(String.valueOf(playerScore));
//        }

    }
}
