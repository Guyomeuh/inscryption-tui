package models.gameplay;

import java.util.ArrayList;
import java.util.Optional;

import models.cards.Card;

public class PlayerBoard {
    private static final int SIZE = 4;
    private ArrayList<Optional<Card>> m_cards;

    public PlayerBoard(){
        this.m_cards = new ArrayList<Optional<Card>>();

        for (int i = 0; i < SIZE; i++){
            this.m_cards.add(Optional.empty());
        }
    }

    private void validPosition(int position){
        if (position < 0 || position >= SIZE){
            throw new IllegalArgumentException("Invalid position");
        }
    }

    public boolean isOccupied(int position){
        validPosition(position);
        return this.m_cards.get(position).isPresent();
    }

    public void set(int position, Card card){
        validPosition(position);
        this.m_cards.set(position, Optional.of(card));
    }

    public void remove(int position){
        validPosition(position);
        this.m_cards.set(position, Optional.empty());
    }

    @Override
    public String toString(){
        return "PlayerBoard";
    }
}
