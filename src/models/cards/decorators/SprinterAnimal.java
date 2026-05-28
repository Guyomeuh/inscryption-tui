package models.cards.decorators;

import models.cards.AliveCard;

public class SprinterAnimal extends AnimalDecorator {
    public SprinterAnimal(AliveCard card){
        super(card);
    }

    @Override
    public String getModif(){ return "Coureur"; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
