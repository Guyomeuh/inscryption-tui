package models.gameplay;

public interface Playable {
    public boolean getDamaged(int position, int damages);
    public int[] endTurn();
    public boolean place(int position, int cardIndex);
}
