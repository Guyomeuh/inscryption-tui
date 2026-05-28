package controller;

import models.gameplay.Game;
import view.GeneralView;

import java.util.Objects;

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
                                        m_view.show();
                                    }
                                    else
                                    {
                                        System.out.println("Allons, tu ne vas pas piocher PLUSIEURS FOIS quand même");
                                    }
                                }
                        case "placer" ->
                                {
                                    if (!pioche)
                                    {
                                        System.out.println("Vous devenez d'abord piocher non mais oh");
                                    }
                                    else
                                    {
                                        if (input.split(" ").length == 3 && (Integer.parseInt(input.split(" ")[1]) - 1) >= 0 && (Integer.parseInt(input.split(" ")[1]) - 1) <= 4 && (Integer.parseInt(input.split(" ")[2]) - 1) >= 0 && (Integer.parseInt(input.split(" ")[2]) - 1) < m_game.getHandSize())
                                        {
                                            if (m_game.availableBlood() >= m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1) && m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1) !=0)
                                            {
                                                int remainingSacrifice = m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1);
                                                boolean validSacrifice = false;
                                                while (remainingSacrifice != 0 || !validSacrifice)
                                                {
                                                    validSacrifice = false;
                                                    m_view.askForBlood(remainingSacrifice);
                                                    String sacrificeInput = m_view.promptUser();
                                                    if (Objects.equals(sacrificeInput.split(" ")[0], "sacrifier") && (Integer.parseInt(sacrificeInput.split(" ")[1]) - 1) >= 0 && (Integer.parseInt(sacrificeInput.split(" ")[1]) - 1) <= 4)
                                                    {
                                                        remainingSacrifice-=m_game.sacrifice(Integer.parseInt(sacrificeInput.split(" ")[1]) - 1);
                                                        validSacrifice = true;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Veuillez saisir une commande valide");
                                                    }
                                                }
                                                System.out.println("Où voulez vous poser la carte ?\n[placer] <numero de la case>");
                                                String sacrificePosition = m_view.promptUser();
                                                if (Objects.equals(sacrificePosition.split(" ")[0], "placer") && (Integer.parseInt(input.split(" ")[1]) - 1) >= 0 && (Integer.parseInt(input.split(" ")[1]) - 1) <= 4)
                                                {
                                                    valid = m_game.place(Integer.parseInt(sacrificePosition.split(" ")[1]) - 1, Integer.parseInt(input.split(" ")[2]) - 1) == 0;
                                                }
                                            }
                                            else if (m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1) == 0){
                                                valid = m_game.place(Integer.parseInt(input.split(" ")[1]) - 1, Integer.parseInt(input.split(" ")[2]) - 1) == 0;
                                            }

                                        }
                                        else
                                        {
                                            System.out.println("Position ou numero de carte incorrect");
                                        }
                                        m_view.show();
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
                }
                if (m_game.checkVictory() == 0)
                {
                    m_game.botTurn();
                }
            }
            if (m_game.checkVictory() >= 1)
            {
                m_view.show();
                System.out.println("Félication vous avez gagné !");
                m_game.nextCombat();
                startGame();
            }
            else if (m_game.checkVictory() <= -1)
            {
                m_view.show();
                System.out.println("Bouh le nul");
            }
        }
    }
}
