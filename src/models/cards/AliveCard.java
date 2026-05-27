package models.cards;

public interface AliveCard extends Card {
    public int getBloodCost();
    public int getBoneCost();
    public int getAttack();
    public void attack(Card opponent);
}
