package models.gameplay;

import java.util.ArrayList;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import models.observer.BotObserver;

public class Bot extends Playable {
    private PlayerBoard m_waitingBoard;
    private ArrayList<AliveCard> m_cards;
    private ArrayList<BotObserver> m_observer;

    public Bot(PlayerBoard board, PlayerBoard waitingBoard, ArrayList<AliveCard> cards, BotObserver observer){
        super(board);
        this.m_waitingBoard = waitingBoard;
        this.m_cards = cards;
        m_observer = new ArrayList<>();
        m_observer.add(observer);
    }

    public Bot(PlayerBoard board, PlayerBoard waitingBoard, ArrayList<AliveCard> cards)
    {
        super(board);
        this.m_waitingBoard = waitingBoard;
        this.m_cards = cards;
        m_observer = new ArrayList<>();
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
        for (int i = 0; i < PlayerBoard.SIZE; i++){
            if (this.m_waitingBoard.isOccupied(i)){
                this.m_board.set(i, this.m_waitingBoard.remove(i).get());
            }
        }
        updateAll();

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
