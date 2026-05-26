package controller;

import models.gameplay.Game;
import view.GeneralView;

public class GameController {
    private Game m_game;
    private GeneralView m_view;

    public GameController(Game game, GeneralView view)
    {
        m_game = game;
        m_view = view;
    }

    public void startGame()  {
        if (m_view.gameStart())
        {
            while (m_game.checkVictory() == 0)
            {
                m_view.show();
                boolean valid = false;
                boolean endTurn = false;
                boolean pioche = false;
                int errorNb = 0;
                while (!valid || !endTurn)
                {
                    String input = m_view.promptUser();
                    System.out.println(input);
                    switch (input.split(" ")[0])
                    {
                        case "Test" -> valid = m_game.place(1,1);
                        case "fin" ->
                                {
                                    valid = m_game.endTurn();
                                    endTurn = true;
                                }
                        case "piocher" ->
                                {
                                    if (!pioche)
                                    {
                                        valid = m_game.draw();
                                        pioche = true;
                                    }
                                    else
                                    {
                                        System.out.println("Allons, tu ne vas pas piocher PLUSIEURS FOIS quand même");
                                    }
                                }
                        case "placer" ->
                                {
                                    if ((Integer.parseInt(input.split(" ")[1]) - 1) >= 0 && (Integer.parseInt(input.split(" ")[1]) - 1) <= 4 && (Integer.parseInt(input.split(" ")[2]) - 1) >= 0)
                                    {
                                        valid = m_game.place(Integer.parseInt(input.split(" ")[1]) - 1,Integer.parseInt(input.split(" ")[2]) - 1);
                                    }
                                    else
                                    {
                                        System.out.println("Position ou numero de carte incorrect");
                                    }
                                }
                        default -> {
                            System.out.println("Choisissez une action valide");
                            errorNb ++;
                            if (errorNb >= 5)
                            {
                                m_view.show();
                                errorNb = 0;
                            }
                        }
                    }
                    m_view.show();
                }
                m_game.endTurn();
            }
            if (m_game.checkVictory() >= 1)
            {
                System.out.println("Félication vous avez gagné !");
            }
            else
            {
                System.out.println("Bouh le nul");
            }
        }
    }
}
