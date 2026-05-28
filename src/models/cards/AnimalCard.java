package models.cards;

public class AnimalCard extends BaseCard implements AliveCard {
    private int m_attack, m_bloodCost, m_boneCost;

    private AnimalCard(String name, int hp, int attack, int blood, int bone){
        super(name, hp);

        this.m_attack = attack;
        this.m_bloodCost = blood;
        this.m_boneCost = bone;
    }

    public static AnimalCard Chat()
    {
        return new AnimalCard("Chat",1,1,0,0);
    }

    public static AnimalCard Grizzly()
    {
        return new AnimalCard("Grizzly", 6, 4, 3, 0);
    }

    public static AnimalCard Coyote()
    {
        return new AnimalCard("Coyote", 1, 2, 0, 4);
    }

    public static AnimalCard Moineau()
    {
        return new AnimalCard("Moineau", 2,1,0,0);
    }

    public static AnimalCard Corbeau()
    {
        return new AnimalCard("Corbeau", 3, 2, 2, 0);
    }

    public static AnimalCard Ecureuil()
    {
        return new AnimalCard("Ecureuil", 1,0,0,0);
    }

    public static AnimalCard Hermine()
    {
        return new AnimalCard("Hermine", 3, 1, 1, 0);
    }

    public static AnimalCard Louveteau()
    {
        return new AnimalCard("Louveteau", 1,1,1,0);
    }

    public static AnimalCard Loup()
    {
        return new AnimalCard("Loup",2,3,2,0);
    }

    public static AnimalCard Punaise()
    {
        return new AnimalCard("Punaise", 2,1,0,2);
    }

    public static AnimalCard Elan()
    {
        return new AnimalCard("Elan", 4,2,2,0);
    }

    public static AnimalCard Vipere()
    {
        return new AnimalCard("Vipère",1, 1,2,0);
    }

    public static AnimalCard PorcEpic()
    {
        return new AnimalCard("Porc-épic", 2,1,1,0);
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
