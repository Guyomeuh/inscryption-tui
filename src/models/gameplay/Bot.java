package models.gameplay;

import java.util.ArrayList;

import models.cards.AliveCard;

public class Bot implements Playable {
    private PlayerBoard m_board, m_waitingBoard;
    private ArrayList<AliveCard> m_cards;

    public Bot(PlayerBoard board, PlayerBoard waitingBoard, ArrayList<AliveCard> cards){
        this.m_board = board;
        this.m_waitingBoard = waitingBoard;
        this.m_cards = cards;
    }

    private void validateDeckIndex(int index){
        if (index < 0 || index >= this.getCardsSize()){
            throw new IllegalArgumentException("Invalid deck index");
        }
    }

    public int getCardsSize(){
        return this.m_cards.size();
    }

    /** 
     *  transfer all present cards from waitingBoard to board 
     */
    public void transferCards(){
        for (int i = 0; i < PlayerBoard.SIZE; i++){
            if (this.m_waitingBoard.isOccupied(i)){
                this.m_board.set(i, this.m_waitingBoard.remove(i).get());
            }
        }
    }

    /**
     * Place a card in waitingBoard
     * @param position Card's position in waitingBoard
     * @param cardIndex Card's index in cards
     * @return true if placed, else false
     */
    @Override
    public boolean place(int position, int cardIndex){
        validateDeckIndex(cardIndex);
        if (this.m_waitingBoard.isOccupied(position)){
            return false;
        }

        this.m_waitingBoard.set(position, this.m_cards.get(cardIndex));
        this.m_cards.remove(cardIndex);
        return true;
    }

    @Override
    public int[] endTurn(){
        int[] damages = new int[4];

        for (int i = 0; i < BASE_CARD_NUMBER; i++){
            damages[i] = this.m_board.getAttack(i);
        }

        return damages;
    }

    @Override
    public boolean getDamaged(int position, int damages){
        return this.m_board.getDamaged(position, damages);
    }

    @Override
    public String toString(){
        return "Bot";
    }
}
