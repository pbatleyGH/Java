package com.blackjack.deckTest;

import java.util.Random;

/**
 * Created by Pete on 23/10/2014.
 */
public class Deck {

    // Fields
    public static int numberCards = 52;
    public static int numberSuits = 4;
    public static int numCardsPerSuit = 13;

    private Card[] cards;
    private int numCardsLeft;

    // Constructor
    public Deck(int numberDecks){
        this.cards = new Card[numberCards*numberDecks];
        for (int i=0;i<numberDecks;i++) {
            for (int j = 0; j < numberSuits; j++) {
                for (int k = 0; k < numCardsPerSuit; k++) {
                    int arrayPos = i*numberCards + j*numCardsPerSuit + k;
                    cards[arrayPos] = new Card(k+1,j+1);
                }
            }
        }

        this.numCardsLeft = numberCards*numberDecks;
    }

    // Methods

    public Card[] getCards() {
        return cards;
    }

    public int getNumCardsLeft() {
        return numCardsLeft;
    }

    public void shuffle(){
        Random rng = new Random();
        Card[] shuffArr = new Card[this.cards.length];
        for (int i=this.cards.length - 1; i>0; i--){
            int j = rng.nextInt(i);
            Card t1 = cards[i];
            cards[i] = cards[j];
            cards[j] = t1;
        }
    }

    public Card deal(){
        if(numCardsLeft <= 0) {
            System.out.println("No cards left in deck");
            System.exit(0);
        }
        this.numCardsLeft -= 1;
        return cards[numCardsLeft];
    }
}
