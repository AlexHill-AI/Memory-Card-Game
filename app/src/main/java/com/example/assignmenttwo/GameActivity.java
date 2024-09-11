package com.example.assignmenttwo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class GameActivity extends AppCompatActivity {

    private GamePlay gamePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        // Initialize the gamePlay instance with the current context
        gamePlay = new GamePlay(this);
        // Start the game when the activity is created
        startGame();
    }
    Intent intent = getIntent();

    /**
     *
     */
    public void startGame(){
        gamePlay.startGame();
    }

    /**
     * Implementing a click event for the PlayerActivity content
     * Starts the GameActivity
     * @param v the view that is clicked
     */
    public void onClickGame(View v){
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}
