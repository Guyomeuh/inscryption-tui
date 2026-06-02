package models.cards.decorators;

import models.cards.AliveCard;
import models.cards.Card;
import models.cards.ObjectCard;

public class TouchOfDeathAnimal extends AnimalDecorator {
    public TouchOfDeathAnimal(AliveCard card){
        super(card);
    }

    @Override
    public String getModif(){ return "Contact mortel"; }

    @Override
    public void attack(Card opponent){
        super.attack(opponent); // So SharpQuills animals can counter-attack before dying

        if (!(opponent instanceof ObjectCard)){
            opponent.getDamaged(Integer.MAX_VALUE);
        }
    }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
