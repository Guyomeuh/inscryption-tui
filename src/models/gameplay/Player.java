package models.gameplay;

import java.util.ArrayList;
import java.util.Random;

import models.cards.AliveCard;

public class Player {
    private ArrayList<AliveCard> m_deck, m_hand;
    private static final int BASE_CARD_NUMBER = 4;

    public Player(ArrayList<AliveCard> deck){
        this.m_deck = deck;

        this.m_hand = new ArrayList<AliveCard>();
        this.initHand();
    }

    private void initHand(){
        for (int i = 0; i < BASE_CARD_NUMBER; i++){
            this.draw();
        }
    }

    public int getDeckSize(){
        return this.m_deck.size();
    }

    public int getHandSize(){
        return this.m_hand.size();
    }

    public void draw(){
        int rndIndex = new Random().nextInt(0, this.getDeckSize()); // generates random index in [0, deckSize - 1]

        this.m_hand.add(this.m_deck.remove(rndIndex));
    }

    @Override
    public String toString(){
        return "Player: " + this.getDeckSize() + "cards in deck";
    }
}
