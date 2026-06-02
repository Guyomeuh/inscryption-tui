import controller.GameController;
import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.gameplay.*;
import view.BotTextObserver;
import view.GameTextObserver;
import view.GeneralView;
import view.PlayerTextObserver;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Another challenger... It has been ages.");

        BotTextObserver botObs = new BotTextObserver();
        PlayerTextObserver playerObs = new PlayerTextObserver();
        GameTextObserver gameObs = new GameTextObserver();
        GeneralView gen = new GeneralView(gameObs, playerObs, botObs);

        PlayerBoard board = new PlayerBoard();
        ArrayList<AliveCard> deck = new ArrayList<AliveCard>();
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Chat());
        Player user = new Player(deck, board, playerObs);
        Game game = new Game(user, gameObs, botObs);
        GameController gameControl = new GameController(game, gen);
        gameControl.startGame();

    }
}
