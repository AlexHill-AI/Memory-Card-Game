package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    /**
     * Implementing a click event for the about us content
     * Starts the GameActivity
     * @param v the view that is clicked
     */
    public void onClickGame(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    /**
     * Implementing a click event for the Leaderboard content
     * Starts the Leaderboard_Activity
     * @param v the view that is clicked
     */
    public void onClickLeaderBoard(View v){
        Intent intent = new Intent(this, Leaderboard_Activity.class);
        startActivity(intent);
    }

}