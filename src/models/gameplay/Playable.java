package models.gameplay;

public abstract class Playable {
    public static final int BASE_CARD_NUMBER = 4;
    protected PlayerBoard m_board;

    public Playable(PlayerBoard board){
        this.m_board = board;
    }

    public boolean getDamaged(int position, int damages){
        return this.m_board.getDamaged(position, damages);
    }

    public int[] endTurn(){
        int[] damages = new int[4];

        for (int i = 0; i < PlayerBoard.SIZE; i++){
            damages[i] = this.m_board.getAttack(i);

            if (this.m_board.isSprinter(i) && !this.m_board.moveRight(i)){
                this.m_board.moveLeft(i);
            }
        }

        return damages;
    }

    public boolean isAirborne(int position){
        return this.m_board.isAirborne(position);
    }

    public abstract boolean place(int position, int cardIndex);

    @Override
    public String toString(){
        return "Playable";
    }
}
