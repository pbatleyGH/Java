package com.blackjack.deckTest;

import java.util.ArrayList;

/**
 * Created by Pete on 23/10/2014.
 */
public class Hand {
    // Fields
    public int score;
    public int numCards;
    public int aceInHand;
    public ArrayList<Card> cardsInHand;

    // Constructor
    public Hand(){
        this.numCards = 0;
        this.score = 0;
        this.aceInHand = 0;
        cardsInHand = new ArrayList<Card>();
    }

    // Methods
    void addCard(Card A){
        cardsInHand.add(A);
        if(A.val == 1){
            aceInHand = 1;
        }
    }

    void endHand(){
        cardsInHand.clear();
    }

    int getScore(int softFlag){
        int score = 0;
        for (Card card : cardsInHand)
        {
            score += card.getCardScore(softFlag);
        }

        return score;
    }
}