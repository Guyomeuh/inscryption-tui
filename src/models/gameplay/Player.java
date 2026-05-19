package models.gameplay;

import java.util.ArrayList;
import java.util.Random;

import models.cards.AliveCard;

public class Player {
    private static final int BASE_CARD_NUMBER = 4;
    private ArrayList<AliveCard> m_deck, m_hand;
    private PlayerBoard m_board;

    public Player(ArrayList<AliveCard> deck, PlayerBoard board){
        this.m_deck = deck;
        this.m_board = board;

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

    public boolean draw(){
        if (this.getDeckSize() == 0){
            return false;
        }

        int rndIndex = new Random().nextInt(0, this.getDeckSize()); // generates random index in [0, deckSize - 1]
        this.m_hand.add(this.m_deck.remove(rndIndex));

        return true;
    }

    public boolean place(int position, AliveCard card){
        if (this.m_board.isOccupied(position)){
            return false;
        }
        this.m_board.set(position, card);
        return true;
    }

    @Override
    public String toString(){
        return "Player: " + this.getDeckSize() + "cards in deck";
    }
}
