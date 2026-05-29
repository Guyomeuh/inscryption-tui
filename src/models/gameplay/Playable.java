package models.gameplay;

public interface Playable {
    public boolean getDamaged(int position, int damages);

    public int[] endTurn();

    public abstract boolean place(int position, int cardIndex);

    @Override
    public String toString();
}
