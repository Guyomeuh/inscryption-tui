package view;

import java.sql.SQLOutput;
import java.util.Scanner;

import models.cards.AliveCardFactory;

public class GeneralView {

    private GameTextObserver m_gameObserver;
    private PlayerTextObserver m_playerObserver;
    private BotTextObserver m_botObserver;
    private Scanner m_scanner;

    public GeneralView(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    {
        m_gameObserver = game;
        m_playerObserver = player;
        m_botObserver = bot;
        m_scanner = new Scanner(System.in);
    }

    public void show()
    {
        printGameInfo();
        printBotWaitingBoard();
        printBotBoard();
        printPlayerBoard();
        printPlayerHand();
        printAction();
    }

    public boolean gameStart()
    {
        boolean valid = false;

        while (!valid)
        {
            System.out.println("Lancer la partie ? (y/n)");
            String input = m_scanner.nextLine();
            switch (input)
            {
                case "y" -> {
                    return true;
                }
                case "n" -> System.exit(0);
                default -> System.out.println("Saisissez une réponse valide");
            }
        }
        return false;
    }

    public void askForBlood(int remainingSacrifice)
    {
        System.out.println("Vous devez sacrifier " + remainingSacrifice + " créatures\n[sacrifier] <position>");
    }

    public String promptUser()
    {
        return m_scanner.nextLine();
    }

    public void printGameInfo()
    {
        System.out.println("Partie : " + m_gameObserver.getGameNumber() + "\n" + m_gameObserver.getTurn() + " Tour:\n\n");
    }

    public void printBotWaitingBoard()
    {

        String endString = "\t\t";

        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "|" + String.format("%1$-11s",m_botObserver.getBotWaitingBoardName(i)) + "|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "*-----------*\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|PV: %1$-7s",m_botObserver.getBotWaitingBoardHp(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|Att: %1$-6s",m_botObserver.getBotWaitingBoardAtt(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|%1$-11s",m_botObserver.getBotWaitingBoardModif(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (int i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n\t\t\t | |\t\t\t | |\t\t\t | |\t\t\t | |\n";
        endString+="\t\t\t \\ /\t\t\t \\ /\t\t\t \\ /\t\t\t \\ /\n";

        System.out.println(endString);
    }

    public void printBotBoard()
    {
        String endString = "\t\t";

        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? "|" + String.format("%1$-11s",m_botObserver.getBotBoardName(i)) + "|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? "*-----------*\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? String.format("|PV: %1$-7s",m_botObserver.getBotBoardHp(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? String.format("|Att: %1$-6s",m_botObserver.getBotBoardAtt(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? String.format("|%1$-11s",m_botObserver.getBotBoardModif(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }


        System.out.println(endString);
    }

    public void printPlayerBoard()
    {
        String endString = "\n" + m_gameObserver.getBalance() + "\n\t\t";

        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? "|" + String.format("%1$-11s",m_playerObserver.getPlayerBoardName(i)) + "|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? "*-----------*\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? String.format("|PV: %1$-7s",m_playerObserver.getPlayerBoardHp(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? String.format("|Att: %1$-6s",m_playerObserver.getPlayerBoardAtt(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? String.format("|%1$-11s",m_playerObserver.getPlayerBoardModif(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_playerObserver.getPlayerBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }


        System.out.println(endString);
    }

    public void printPlayerHand()
    {
        String res = String.format("Votre main: %1$121s","*------------*") + "\n";
        for (int i = 0; i < m_playerObserver.getPlayerHandSize() + 6; i++)
        {
            if (i < 5 && i != 2 && i < m_playerObserver.getPlayerHandSize()) //Works
            {
                res += String.format("%1s %2$50s %3$80s", i+1 + ".", m_playerObserver.getPlayerHandCard(i),"|            |\n") ;
            }
            else if (i < 5 && i != 2 && i >= m_playerObserver.getPlayerHandSize()) //Works
            {
                res += String.format("%1$134s","|            |\n");
            }
            else if (i == 2 && i < m_playerObserver.getPlayerHandSize()) //Works
            {
                res+= String.format("%1$s %2$50s %3$78s",i+1+".",m_playerObserver.getPlayerHandCard(i),String.format("|     %1$-7s", m_playerObserver.getPlayerDeckCount())) + "|\n";
            }
            else if (i == 2 && i >= m_playerObserver.getPlayerHandSize())
            {
                res+= String.format("%1$119s|     %2$-7s","",m_playerObserver.getPlayerDeckCount()) + "|\n";
            }
            else if (i == 5 && i < m_playerObserver.getPlayerHandSize())
            {
                res+=   String.format("%1s %2$50s %3$80s",i+1 + ".",m_playerObserver.getPlayerHandCard(i),"*------------*\n");
            }
            else if (i == 5 && i >= m_playerObserver.getPlayerHandSize()) //Works
            {
                res+= String.format("%1$134s","*------------*\n");
            }
            else if (i < m_playerObserver.getPlayerHandSize())
            {
                res+= String.format("%1$s %2$50s",i+1+".",m_playerObserver.getPlayerHandCard(i)) + "\n";
            }
            else
            {
                res+= "\n";
            }
        }
        System.out.println(res);
    }

    public void printAction()
    {
        System.out.println("Action possibles :\n\t[fin] Terminer votre tour\n" +
                "\t[piocher] Piocher une carte\n" +
                "\t[placer <position> <numero de carte>] Placer une carte sur le plateau\n");
    }

    public void askNextGame()
    {
        System.out.println("Prêt pour une autre partie ? (y/n)");
    }

    public void askNewCard(){
        System.out.println("1. " + AliveCardFactory.Elan().toString());
        System.out.println("2. " + AliveCardFactory.Vipere().toString());
        System.out.println("3. " + AliveCardFactory.PorcEpic().toString());
        System.out.print("Choisir une nouvelle carte :");
    }
}
