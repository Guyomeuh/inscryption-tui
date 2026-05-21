package models.gameplay;

import java.util.ArrayList;
import java.util.Optional;

import models.cards.AliveCard;
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

    private void validatePosition(int position){
        if (position < 0 || position >= SIZE){
            throw new IllegalArgumentException("Invalid position");
        }
    }

    public boolean isOccupied(int position){
        validatePosition(position);
        return this.m_cards.get(position).isPresent();
    }

    public void set(int position, Card card){
        validatePosition(position);
        this.m_cards.set(position, Optional.of(card));
    }

    public void remove(int position){
        validatePosition(position);
        this.m_cards.set(position, Optional.empty());
    }

    public int getAttack(int position){
        validatePosition(position);

        if (this.m_cards.get(position).isEmpty()){
            return -1;
        }

        if (!(this.m_cards.get(position).get() instanceof AliveCard)){
            return 0;
        }

        return ((AliveCard)this.m_cards.get(position).get()).getAttack();
    }

    public boolean getDamaged(int position, int damages){
        validatePosition(position);

        if (this.m_cards.get(position).isEmpty()){
            return false;
        }

        this.m_cards.get(position).get().getDamaged(damages);

        // deletes the card if it's at 0Hp
        if (this.m_cards.get(position).get().getHp() == 0){
            this.m_cards.set(position, Optional.empty());
        }

        return true;
    }

    @Override
    public String toString(){
        return "PlayerBoard";
    }
}
