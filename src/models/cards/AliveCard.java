package models.cards;

public interface AliveCard extends Card {
    public int getBlood();
    public int getBone();
    public int getAttack();
    public void attack(Card opponent);
}
