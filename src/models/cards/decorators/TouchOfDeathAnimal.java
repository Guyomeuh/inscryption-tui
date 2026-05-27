package models.cards.decorators;

import models.cards.AliveCard;

public class TouchOfDeathAnimal extends AnimalDecorator {
    public TouchOfDeathAnimal(AliveCard card){
        super(card);
    }

    @Override
    public String getModif(){ return "Contact mortel"; }

    @Override
    public int getAttack(){ return Integer.MAX_VALUE; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
