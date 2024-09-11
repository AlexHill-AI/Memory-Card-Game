package com.example.assignmenttwo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class GamePlay {
    private int MAX_MATCHES = 6;
    private int totalGuesses = 0;
    private int totalCorrect = 0;
    private boolean isFirstGuess;
    private Card cardFirst;
    private Card cardSecond;
    private ArrayList<String> cardTypes;
    private ArrayList<Card> cards;
    private TextView textviewGuesses;
    private Context context;

    /**
     * @param context
     */
    public GamePlay(Context context) {
        this.context = context;
    }

    /**
     *
     */
    public void setUpGame() {

        Collections.shuffle(cards);

    }

    /**
     *
     */
    public void setupImageViewsAndOnClicks() {
        // Implement the logic to display and flip cards
    }

    /**
     * @param card
     */
    public void displayCardsFaceUp(Card card) {

    }

    /**
     * @param card
     */
    public void displayCardsFaceDown(Card card) {

    }

    /**
     *
     */
    public void displayCards() {

    }

    /**
     * @param card
     */
    public void flipCard(Card card) {

    }

    /**
     *
     */
    public void onclickCard(View view) {

    }

    /**
     * Checks if 2 cards match,
     * ends the game if all have been found,
     * then updates the guess counter
     */
    public void checkCardMatch() {
        totalGuesses++;
        //if there is a match, add to the counter
        if (cardFirst == cardSecond) {
            totalCorrect++;
            //all matches found end the game
            if (totalCorrect == MAX_MATCHES) {
                gameOver();
            }
        } else {
//            final Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            }, 1000);

        }
        updateGuessesTextview();
    }

    /**
     *
     */
    public void gameOver() {

    }

    /**
     * Retrieves a card by its number (used for identifying specific cards in the game).
     */
    public int getCardByCardNum(int cardNum) {
        return cardNum;
    }

    /**
     * Update the guesses TextView to reflect the total guesses made
     */
    public void updateGuessesTextview() {
        textviewGuesses.setText("Guesses: " + totalGuesses);
    }

    public void startGame() {
    }
}
