package com.example.assignmenttwo;

import android.widget.ImageView;

/**
 * The card class to store the card information
 */
public class Card {
    private int cardNum;
    private String cardType;
    private String cardBack;
    private String cardFront;
    private ImageView imageviewCard;
    private boolean isFaceUp;

    /**
     * This method is the constructor for initialising the card properties
     * @param cNum the number assigned to the specific card
     * @param cType the type of the card
     * @param cBack the image of the back of the card
     * @param cFront the image of the front of the card
     */
    public Card(int cNum, String cType, String cBack, String cFront){
        cardNum = cNum;
        cardType = cType;
        cardBack = cBack;
        cardFront = cFront;
    }

    /**
     * This method returns the specific card number
     * @return cardNum, the number assigned to the specific card
     */
    public int getCardNum(){
        return cardNum;
    }

    /**
     * This method returns the type of card
     * @return cardType, the type of the card to be returned
     */
    public String getCardType(){
        return cardType;
    }

    /**
     * This method returns the back image of the card
     * @return cardBack, the back image of the card
     */
    public String getCardBack(){
        return cardBack;
    }

    /**
     * This method returns the front image of the card
     * @return
     */
    public String getCardFront(){
        return cardFront;
    }

    /**
     * This method will check if the card is face up
     * @return isFaceUp, true if the card is face up, false if face down
     */
    public boolean isFaceUp(){
        return isFaceUp;
    }

    /**
     * This method will set the card to face up
     * @param faceUp, true if face up, false if face down
     * @return
     */
    public boolean setFaceUp(boolean faceUp){
        this.isFaceUp = faceUp;
        return faceUp;
    }

    /**
     * This method will return the imageview linked with the card
     * @return imageviewCard, the imageview that will be used to display the card
     */
    public ImageView getImageviewCard(){
        return imageviewCard;
    }

    /**
     * This method will set the imageview with the specific card
     * @param ivCard, the card that will be linked with the imageview
     */
    public void setImageviewCard(ImageView ivCard){
        imageviewCard = ivCard;
    }

}

