package models.cards;

public class AnimalCard extends BaseCard implements AliveCard {
    private int m_attack, m_bloodCost, m_boneCost;

    public AnimalCard(String name, int hp, int attack, int blood, int bone){
        super(name, hp);

        this.m_attack = attack;
        this.m_bloodCost = blood;
        this.m_boneCost = bone;
    }

    @Override
    public int getAttack(){
        return this.m_attack;
    }

    @Override
    public int getBloodCost(){
        return this.m_bloodCost;
    }

    @Override
    public int getBoneCost(){
        return this.m_boneCost;
    }

    @Override
    public void attack(Card opponent){
        opponent.getDamaged(this.m_attack);
    }

    @Override
    public String toString(){
        return super.toString() + ", " + this.getAttack() + " atk, " + this.getBloodCost() + " blood, " + this.getBoneCost() + " bones";
    }

    @Override
    public boolean isSacrifiable() {
        return true;
    }
}
