package models.gameplay;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.observer.BotObserver;
import models.observer.GameObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private int m_gameNumber;
    private final Player m_player;
    private final ArrayList<AliveCard> m_baseDeck;
    private final Map<String, ArrayList<String>> m_animalModifiers = new HashMap<>();
    private Combat m_combat;
    private ArrayList<GameObserver> m_observer;
    private BotObserver m_botObserver;

    public Game(Player player, ArrayList<AliveCard> deck, GameObserver gameObs, BotObserver botObs)
    {
        m_player = player;
        m_baseDeck = new ArrayList<>(deck);
        m_observer = new ArrayList<>();
        m_observer.add(gameObs);
        m_botObserver = botObs;
        m_gameNumber = 1;
        reinitPlayer();
        MatchStrategy strategy = new FirstMatch();
        m_combat = new Combat(m_player, strategy, m_botObserver);
        updateAll();
    }
    public void botTurn()
    {
        m_combat.botTurn();
        updateBalance();
        updateTurn();
    }

    public void setStrategy(MatchStrategy strategy)
    {
        MatchStrategy newStrategy = strategy;
        m_combat = new Combat(m_player, newStrategy, m_botObserver);
    }

    public void updateAll()
    {
        updateTurn();
        updateBalance();
        updateGameNumber();
    }
    public void nextCombat()
    {
        MatchStrategy strategy;
        if (m_gameNumber == 1)
        {
            strategy = new SecondMatch();
            m_gameNumber++;
        }
        else if (m_gameNumber == 2)
        {
            strategy = new ThirdMatch();
            m_gameNumber++;
        }
        else
        {
            strategy = new FirstMatch();
            m_gameNumber = 1;
        }

        reinitPlayer();
        m_combat = new Combat(m_player, strategy, m_botObserver);
        updateAll();
    }

    public void addNewCard(String cardName){
        AliveCard card;
        switch (cardName) {
            case "Elan":
                card = AliveCardFactory.Elan();
                break;

            case "Vipère":
                card = AliveCardFactory.Vipere();
                break;

            case "Porc-épic":
                card = AliveCardFactory.PorcEpic();
                break;

            // never the case
            default:
                card = AliveCardFactory.Vipere();
                break;
        }
        card = applyExtraModifiers(card);
        this.m_player.addToDeck(card);
        this.m_baseDeck.add(AliveCardFactory.Copy(card));
    }

    public int getGameNumber(){
        return this.m_gameNumber;
    }

    private AliveCard applyExtraModifiers(AliveCard card)
    {
        ArrayList<String> extras = m_animalModifiers.get(card.getName());
        if (extras == null || extras.isEmpty())
        {
            return card;
        }

        for (String modifier : extras)
        {
            if (!AliveCardFactory.getModifiers(card).contains(modifier))
            {
                card = AliveCardFactory.applyModifier(card, modifier);
            }
        }

        return card;
    }

    public void registerAnimalModifiers(String animalName, ArrayList<String> modifiers)
    {
        ArrayList<String> existing = m_animalModifiers.computeIfAbsent(animalName, k -> new ArrayList<>());
        for (String modifier : modifiers)
        {
            if (!existing.contains(modifier))
            {
                existing.add(modifier);
            }
        }

        this.m_player.applyModifiersToExistingCards(m_animalModifiers);
    }

    public ArrayList<String> getDeckCardDescriptions()
    {
        return this.m_player.getDeckCards();
    }

    public String getDeckCardName(int index)
    {
        return this.m_player.getDeckCardName(index);
    }

    public AliveCard removeDeckCard(int index)
    {
        return this.m_player.removeDeckCard(index);
    }

    public void applyRegisteredModifiers()
    {
        this.m_player.applyModifiersToExistingCards(m_animalModifiers);
    }

    public boolean endTurn()
    {
        boolean res = m_combat.endTurn();
        updateAll();
        return res;
    }

    public void reinitPlayer()
    {
        m_player.reinitPlayer(buildPlayerDeckForGame(m_gameNumber));
        m_player.initHand();
        applyRegisteredModifiers();
        m_player.updateAll();
    }

    private ArrayList<AliveCard> buildPlayerDeckForGame(int gameNumber)
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (AliveCard card : m_baseDeck)
        {
            deck.add(AliveCardFactory.Copy(card));
        }

        if (gameNumber == 2)
        {
            replaceDeckCard(deck, "Chat", AliveCardFactory.Loup());
            replaceDeckCard(deck, "Chat", AliveCardFactory.Hermine());
        }
        else if (gameNumber == 3)
        {
            replaceDeckCard(deck, "Chat", AliveCardFactory.Grizzly());
            replaceDeckCard(deck, "Chat", AliveCardFactory.Corbeau());
            replaceDeckCard(deck, "Chat", AliveCardFactory.Vipere());
        }

        return deck;
    }

    private void replaceDeckCard(ArrayList<AliveCard> deck, String sourceName, AliveCard replacement)
    {
        for (int i = 0; i < deck.size(); i++)
        {
            if (deck.get(i).getName().equals(sourceName))
            {
                deck.set(i, replacement);
                return;
            }
        }

        deck.add(replacement);
    }

    public int getBloodCost(int cardIndex)
    {
        return m_player.getBloodCost(cardIndex);
    }

    public int getBoneCost(int cardIndex){
        return m_player.getBoneCost(cardIndex);
    }

    public int getPlayerBone()
    {
        return m_player.getBone();
    }
    public int sacrifice(Integer position)
    {
        return m_combat.sacrifice(position);
    }

    public boolean place(Integer position, Integer numCard)
    {
        return m_combat.place(position, numCard);
    }

    public int getHandSize()
    {
        return m_player.getHandSize();
    }
    public int getDeckSize() { return m_player.getDeckSize();}

    public int availableBlood()
    {
        return m_combat.availableBlood();
    }

    public boolean draw()
    {
        return m_combat.draw();
    }

    public void addObserver(GameObserver observer)
    {
        m_observer.add(observer);
    }

    public void updateTurn()
    {
        for (GameObserver i : m_observer)
        {
            i.updateTurn(m_combat.getTurn());
        }
    }

    public void updateBalance()
    {
        for (GameObserver i : m_observer)
        {
            i.updateBalance(m_combat.getBalance());
        }
    }

    public void updateGameNumber()
    {
        for (GameObserver i : m_observer)
        {
            i.updateGameNumber(m_gameNumber);
        }
    }

    public int checkVictory()
    {
        return m_combat.checkVictory();
    }
}
