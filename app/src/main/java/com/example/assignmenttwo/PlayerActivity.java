package com.example.assignmenttwo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayerActivity extends AppCompatActivity {

    private int playerScore;
    private int avatarID;
    private String playerName;
    private Intent intent;
    private Leaderboard leaderboardInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_players);

        leaderboardInstance = Leaderboard.getInstance();

        //Get the text view for the score
        TextView tvScore = findViewById(R.id.tv_playerscore);

        //Getting the totalGuess passed from gameplay
        Intent intent = getIntent();
        playerScore = intent.getIntExtra("Guesses", -1);
        //Set the score to the new text view
        tvScore.setText("Your Score: " + playerScore);

        RadioGroup avatar = (RadioGroup) findViewById(R.id.rg_avatar);
        avatar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int tag) {

                RadioButton selected = findViewById(tag);

                int tagIndex = Integer.parseInt(selected.getTag().toString());

                //if a button is not clicked do nothing
                if(tagIndex == -1){
                    return;
                }
                int[] imageArray = Leaderboard.getInstance().getImageArray();
                avatarID = imageArray[tagIndex];
            }
        });
    }

    /**
     *
     * @param v
     */
    public void onClickSubmit(View v){


        //Gets the player name from the edit text
        EditText name = findViewById(R.id.et_playername);
        playerName = name.getText().toString();


        //avatarID = Integer.parseInt(radioChoice.getTag().toString());




        Player currentPlayer = new Player(this, playerName, avatarID, playerScore);


        Leaderboard.getInstance().updateLeaderboard(currentPlayer);


        //Changed to the leaderboard activity when selected
        Intent intent = new Intent(this, Leaderboard_Activity.class);
//        intent.putExtra("Name", playerName);
//        intent.putExtra("", avatarID);
//        intent.putExtra("", playerScore);
        startActivity(intent);
    }

}
