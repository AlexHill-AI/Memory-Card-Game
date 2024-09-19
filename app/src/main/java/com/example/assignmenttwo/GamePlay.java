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

/**
 * The gameplay class manages cards and the game details
 */
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
     * Constructor the gameplay class
     * This method will initialize the context for the game
     * @param context, the current context of the application
     */
    public GamePlay(Context context) {
        this.context = context;
    }

    /**
     * This method sets up the game to be reset everytime it is run
     */
    public void setUpGame() {
        totalCorrect = 0;
        totalGuesses = 0;
        isFirstGuess = false;
        cardTypes = new ArrayList<>();
        cards = new ArrayList<>();
        cardFirst = null;
        cardSecond = null;

        //Adding cards to cardTypes
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

        //Creating 12 cards and assigning the front and back images
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
     * This method sets up the images with the cards
     * Getting the cards and assigning IDs from the layout to them
     */
    public void setupImageViewsAndOnClicks() {
        //Add in a loop for the 12 cards
        for(int i = 0; i < 12; i++){
            Card card = cards.get(i);
            String cardID = "iv_card_" + card.getCardNum();
            // Get the resource ID using the generated string
            int resourceId = context.getResources().getIdentifier(cardID, "id", context.getPackageName());

            //Grab the imageview id
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
     * @param card, the card that is going to be flipped
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
     * @param card, the cards that is going to be displayed
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
     * Checks if 2 cards are a match then displays them
     */
    public void displayCards() {
        checkCardMatch();
    }

    /**
     * Assigns variables to the first and second cards
     * then displays turns them face up
     * @param card, the cards that are going to flipped
     */
    public void flipCard(Card card) {
        //If the card is face up, do nothing
        if (card.isFaceUp()) {
            return;
        }
        //Assigning the first card to a variable then flipping it
        if (cardFirst == null) {
            cardFirst = card;
            displayCardsFaceUp(cardFirst);
        //Assigning the second card to a variable then flipping it
        } else if (cardSecond == null) {
            cardSecond = card;
            displayCardsFaceUp(cardSecond);

            //Creates a delay of 1 second after 2 cards have been flipped
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
     * When a card is clicked it will get the tage associated with it,
     * then flip the card
     * @param view, the card that will be clicked
     */
    public void onclickCard(View view) {
        // Retrieve the Card object based on the tag
        Card clickedCard = getCardByCardNum(Integer.parseInt(view.getTag().toString()));
        flipCard(clickedCard);
    }

    /**
     * This method checks if cards are a match by checking the cardType,
     * If no matches are found end the game and flip the non matched cards back over
     */
    public void checkCardMatch() {
        //If the first or second card are not flipped, do nothing
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
     * Goes to the player activity page when all matches are found
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
