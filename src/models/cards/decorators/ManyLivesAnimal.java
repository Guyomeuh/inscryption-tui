package models.cards.decorators;

import models.cards.AliveCard;

public class ManyLivesAnimal extends AnimalDecorator {
    public ManyLivesAnimal(AliveCard card){
        super(card);
    }
    
    @Override
    public String getModif(){ return "Nombreuses vies"; }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
