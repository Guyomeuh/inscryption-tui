package models.gameplay;

public interface Playable {
    public static final int BASE_CARD_NUMBER = 4;

    public int[] endTurn();
    public boolean place(int position, int cardIndex);
    public boolean getDamaged(int position, int damages);
}
