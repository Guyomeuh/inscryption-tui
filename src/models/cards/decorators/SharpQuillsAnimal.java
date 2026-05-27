package models.cards.decorators;

import models.cards.AliveCard;

public class SharpQuillsAnimal extends AnimalDecorator {
    public static final int COUNTER_ATTACK = 1;

    public SharpQuillsAnimal(AliveCard card){
        super(card);
    }

    @Override
    public String getModif(){ return "Piques pointues"; }

    @Override
    public void getDamaged(int damages){
    }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
