package com.blackjack.deckTest;

/**
 * Created by Pete on 09/11/2015.
 */
public class GameManager {

    private Player player;
    private Dealer dealer;
    private Deck deck;
    private GameState gameState;
    private GameStateManager gameStateManager;
    private Integer outcome;

    public GameManager(Player player, Dealer dealer, Deck deck, GameState gameState, GameStateManager gameStateManager) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.gameState = gameState;
        this.gameStateManager = gameStateManager;
        this.outcome = 0;
    }

    public GameState playOneRound(Boolean printTurns, Integer playerHits) {
//        deck.shuffle();

        // Deal 2 to dealer, record score of first
        dealer.play(deck.deal());
        if (printTurns == Boolean.TRUE) {
            dealer.printScoreFaceUp();
        }

        Integer dealerStartScore = dealer.getScore();
        dealer.play(deck.deal());

        player.play(deck.deal());
        player.play(deck.deal());
        Integer playerStartScore = player.getScore();
        if (printTurns == Boolean.TRUE) {
            player.printScore();
        }

        for (int i =0; i<playerHits; i++) {
            player.play(deck.deal());
            if (printTurns == Boolean.TRUE) {
                player.printScore();
            }
        }

        if (printTurns == Boolean.TRUE) {
            dealer.printScore();
        }

        dealer.determinePlay(player.getScore());

        while (dealer.stickFlag == 0) {
            dealer.play(deck.deal());
            if (printTurns == Boolean.TRUE) {
                dealer.printScore();
            }
            dealer.determinePlay(player.getScore());
        }

        findGameOutcome(player,dealer,printTurns);

        gameState.setPlayerStartingScore(playerStartScore);
        gameState.setDealerStartingScore(dealerStartScore);
        gameState.setOutcome(outcome);

        manageRoundEnding();

        return gameState;

    }

    public void manageRoundEnding() {

        gameStateManager.updateGameHistory(gameState);
        dealer.playerHand.endHand();
        player.playerHand.endHand();
        dealer.resetStickFlag();
        player.resetStickFlag();
        deck.shuffle();
    }


    private void findGameOutcome(Player player, Dealer dealer, Boolean printFlag){

        if (dealer.getScore() == player.getScore() && dealer.getScore() <= 21) {
            this.outcome = 2;
            if (printFlag == Boolean.TRUE) {
                System.out.println("Push");
            }
        }

        if (dealer.getScore() < player.getScore() && player.getScore() <= 21) {
            this.outcome = 1;
            if (printFlag == Boolean.TRUE) {
                System.out.println(player.playerName + " wins");
            }
        }

        if (dealer.getScore() > 21 && player.getScore() <= 21) {
            this.outcome = 1;
            if (printFlag == Boolean.TRUE) {
                System.out.println(player.playerName + " wins");
            }
        }

        if (this.outcome == 0) {
            if (printFlag == Boolean.TRUE) {
                System.out.println(dealer.playerName + " wins");
            }
        }
    }
}
