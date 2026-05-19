package models.cards.decorators;

import models.cards.AliveCard;

public abstract class AnimalDecorator implements AliveCard {
    private AliveCard m_card;

    public AnimalDecorator(AliveCard card){
        this.m_card = card;
    }

    @Override
    public String toString(){
        return this.m_card.toString();
    }
}
