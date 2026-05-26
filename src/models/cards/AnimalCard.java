package models.cards;

public class AnimalCard extends BaseCard implements AliveCard {
    private int m_attack, m_blood, m_bone;

    public AnimalCard(String name, int hp, int attack, int blood, int bone){
        super(name, hp);

        this.m_attack = attack;
        this.m_blood = blood;
        this.m_bone = bone;
    }

    @Override
    public int getAttack(){
        return this.m_attack;
    }

    @Override
    public int getBlood(){
        return this.m_blood;
    }

    @Override
    public int getBone(){
        return this.m_bone;
    }

    @Override
    public void attack(Card opponent){
        opponent.getDamaged(this.m_attack);
    }

    @Override
    public String toString(){
        return super.toString() + ", " + this.getAttack() + " atk, " + this.getBlood() + " blood, " + this.getBone() + " bones";
    }
}
