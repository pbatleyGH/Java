package com.blackjack.deckTest;

import java.util.Random;

/**
 * Created by Pete on 30/10/2014.
 */
public class Player {

    // Fields
    public Hand playerHand;
    public int handScore;
    public String playerName;

    public int stickFlag;
    public int softFlag;
    private Random rng;

    // Constructor
    public Player(String _playerName) {
        this.playerHand = new Hand();
        this.handScore = 0;
        this.stickFlag = 0;
        this.softFlag = 0;
        this.rng = new Random();
        this.playerName = _playerName;
    }

    // Methods
    private void determinePlay() {
        handScore = getScore();

        if (stickFlag == 0) {
            for (int i = 0; i < 1; i++) {

                if (handScore > 21) {
                    stickFlag = 1;
                }

                if (handScore <= 10) {
                    stickFlag = 0;
                } else {
                    if (rng.nextDouble() <= 0.5 && stickFlag == 0) {
                        stickFlag = 0;
                    } else {
                        stickFlag = 1;
                    }
                }
            }

        }
    }

    public void play(Card A) {
        // determinePlay();
        if (stickFlag == 0) {
            playerHand.addCard(A);
        }
    }

    public int getScore(){
        if (playerHand.aceInHand == 1) {
            softFlag = 1;
        }
        int t1 = playerHand.getScore(softFlag);
        if (softFlag == 1 && t1 > 21) {
            softFlag = 0;
            t1 = playerHand.getScore(softFlag);
        }

        return t1;
    }

    public void printScore() {
        int t2 = getScore();
        if (t2 < 21) {
            if (stickFlag == 1) {
                System.out.println(playerName + " sticks on " + t2);
            } else {
                System.out.println(playerName + " has " + t2);
            }

        }

        else {
            System.out.println(playerName + " goes bust!");
        }
    }

    public void resetStickFlag() {
        this.stickFlag = 0;
    }

}
