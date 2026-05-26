package models.cards;

public interface Card {
    public String getName();
    public int getHp();
    public void getDamaged(int damages);
    public String getModif();
}
