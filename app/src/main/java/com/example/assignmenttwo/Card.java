package com.example.assignmenttwo;

import android.widget.ImageView;

public class Card {
    private int cardNum;
    private String cardType;
    private String cardBack;
    private String cardFront;
    private ImageView imageviewCard;
    private boolean isFaceUp;

    /**
     *
     * @param cNum
     * @param cType
     * @param cBack
     * @param cFront
     */
    public Card(int cNum, String cType, String cBack, String cFront){
        cardNum = cNum;
        cardType = cType;
        cardBack = cBack;
        cardFront = cFront;
    }

    /**
     *
     * @return
     */
    public int getCardNum(){
        return cardNum;
    }

    /**
     *
     * @return
     */
    public String getCardType(){
        return cardType;
    }

    /**
     *
     * @return
     */
    public String getCardBack(){
        return cardBack;
    }

    /**
     *
     * @return
     */
    public String getCardFront(){
        return cardFront;
    }

    /**
     *
     * @return
     */
    public boolean isFaceUp(){
        return isFaceUp;
    }

    /**
     *
     * @return
     */
    public boolean setFaceUp(boolean faceUp){
        this.isFaceUp = faceUp;
        return faceUp;
    }

    /**
     *
     * @return
     */
    public ImageView getImageviewCard(){
        return imageviewCard;
    }

    /**
     *
     * @param ivCard
     */
    public void setImageviewCard(ImageView ivCard){
        imageviewCard = ivCard;
    }

}

