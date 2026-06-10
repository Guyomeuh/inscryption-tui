package models.gameplay;

import java.util.ArrayList;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.observer.BotObserver;

public class Bot implements Playable {
    private Board m_waitingBoard;
    private Board m_board;
    private ArrayList<AliveCard> m_cards;
    private ArrayList<BotObserver> m_observer;

    public Bot(Board board, Board waitingBoard, ArrayList<AliveCard> cards, BotObserver observer){
        this.m_board = board;
        this.m_waitingBoard = waitingBoard;
        this.m_cards = cards;
        this.m_observer = new ArrayList<>();
        this.m_observer.add(observer);
    }

    public Bot(Board board, Board waitingBoard, ArrayList<AliveCard> cards)
    {
        this.m_board = board;
        this.m_waitingBoard = waitingBoard;
        this.m_cards = cards;
        this.m_observer = new ArrayList<>();
    }

    public void updateAll()
    {
        updateBotWaitingBoardStatus();
        updateBotWaitingBoardModif();
        updateBotWaitingBoardAtt();
        updateBotWaitingBoardName();
        updateBotWaitingBoardHp();

        updateBotBoardModif();
        updateBotBoardAtt();
        updateBotBoardHp();
        updateBotBoardName();
        updateBotBoardStatus();
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
        for (int i = 0; i < Board.SIZE; i++){
            if (this.m_waitingBoard.isOccupied(i)){
                this.m_board.set(i, this.m_waitingBoard.remove(i).get());
            }
        }
        updateAll();

    }

    public boolean isAirborne(int position){
        return this.m_board.isAirborne(position);
    }

    public boolean isSprinter(int position){
        return this.m_board.isSprinter(position);
    }

    @Override
    public boolean getDamaged(int position, int damages) {
        return this.m_board.getDamaged(position, damages);
    }

    @Override
    public int[] endTurn() {
        this.m_board.resetTurn();
        int[] damages = new int[Board.SIZE];

        for (int i = Board.SIZE - 1; i >= 0; i--){
            // if a Fledgling card is still on the board, it's there since a turn ago
            if (this.m_board.getModif(i).equals("Croissance")){
                this.m_board.set(i, AliveCardFactory.Loup());
            }

            damages[i] = this.m_board.getAttack(i);

            if (this.m_board.isSprinter(i) && !this.m_board.moveRight(i)){
                this.m_board.moveLeft(i);
            }
        }
        return damages;
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
        updateAll();
        return true;
    }

    public void updateBotWaitingBoardStatus()
    {
        boolean[] botBoard = new boolean[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_waitingBoard.isOccupied(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotWaitingBoardStatus(botBoard);
        }
    }

    public void updateBotWaitingBoardHp()
    {
        int[] botBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_waitingBoard.getHp(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotWaitingBoardHp(botBoard);
        }
    }

    public void updateBotWaitingBoardAtt()
    {
        int[] botBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_waitingBoard.getAttack(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotWaitingBoardAtt(botBoard);
        }
    }

    public void updateBotWaitingBoardName()
    {
        String[] botBoard = new String[4];

        for (int i =0 ; i < 4; i++)
        {
            botBoard[i] = m_waitingBoard.getName(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotWaitingBoardName(botBoard);
        }
    }

    public void updateBotWaitingBoardModif()
    {
        String[] botBoard = new String[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_waitingBoard.getModif(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotWaitingBoardModif(botBoard);
        }
    }

    public void updateBotBoardStatus()
    {
        boolean[] botBoard = new boolean[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_board.isOccupied(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotBoardStatus(botBoard);
        }
    }

    public void updateBotBoardHp()
    {
        int[] botBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_board.getHp(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotBoardHp(botBoard);
        }
    }

    public void updateBotBoardAtt()
    {
        int[] botBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_board.getAttack(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotBoardAtt(botBoard);
        }
    }

    public void updateBotBoardModif()
    {
        String[] botBoard = new String[4];

        for (int i = 0; i < 4; i++)
        {
            botBoard[i] = m_board.getModif(i);
        }
        for (BotObserver i : m_observer)
        {
            i.updateBotBoardModif(botBoard);
        }
    }

    public void updateBotBoardName()
    {
        String[] botBoard = new String[4];

        for (int i =0 ; i < 4; i++)
        {
            botBoard[i] = m_board.getName(i);
        }

        for (BotObserver i : m_observer)
        {
            i.updateBotBoardName(botBoard);
        }
    }

    public void addObserver(BotObserver observer)
    {
        m_observer.add(observer);
    }


    @Override
    public String toString(){
        return "Bot";
    }
}
