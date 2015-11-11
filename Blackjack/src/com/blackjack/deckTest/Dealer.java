package com.blackjack.deckTest;

import java.util.Random;

/**
 * Created by Pete on 08/11/2015.
 */
public class Dealer extends Player{

    // Fields
    private int softSeventeenHit;
    private Random rng;

    //Constructor

    public Dealer(String _playerName, int soft17hit) {
        super(_playerName);
        this.softSeventeenHit = soft17hit;
    }

    // Methods

    public void determinePlay(Integer playerScore)
    {
        handScore = getScore();
        if (handScore > playerScore || playerScore > 21) {
            stickFlag = 1;
        }

        if (stickFlag == 0) {
            if (handScore >= 17) {
                stickFlag = 1;
            }

            if (handScore < 17) {
                stickFlag = 0;
            }

            if (handScore == 17 && softFlag == 1) {
                stickFlag = 1 - softSeventeenHit;
            }
        }
    }

    public void printScoreFaceUp() {
        int t2 = getScore();
        System.out.println("The dealer's face up card is " + t2);
    }
}