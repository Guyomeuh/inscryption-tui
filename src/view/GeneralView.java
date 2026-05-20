package view;

import java.sql.SQLOutput;

public class GeneralView {

    private GameTextObserver m_gameObserver;
    private PlayerTextObserver m_playerObserver;
    private BotTextObserver m_botObserver;

    public GeneralView(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    {
    }

    //public void show(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    /*{
        System.out.println("Partie : " + game.getGameNumber() + "\n\n"

                + game.getTurn() + " Tour\n\n" +
                + bot.getWaitingBoard() + "\n"
                + "\t\t| |\t\t\n"
                + "\t\t\\/ \t\t\n" +
                + bot.getBoard() + "\n"
                + game.getBalance() + "\n"
                + player.getBoard + "Pioche\n"
                + "Votre main :\n" +
                + player.getHand + "\t" + player.getDeck() + "\n"
                + "Actions possibles:\n" +
                "[fin] Terminer votre tour\n" +
                "[piocher] Piocher une carte\n" +
                "[placer <numero carte> <position>] Placer une carte sur le plateau\n");
    }*/

    public void printGameInfo()
    {
        System.out.println("Partie : " + m_gameObserver.getGameNumber() + "\n" + m_gameObserver.getTurn() + " Tour:\n\n");
    }

    public static void printBotWaitingBoard()
    {
        String endString = "\t\t";

        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "|" + m_playerObserver.getBoardCardName(i) + "|" : "*           *\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*-----------*\t" : "*************\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*PV: " + m_playerObserver.getBoardCardHp(i) +"------*\t" : "*           *\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*Att: " + m_playerObserver.getBoardCardAtt(i) +"-----*\t" : "*           *\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*Att: " + m_playerObserver.getBoardCardModif(i) +"--*\t" : "*           *\t";
        }
        endString+="\n";
        for (Integer i = 0; i < 4; i++)
        {
            endString += (m_botObserver.getBordStatus(i)) ? "*-----------*\t" : "*************\t";
        }
    }
}
