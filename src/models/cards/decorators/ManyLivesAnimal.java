package models.cards.decorators;

import models.cards.AliveCard;

public class ManyLivesAnimal extends AnimalDecorator {
    private boolean m_hasBeenSacrificedThisTurn = false;

    public ManyLivesAnimal(AliveCard card){
        super(card);
    }
    
    @Override
    public String getModif(){ return "Nombreuses vies"; }

    @Override
    public boolean isSacrifiable(){
        return !m_hasBeenSacrificedThisTurn && super.isSacrifiable();
    }

    @Override
    public void onSacrifice(){
        m_hasBeenSacrificedThisTurn = true;
    }

    @Override
    public void resetTurn(){
        m_hasBeenSacrificedThisTurn = false;
    }

    @Override
    public String toString(){ return super.toString() + " " + this.getModif(); }
}
