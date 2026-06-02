package models.cards.decorators;

import models.cards.AliveCard;

public class AirborneAnimal extends AnimalDecorator {
    public AirborneAnimal(AliveCard card){
        super(card);
    }
    
    @Override
    public String getModif(){ return "Volant"; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
