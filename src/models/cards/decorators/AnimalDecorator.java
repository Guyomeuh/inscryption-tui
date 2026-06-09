package models.cards.decorators;

import models.cards.AliveCard;
import models.cards.Card;

public abstract class AnimalDecorator implements AliveCard {
    private AliveCard m_card;

    public AnimalDecorator(AliveCard card){
        this.m_card = card;
    }

    public AliveCard getWrappedCard() {
        return m_card;
    }

    @Override
    public String getName() { return m_card.getName(); }

    @Override
    public int getHp() { return m_card.getHp(); }

    @Override
    public void getDamaged(int damages) { m_card.getDamaged(damages); }

    @Override
    public int getBloodCost() { return m_card.getBloodCost(); }

    @Override
    public int getBoneCost() { return m_card.getBoneCost(); }

    @Override
    public int getAttack() { return m_card.getAttack(); }

    @Override
    public void attack(Card opponent) { m_card.attack(opponent); }

    @Override
    public boolean isSacrifiable(){ return m_card.isSacrifiable(); }

    @Override
    public void onSacrifice(){ m_card.onSacrifice(); }

    @Override
    public void resetTurn(){ m_card.resetTurn(); }

    @Override
    public String toString() { return m_card.toString(); }
}
