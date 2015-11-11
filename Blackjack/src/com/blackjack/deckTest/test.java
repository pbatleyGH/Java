package com.blackjack.deckTest;

/**
 * Created by Pete on 23/10/2014.
 */
public class test {
    public static void main(String[] args) {

        // create player and dealer
        Player player = new Player("Andy");
        Dealer dealer = new Dealer("The Dealer", 1);
        GameState game = new GameState(0,0,0);
        Deck deck = new Deck(4);
        deck.shuffle();
        GameStateManager gameStateManager = new GameStateManager();
        GameManager gameManager = new GameManager(player, dealer, deck, game,gameStateManager);

        for (int n=0; n<3; n++) {
            game = gameManager.playOneRound(Boolean.TRUE, 1);
            gameStateManager.updateGameHistory(game);
            System.out.print("\n");
        }



        // Deck proof of concept

        //            Deck A = new Deck(1);
//        for (int j = 0; j < (A.cards).length; j++) {
//            A.cards[j].displayLn();
//
//        }
//            A.shuffle();
//            for (int i = 0; i < (A.cards).length; i++) {
//                A.cards[i].displayLn();
//
//            }



        // Single played game
        
//        A.shuffle();
//
//        Integer outcome = 0;
//
//        // Deal 2 to dealer, record score of first
//        dealer.play(A.deal());
//        dealer.printScoreFaceUp();
//        Integer dealerStartScore = dealer.getScore();
//        dealer.play(A.deal());
//
//        player.play(A.deal());
//        player.play(A.deal());
//        Integer playerStartScore = player.getScore();
//        player.printScore();
//
//        player.play(A.deal());
//        player.printScore();
//
//        dealer.printScore();
//        dealer.determinePlay(player.getScore());
//
//        while (dealer.stickFlag == 0) {
//            dealer.play(A.deal());
//            dealer.printScore();
//            dealer.determinePlay(player.getScore());
//        }
//
//        if (dealer.getScore() == player.getScore() && dealer.getScore() <= 21) {
//            outcome = 2;
//            System.out.println("Push");
//        }
//
//        if (dealer.getScore() < player.getScore() && player.getScore() <= 21) {
//            outcome = 1;
//            System.out.println(player.playerName + " wins");
//        }
//
//        if (dealer.getScore() > 21 && player.getScore() <= 21) {
//            outcome = 1;
//            System.out.println(player.playerName + " wins");
//        }
//
//        if (outcome == 0) {
//            System.out.println(dealer.playerName + " wins");
//        }
//
//
//        GameState game = new GameState(playerStartScore, dealerStartScore, outcome);
//        GameStateManager gameStateManager = new GameStateManager();
//        gameStateManager.updateGameHistory(game);
    }
}