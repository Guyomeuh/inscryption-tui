package models.cards;

public abstract class BaseCard implements Card {
    private String m_name;
    private int m_hp;

    public BaseCard(String name, int hp){
        this.m_name = name;
        this.m_hp = hp;
    }

    @Override
    public String getName(){
        return this.m_name;
    }

    @Override
    public int getHp(){
        return this.m_hp;
    }

    @Override
    public void getDamaged(int damages){
        // ensures hp >= 0
        if (damages <= this.m_hp){
            this.m_hp -= damages;
        }
        else {
            this.m_hp = 0;
        }
    }

    @Override
    public String toString(){
        return this.getName() + ": " + this.getHp() + "hp";
    }
}
