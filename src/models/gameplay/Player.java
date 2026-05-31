package models.gameplay;

import java.util.ArrayList;
import java.util.Random;

import models.cards.AliveCard;
import models.observer.PlayerObserver;

public class Player implements Playable {
    private ArrayList<AliveCard> m_deck;
    private ArrayList<AliveCard> m_hand;
    private int m_blood, m_bone;
    private ArrayList<PlayerObserver> m_observer;
    private PlayerBoard m_board;

    public Player(ArrayList<AliveCard> deck, PlayerBoard board, PlayerObserver observer){
        m_observer = new ArrayList<PlayerObserver>();
        m_observer.add(observer);

        this.m_deck = deck;
        this.m_board = board;
        this.m_hand = new ArrayList<AliveCard>();
        this.initHand();

        this.m_blood = 0;
        this.m_bone = 0;
        updateAll();
    }

    public void updateAll()
    {
        updatePlayerBoardStatus();
        updatePlayerBoardHp();
        updatePlayerBoardModif();
        updatePlayerBoardAtt();
        updatePlayerHand();
        updatePlayerBoardName();
        updatePlayerDeckCount();
    }



    public void reinitPlayer()
    {
        for (int i = 0; i < 4; i++)
        {
            m_board.getDamaged(i,999);
        }
        for(int i = m_board.getCemetarySize() - 1; i >= 0; i--)
        {
            m_deck.add(m_board.getDeadCard(i));
        }
        for(int i = m_hand.size() - 1; i >= 0; i--)
        {
            m_deck.add(m_hand.remove(i));
        }
    }

    public void setNewBoard(PlayerBoard board)
    {
        m_board = board;
    }

    public void updatePlayerDeckCount()
    {
        for(PlayerObserver i : m_observer)
        {
            i.updatePlayerDeckCount(getDeckSize());
        }
    }

    public void updatePlayerHand()
    {
        ArrayList<String> playerCards = new ArrayList<String>();

        for (int i = 0; i < m_hand.size(); i++)
        {
            playerCards.add(m_hand.get(i).toString());
        }

        for(PlayerObserver i : m_observer)
        {
            i.updatePlayerHand(playerCards);
        }
    }

    public void updatePlayerBoardStatus()
    {
        boolean[] playerBoard = new boolean[4];

        for (int i = 0; i < 4; i++)
        {
            playerBoard[i] = m_board.isOccupied(i);
        }

        for (PlayerObserver i : m_observer)
        {
            i.updatePlayerBoardStatus(playerBoard);
        }
    }

    public void updatePlayerBoardHp()
    {
        int[] playerBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            playerBoard[i] = m_board.getHp(i);
        }

        for (PlayerObserver i : m_observer)
        {
            i.updatePlayerBoardHp(playerBoard);
        }
    }

    public void updatePlayerBoardAtt()
    {
        int[] playerBoard = new int[4];

        for (int i = 0; i < 4; i++)
        {
            playerBoard[i] = m_board.getAttack(i);
        }

        for (PlayerObserver i : m_observer)
        {
            i.updatePlayerBoardAtt(playerBoard);
        }
    }

    public void updatePlayerBoardModif()
    {
        String[] playerBoard = new String[4];

        for (int i = 0; i < 4; i++)
        {
            playerBoard[i] = m_board.getModif(i);
        }
        for (PlayerObserver i : m_observer)
        {
            i.updatePlayerBoardModif(playerBoard);
        }
    }

    public void updatePlayerBoardName()
    {
        String[] playerBoard = new String[4];

        for (int i =0 ; i < 4; i++)
        {
            playerBoard[i] = m_board.getName(i);
        }

        for (PlayerObserver i : m_observer)
        {
            i.updatePlayerBoardName(playerBoard);
        }
    }


    public void initHand(){
        for (int i = 0; i < 4; i++){
            this.draw();
        }
    }

    private void validateHandIndex(int index){
        if (index < 0 || index >= this.getHandSize()){
            throw new IllegalArgumentException("Invalid hand index");
        }
    }

    private void validateDeckIndex(int index){
        if (index < 0 || index >= this.getDeckSize()){
            throw new IllegalArgumentException("Invalid deck index");
        }
    }

    public int getBlood(){
        return this.m_blood;
    }

    public int getBone(){
        return this.m_bone;
    }

    public int sacrifice(int position){
        int blood = this.m_board.sacrifice(position);

        this.m_blood += blood;

        updateAll();
        return blood;
    }

    public int getDeckSize(){
        return this.m_deck.size();
    }

    public int getHandSize(){
        return this.m_hand.size();
    }

    public boolean draw(){
        if (this.getDeckSize() == 0){
            return false;
        }

        int rndIndex = new Random().nextInt(this.getDeckSize()); // generates random index in [0, deckSize - 1]
        this.m_hand.add(this.m_deck.remove(rndIndex));
        updatePlayerDeckCount();
        updatePlayerHand();
        return true;
    }

    public int availableBlood()
    {
        int availableBlood = 0;
        for (int i = 0; i < 4; i++)
        {
            if (m_board.isSacrifiable(i))
            {
                availableBlood+=m_board.getBlood(i);
            }
        }
        return availableBlood;
    }

    public int getBloodCost(int cardIndex)
    {
        validateHandIndex(cardIndex);

        return m_hand.get(cardIndex).getBloodCost();
    }

    @Override
    public boolean place(int position, int cardIndex){
        validateHandIndex(cardIndex);

        if (this.m_board.isOccupied(position)){
            return false;
        }

        this.m_blood -= this.m_hand.get(cardIndex).getBloodCost();
        this.m_board.set(position, this.m_hand.get(cardIndex));
        this.m_hand.remove(cardIndex);
        updatePlayerBoardStatus();
        updatePlayerBoardName();
        updatePlayerBoardHp();
        updatePlayerBoardAtt();
        updatePlayerBoardModif();
        updatePlayerHand();
        return true;
    }

    @Override
    public boolean getDamaged(int position, int damages) {
        return this.m_board.getDamaged(position, damages);
    }

    @Override
    public int[] endTurn(){
        this.m_blood = 0;
        int[] damages = new int[4];

        for (int i = 0; i < 4; i++){
            damages[i] = this.m_board.getAttack(i);
        }

        return damages;
    }

    @Override
    public String toString(){
        return "Player: " + this.getDeckSize() + "cards in deck";
    }
}
