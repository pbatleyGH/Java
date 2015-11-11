package com.blackjack.deckTest;

import java.util.List;

/**
 * Created by Pete on 09/11/2015.
 */
public class GameState {

    // Variables
    private Integer playerStartingScore;
    private Integer dealerStartingScore;
    private Integer outcome; // 0 = loss, 1 = win, 2 = push;

    // Constructor

    public GameState(Integer playerStartingScore, Integer dealerStartingScore, Integer outcome) {
        this.playerStartingScore = playerStartingScore;
        this.dealerStartingScore = dealerStartingScore;
        this.outcome = outcome;
    }

    // Getters and Setters
    public Integer getPlayerStartingScore() {
        return playerStartingScore;
    }

    public void setPlayerStartingScore(Integer playerStartingScore) {
        this.playerStartingScore = playerStartingScore;
    }

    public Integer getDealerStartingScore() {
        return dealerStartingScore;
    }

    public void setDealerStartingScore(Integer dealerStartingScore) {
        this.dealerStartingScore = dealerStartingScore;
    }

    public Integer getOutcome() {
        return outcome;
    }

    public void setOutcome(Integer outcome) {
        this.outcome = outcome;
    }

}