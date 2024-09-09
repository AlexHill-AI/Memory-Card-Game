package com.example.assignmenttwo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;




public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
    }


    /**
     * Implementing a click event for the PlayerActivity content
     * Starts the GameActivity with the content from the PlayerActivity at index 0
     * @param v the view that is clicked
     */
    public void onClickGame(View v){
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}
