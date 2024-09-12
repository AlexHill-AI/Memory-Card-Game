package com.example.assignmenttwo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class GamePlay {
    private int MAX_MATCHES = 6;
    private int totalGuesses;
    private int totalCorrect;
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
        totalCorrect = 0;
        totalGuesses = 0;

        cardTypes.add("coder");
        cardTypes.add("coder");
        cardTypes.add("doctor");
        cardTypes.add("doctor");
        cardTypes.add("welder");
        cardTypes.add("welder");
        cardTypes.add("artist");
        cardTypes.add("artist");
        cardTypes.add("police");
        cardTypes.add("police");
        cardTypes.add("scientist");
        cardTypes.add("scientist");

        Collections.shuffle(cardTypes);

        for(int i = 0; i<=12; i++){
            String cardType = cardTypes.get(i);
            String cardFront = "img_card_front_" + cardType;
            String cardBack = "img_card_back";

            Card c = new Card(i, cardType, cardFront, cardBack);
            cards.add(c);
        }

    }

    /**
     *
     */
    public void setupImageViewsAndOnClicks() {
        //Add in a loop for the 12 cards
        for(int i = 0; i <= 12; i++){

            String cardID = "iv_card_" + i;
            // Get the resource ID using the generated string
            int resourceId = context.getResources().getIdentifier(cardID, "ID", context.getPackageName());

            //Grab the imageview id with this  ((Activity)context).findViewById(R.id.id_name)
            ImageView imageView = ((Activity)context).findViewById(resourceId);

            cardFirst.setImageviewCard(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flipCard(cards);
                }
            });
        }
    }

    /**
     * @param card
     */
    public void displayCardsFaceUp(Card card) {
        //check if the card is flipped
        //if not flipped flip
    }

    /**
     * @param card
     */
    public void displayCardsFaceDown(Card card) {
        //if cards are face up make them face down
    }

    /**
     *
     */
    public void displayCards() {
        //check cards matchs

    }

    /**
     * @param card
     */
    public void flipCard(Card card) {
        if(card.isFaceUp()){
            return;
        }

        if(cardFirst == null){
            cardFirst = card;
            displayCardsFaceUp(cardFirst);

        } else if(cardFirst != null && cardSecond == null){
            cardSecond = card;
            displayCardsFaceUp(cardSecond);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    displayCards();
                }
            }, 1000);
        }
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
        if(cardFirst != null && cardSecond != null){
            //if there is a match, add to the counter
            if (cardFirst.getCardType().equals(cardSecond.getCardType())) {
                totalCorrect++;
                //all matches found end the game
                if (totalCorrect == MAX_MATCHES) {
                    gameOver();
                } else {
                    displayCardsFaceDown(cardFirst);
                    displayCardsFaceDown(cardSecond);
                }
                updateGuessesTextview();
            }
        }
        cardFirst = null;
        cardSecond = null;
    }

    /**
     *
     */
    public void gameOver() {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra("score", totalGuesses);
        context.startActivity(intent);
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

}
