package view;

import java.sql.SQLOutput;

public class GeneralView {

    private GameTextObserver m_gameObserver;
    private PlayerTextObserver m_playerObserver;
    private BotTextObserver m_botObserver;

    public GeneralView(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    {
        m_gameObserver = game;
        m_playerObserver = player;
        m_botObserver = bot;
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

    public void printGameInfo()
    {
        System.out.println("Partie : " + m_gameObserver.getGameNumber() + "\n" + m_gameObserver.getTurn() + " Tour:\n\n");
    }

    public void printBotWaitingBoard()
    {
        String endString = "\t\t";

        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "|" + String.format("%1$-11s",m_botObserver.getBotWaitingBoardName(i)) + "|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? "*-----------*\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|PV: %1$-7s",m_botObserver.getBotWaitingBoardHp(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|Att: %1$-6s",m_botObserver.getBotWaitingBoardAtt(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBotWaitingBoardStatus(i)) ? String.format("|%1$-11s",m_botObserver.getBotWaitingBoardModif(i)) +"|\t" : "*           *\t";
        }
        endString+="\n\t\t";
        for (Integer i = 0; i < 4; i++)
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
        String endString = "\t\t";

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
        String res = "Votre main: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t *------------*\n";
        for (int i = 0; i < m_playerObserver.getPlayerHandSize(); i++)
        {
            if (i < 5 && i != 2)
            {
                res+= i+1 + "." + m_playerObserver.getPlayerHandCard(i) + "\t\t\t\t\t\t\t\t\t\t\t\t\t |            |\n";
            }
            else if (i == 2)
            {
                res+= i+1 + "." + m_playerObserver.getPlayerHandCard(i) + "\t\t\t\t\t\t\t\t\t\t\t\t\t " + String.format("|     %1$-7s", m_playerObserver.getPlayerDeckCount()) + "|\n";
            }
            else if (i == 5)
            {
                res+= i+1 + "." + m_playerObserver.getPlayerHandCard(i) + "\t\t\t\t\t\t\t\t\t\t\t\t\t " + "*------------*\n";
            }
            else
            {
                res+= i+1 + "." + m_playerObserver.getPlayerHandCard(i) + "\n";
            }
        }
        System.out.println(res);
    }

    public void printAction()
    {
        System.out.println("Action possibles :\n\t[fin] Terminer votre tour\n" +
                "\t[piocher] Piocher une carte\n" +
                "\t[placer <numero carte> <position>] Placer une carte sur le plateau\n");
    }
}
