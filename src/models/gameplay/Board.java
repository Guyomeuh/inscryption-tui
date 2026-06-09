package models.gameplay;

import java.util.ArrayList;
import java.util.Optional;

import models.cards.AliveCard;
import models.cards.Card;

public class Board {
    protected static final int SIZE = 4;
    protected ArrayList<Optional<Card>> m_cards;

    public Board(){
        this.m_cards = new ArrayList<Optional<Card>>();

        for (int i = 0; i < SIZE; i++){
            this.m_cards.add(Optional.empty());
        }
    }

    protected void validatePosition(int position){
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

    public boolean moveRight(int position){
        validatePosition(position);

        if (position + 1 >= PlayerBoard.SIZE || this.m_cards.get(position + 1).isPresent()){
            return false;
        }

        Optional<Card> card = this.m_cards.get(position);
        this.m_cards.set(position, Optional.empty());
        this.m_cards.set(position + 1, card);

        return true;
    }

    public boolean moveLeft(int position){
        validatePosition(position);

        if (position - 1 < 0 || this.m_cards.get(position - 1).isPresent()){
            return false;
        }

        Optional<Card> card = this.m_cards.get(position);
        this.m_cards.set(position, Optional.empty());
        this.m_cards.set(position - 1, card);

        return true;
    }

    public String getName(int position)
    {
        validatePosition(position);
        if (m_cards.get(position).isPresent())
        {
            return m_cards.get(position).get().getName();
        }
        return "";
    }

    public int getHp(int position)
    {
        validatePosition(position);
        if (m_cards.get(position).isPresent())
        {
            return m_cards.get(position).get().getHp();
        }
        return 0;
    }

    public String getModif(int position)
    {
        validatePosition(position);
        if (m_cards.get(position).isPresent())
        {
            return m_cards.get(position).get().getAllModifs();
        }
        return "";
    }

    public Optional<Card> remove(int position){
        validatePosition(position);

        Optional<Card> c = this.m_cards.get(position);
        this.m_cards.set(position, Optional.empty());

        return c;
    }

    public int sacrifice(int position){
        validatePosition(position);
        int cardBlood = getBlood(position);

        if (!this.m_cards.get(position).isEmpty()){
            Card card = this.m_cards.get(position).get();
            card.onSacrifice();

            if (!card.getModif().equals("Nombreuses vies")){
                this.m_cards.set(position, Optional.empty());
            }
        }

        return cardBlood;
    }

    public void resetTurn(){
        for (int i = 0; i < SIZE; i++){
            if (this.m_cards.get(i).isPresent()){
                this.m_cards.get(i).get().resetTurn();
            }
        }
    }

    public int getBlood(int position)
    {
        validatePosition(position);
        if (this.m_cards.get(position).isEmpty()){
            return 0;
        }

        if (!(this.m_cards.get(position).get() instanceof AliveCard)){
            return 0;
        };
        return 1;
    }

    public boolean isSacrifiable(int position)
    {
        validatePosition(position);
        if (this.m_cards.get(position).isEmpty())
        {
            return false;
        }

        return this.m_cards.get(position).get().isSacrifiable();


    }

    public int getAttack(int position){
        validatePosition(position);

        // returns -1 if position is empty
        if (this.m_cards.get(position).isEmpty()){
            return 0;
        }

        // returns 0 if it's not an AliveCard (no attack)
        if (!(this.m_cards.get(position).get() instanceof AliveCard)){
            return 0;
        }

        return ((AliveCard)this.m_cards.get(position).get()).getAttack();
    }

    public boolean getDamaged(int position, int damages){
        validatePosition(position);

        if (damages < 0){
            throw new IllegalArgumentException("damages must be superior than 0");
        }

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

    public boolean isAirborne(int position){
        validatePosition(position);
        
        if (this.m_cards.get(position).isEmpty()){
            return false;
        }

        Card card = this.m_cards.get(position).get();

        return card.getModif().equals("Volant");
    }

    public boolean isSprinter(int position){
        validatePosition(position);
        
        if (this.m_cards.get(position).isEmpty()){
            return false;
        }

        Card card = this.m_cards.get(position).get();

        return card.getModif().equals("Coureur");
    }

    @Override
    public String toString(){
        return "PlayerBoard";
    }
}
