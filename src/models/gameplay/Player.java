package models.gameplay;

import java.util.ArrayList;
import java.util.Random;

import models.cards.AliveCard;

public class Player extends Playable {
    private ArrayList<AliveCard> m_deck, m_hand;

    public Player(ArrayList<AliveCard> deck, PlayerBoard board){
        super(board);

        this.m_deck = deck;

        this.m_hand = new ArrayList<AliveCard>();
        this.initHand();
    }

    private void initHand(){
        for (int i = 0; i < BASE_CARD_NUMBER; i++){
            this.draw();
        }
    }

    private void validateHandIndex(int index){
        if (index < 0 || index >= this.getHandSize()){
            throw new IllegalArgumentException("Invalid hand index");
        }
    }

    private void validateDeckIndex(int index){
        if (index < 0 || index >= this.getDeckSize()){
            throw new IllegalArgumentException("Invalid deck index");
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

    @Override
    public boolean place(int position, int cardIndex){
        validateHandIndex(cardIndex);

        if (this.m_board.isOccupied(position)){
            return false;
        }

        this.m_board.set(position, this.m_hand.get(cardIndex));
        this.m_hand.remove(cardIndex);
        return true;
    }

    @Override
    public String toString(){
        return "Player: " + this.getDeckSize() + "cards in deck";
    }
}
