package models.cards.decorators;

import models.cards.Card;

public abstract class ObjectDecorator implements Card {
    private Card m_card;

    public ObjectDecorator(Card card){
        this.m_card = card;
    }

    @Override
    public String toString(){
        return this.m_card.toString();
    }
}
