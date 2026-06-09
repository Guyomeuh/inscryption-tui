package models.gameplay;

import models.cards.AliveCard;

import java.util.ArrayList;
import java.util.Optional;

public class PlayerBoard extends Board {
    private ArrayList<AliveCard> m_cemetary;


    public PlayerBoard() {
        super();
        m_cemetary = new ArrayList<AliveCard>();
    }

    public boolean getDamaged(int position, int damages){
        validatePosition(position);

        if (damages < 0){
            throw new IllegalArgumentException("damages must be superior than 0");
        }

        if (this.m_cards.get(position).isEmpty()) {
            return false;
        }

        this.m_cards.get(position).get().getDamaged(damages);

        // deletes the card if it's at 0Hp
        if (this.m_cards.get(position).get().getHp() <= 0) {
            if (this.m_cards.get(position).get() instanceof AliveCard) {
                this.m_cemetary.add((AliveCard) this.m_cards.get(position).get());
            }
            this.m_cards.set(position, Optional.empty());
        }

        return true;
    }

    public AliveCard getDeadCard(int index)
    {
        return m_cemetary.remove(index);
    }

    @Override
    public String toString(){
        return "PlayerBoard";
    }

    public int getCemetarySize()
    {
        return m_cemetary.size();
    }
}
