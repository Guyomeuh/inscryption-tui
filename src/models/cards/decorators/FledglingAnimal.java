package models.cards.decorators;

import models.cards.AliveCard;

public class FledglingAnimal extends AnimalDecorator {
    public FledglingAnimal(AliveCard card){
        super(card);
    }
    
    @Override
    public String getModif(){ return "Croissance"; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
