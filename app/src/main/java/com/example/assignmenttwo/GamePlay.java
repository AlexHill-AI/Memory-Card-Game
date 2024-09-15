package com.example.assignmenttwo;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class GamePlay{
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
        isFirstGuess = false;
        cardTypes = new ArrayList<>();
        cards = new ArrayList<>();
        cardFirst = null;
        cardSecond = null;

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

        for(int i = 0; i < 12; i++){
            String cardType = cardTypes.get(i);
            String cardFront = "img_card_front_" + cardType;
            String cardBack = "img_card_back";

            Card c = new Card(i, cardType, cardBack, cardFront);
            cards.add(c);
        }
        setupImageViewsAndOnClicks();
    }

    /**
     *
     */
    public void setupImageViewsAndOnClicks() {
        //Add in a loop for the 12 cards
        for(int i = 0; i < 12; i++){
            Card card = cards.get(i);
            String cardID = "iv_card_" + card.getCardNum();
            // Get the resource ID using the generated string
            int resourceId = context.getResources().getIdentifier(cardID, "id", context.getPackageName());

            //Grab the imageview id with this  ((Activity)context).findViewById(R.id.id_name)
            ImageView imageView = ((Activity)context).findViewById(resourceId);

            card.setImageviewCard(imageView);

            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    onclickCard(view);

                }
            });

        }
        // Reference the guesses TextView
        textviewGuesses = ((Activity) context).findViewById(R.id.tv_num_guesses);
        updateGuessesTextview();
    }

    /**
     * Turn the card over if it is face down
     * @param card
     */
    public void displayCardsFaceUp(Card card) {

        if(card.isFaceUp()){
            return;
        } else {
            //Get the front card image and set it
            String image = card.getCardFront();
            int dID = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
            Drawable drawable = ((Activity)context).getDrawable(dID);

            //Update the imageview
            card.getImageviewCard().setImageDrawable(drawable);
            card.setFaceUp(true);
        }

    }

    /**
     * Turn the card over if it is face up
     * @param card
     */
    public void displayCardsFaceDown(Card card) {
        //if cards are face up make them face down
        if(!card.isFaceUp()){
            return;
        } else {
            //Get the back card image and set it
            String image = card.getCardBack();
            int dID = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
            Drawable drawable = ((Activity)context).getDrawable(dID);

            //Update the imageview
            card.getImageviewCard().setImageDrawable(drawable);
            card.setFaceUp(false);
        }
    }

    /**
     *
     */
    public void displayCards() {
        checkCardMatch();
    }

    /**
     *
     * @param card
     */
    public void flipCard(Card card) {
        if (card.isFaceUp()) {
            return;
        }
        if (cardFirst == null) {
            cardFirst = card;
            displayCardsFaceUp(cardFirst);

        } else if (cardSecond == null) {
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
     * When a card is clicked it will flip the cards
     */
    public void onclickCard(View view) {
        // Retrieve the Card object based on the tag
        Card clickedCard = getCardByCardNum(Integer.parseInt(view.getTag().toString()));
        flipCard(clickedCard);
    }

    /**
     * If the cards dont have values do nothing,
     * otherwise if 2 cards match add to the point counter,
     * ends the game if all have been found,
     * then updates the guess counter
     */
    public void checkCardMatch() {
        if(cardFirst == null || cardSecond == null){
            return;
        }
        totalGuesses++;

        //if there is a match, add to the counter
        if (cardFirst.getCardType().equals(cardSecond.getCardType())) {
            totalCorrect++;
            //all matches found end the game
            if (totalCorrect == MAX_MATCHES) {
                gameOver();
            }
        } else {
            // Flip the cards back face down if they don't match
            displayCardsFaceDown(cardFirst);
            displayCardsFaceDown(cardSecond);
        }

        //Reset the cards
        updateGuessesTextview();
        cardFirst = null;
        cardSecond = null;
    }

    /**
     * Goes to the player activity page when all matchs are done
     */
    public void gameOver() {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra("Guesses", totalGuesses);
        context.startActivity(intent);
    }

    /**
     * Retrieves a card by its number then returns it
     */
    public Card getCardByCardNum(int cardNum) {
        Card card = cards.get(cardNum);
        return card;
    }

    /**
     * Update the guesses TextView to reflect the total guesses made
     */
    public void updateGuessesTextview() {
        textviewGuesses.setText("Guesses: " + totalGuesses);
    }

}
