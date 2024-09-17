package com.example.assignmenttwo;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Leaderboard_Activity extends AppCompatActivity {

    private Leaderboard leaderboardInstance;
    // Initialize the Leaderboard instance with the current context
    Context contextLeaderboardActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard);

        leaderboardInstance.displayLeaderboard(contextLeaderboardActivity);
    }







}
