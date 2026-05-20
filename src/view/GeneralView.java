package view;

import java.sql.SQLOutput;

public class GeneralView {

    private GameTextObserver m_gameObserver;
    private PlayerTextObserver m_playerObserver;
    private BotTextObserver m_botObserver;

    public GeneralView(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    {
    }

    public void show(GameTextObserver game, PlayerTextObserver player, BotTextObserver bot)
    {
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
    }

}
