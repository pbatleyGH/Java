package com.blackjack.deckTest;

import java.io.PrintStream;

/**
 * Created by Pete on 22/10/2014.
 */
public class Card {

    // Fields
    public int suit;
    public int val;
    public int isAce;

    private char charSuit;
    private String charVal;

    // Constructor
    public Card(int Value, int Suit){
        this.suit = Suit;
        this.val = Value;
        if (val == 1) {
            this.isAce = 1;
        } else {
            this.isAce = 0;
        }
    }

    // Methods
    public void displayLn(){
        getSuit(suit);
        getVal(val);
        System.out.println(charVal + "" + charSuit);
    }

    public void display(){
        getSuit(suit);
        getVal(val);
        System.out.print(charVal + "" + charSuit + " ");
    }

    public int getCardScore(int softFlagStatus){
        if(this.val<=0 || this.val >=14){
            System.out.println("Card value out of bounds");
            System.exit(0);
        }

        if(this.val==1){
            // If hand is 'soft' ace is worth 11
            return 1+(10*softFlagStatus);
        }

        if(this.val>=11){
            return 10;
        }

        else if (this.val>=2 && this.val<=10){
            return this.val;
        }

        return 0;
    }

    private void getSuit(int suitVal) {
        switch (suitVal) {
            case 1:
                // Black Spade
                this.charSuit = '\u2660';
                break;

            case 2:
                // Red Heart
                this.charSuit = '\u2665';
                break;

            case 3:
                // Red Diamond
                this.charSuit = '\u2666';
                break;

            case 4:
                // Black Club
                this.charSuit = '\u2663';
                break;

            default:
                System.out.println("Suit value out of bounds");
                System.exit(0);
                break;
        }
    }

    private void getVal(int val){
        switch (val){
            case 1: this.charVal = "A"; break;
            case 2: this.charVal = "2"; break;
            case 3: this.charVal = "3"; break;
            case 4: this.charVal = "4"; break;
            case 5: this.charVal = "5"; break;
            case 6: this.charVal = "6"; break;
            case 7: this.charVal = "7"; break;
            case 8: this.charVal = "8"; break;
            case 9: this.charVal = "9"; break;
            case 10: this.charVal = "10"; break;
            case 11: this.charVal = "J"; break;
            case 12: this.charVal = "Q"; break;
            case 13: this.charVal = "K"; break;
            default:
                System.out.print("Card value out of bounds");
                System.exit(0);
                break;
        }
    }
}