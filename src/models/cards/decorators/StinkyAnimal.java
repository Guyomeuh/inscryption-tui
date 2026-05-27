package models.cards.decorators;

import models.cards.AliveCard;

public class StinkyAnimal extends AnimalDecorator {
    public StinkyAnimal(AliveCard card){
        super(card);
    }

    @Override
    public void getDamaged(int damages){ super.getDamaged(damages - 1); }

    @Override
    public String getModif(){ return "Puant"; }

    @Override
    public String toString(){ return super.toString() + " Puant"; }
}
