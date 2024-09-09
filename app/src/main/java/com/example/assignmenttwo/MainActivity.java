package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    /**
     * Implementing a click event for the about us content
     * Starts the GameActivity with the content from the  at index 0
     * @param v the view that is clicked
     */
    public void onClickGame(View v){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("index", 0);
        startActivity(intent);
    }
    /**
     * Implementing a click event for the Leaderboard content
     * Starts the Leaderboard_Activity with the content from LeaderBoard at index 1
     * @param v the view that is clicked
     */
    public void onClickLeaderBoard(View v){
        Intent intent = new Intent(this, Leaderboard_Activity.class);
        intent.putExtra("index", 0);
        startActivity(intent);
    }

}