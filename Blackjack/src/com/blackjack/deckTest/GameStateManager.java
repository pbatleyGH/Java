package com.blackjack.deckTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pete on 09/11/2015.
 */
public class GameStateManager {

    private List<GameState> gameHistory;

    public GameStateManager() {
        this.gameHistory = new ArrayList<GameState>();
    }

    public void updateGameHistory(GameState gameState) {

        // Save current state in the game history
        gameHistory.add(gameState);
    }
}
