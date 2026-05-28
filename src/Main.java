import view.BotTextObserver;
import view.GameTextObserver;
import view.GeneralView;
import view.PlayerTextObserver;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Another challenger... It has been ages.");
        BotTextObserver bot = new BotTextObserver();
        PlayerTextObserver player = new PlayerTextObserver();
        GameTextObserver game = new GameTextObserver();
        GeneralView gen = new GeneralView(game, player, bot);
        gen.show();


    }
}
