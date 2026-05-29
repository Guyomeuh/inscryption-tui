package models.cards.decorators;

import models.cards.AliveCard;

public class StinkyAnimal extends AnimalDecorator {
    public StinkyAnimal(AliveCard card){
        super(card);
    }

    @Override
    public void getDamaged(int damages){ 
        // Avoid getting -1 of damages
        if (damages > 0){
            super.getDamaged(damages - 1); 
        }
        else {
            super.getDamaged(damages); 
        }
    }

    @Override
    public String getModif(){ return "Puant"; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
