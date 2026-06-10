package controller;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.gameplay.Game;
import view.GeneralView;

public class GameController {
    private final Game m_game;
    private final GeneralView m_view;

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
                boolean pioche = m_game.getDeckSize() == 0;
                int errorNb = 0;
                while (!valid || !endTurn) {
                    String input = m_view.promptUser();
                    // System.out.println(input); // debug
                    if (input.matches("^fin|piocher|placer\\s[1-4]\\s[1-9][0-9]*$")) {
                        switch (input.split(" ")[0]) {
                            case "fin" -> {
                                if (!pioche)
                                {
                                    System.out.println("Vous devez d'abord commencer par piocher.");
                                } else {
                                    valid = m_game.endTurn();
                                    endTurn = true;
                                }
                            }
                            case "piocher" -> {
                                if (!pioche) {
                                    valid = m_game.draw();
                                    pioche = true;
                                    m_view.show();
                                } else {
                                    if (m_game.getDeckSize() == 0) {
                                        System.out.println("Tu es à court de cartes.");
                                    } else {
                                        System.out.println("Tu ne vas tout de même pas essayer de piocher plus cartes.");
                                    }
                                }
                            }
                            case "placer" -> {
                                if (!pioche) {
                                    System.out.println("Vous devez d'abord commencer par piocher.");
                                } else {
                                    try {
                                        valid = placer(valid, input);
                                    }
                                    catch (IllegalArgumentException e){
                                        System.out.println("Numéro de carte invalide");
                                        valid = false;
                                    }
                                }
                            }

                            default -> {
                                System.out.println("Saisissez une action valide.");
                                errorNb++;
                                if (errorNb >= 5) {
                                    m_view.show();
                                    errorNb = 0;
                                }
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
                // If it's the second game
                if (this.m_game.getGameNumber() == 2){
                    this.m_game.addNewCard(getNewCard());
                    handleDeckSacrifice();
                }
                m_game.nextCombat();
                startGame();
            }
            else if (m_game.checkVictory() <= -1)
            {
                m_view.show();
                System.out.println("Vous rejoignez mes précédents adversaires..");
            }
        }
    }

    public boolean verifBlood(String input)
    {
        return m_game.availableBlood() >= m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1);
    }

    public boolean verifBone(String input)
    {
        return (m_game.getBoneCost(Integer.parseInt(input.split(" ")[2]) - 1) <= m_game.getPlayerBone());
    }

    public boolean costBlood(String input)
    {
        return m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1) != 0;
    }

    public boolean costBone(String input)
    {
        return m_game.getBoneCost(Integer.parseInt(input.split(" ")[2]) - 1) != 0;
    }

    public int getBloodCost(String input)
    {
        return m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1);
    }

    public int getBoneCost(String input)
    {
        return m_game.getBoneCost(Integer.parseInt(input.split(" ")[2]) - 1);
    }

    public boolean placer(boolean valid, String input)
    {
        int error = 0;
        if (!costBlood(input) && !costBone(input)) {
            valid = m_game.place(Integer.parseInt(input.split(" ")[1]) - 1, Integer.parseInt(input.split(" ")[2]) - 1);
            if (!valid) {
                System.out.println("Emplacement déjà occupé");
                error++;
            } else {
                error = 0;
            }
        }

        else if ((!verifBlood(input) && getBloodCost(input) != 0) || (!verifBone(input) && getBoneCost(input) != 0)) {
            System.out.println("Tu manquerais pas de ressources par hasard ?");
            error++;
        }

        else if (verifBlood(input) && getBoneCost(input) == 0) {
            int remainingSacrifice = m_game.getBloodCost(Integer.parseInt(input.split(" ")[2]) - 1);
            boolean validSacrifice = false;
            while (remainingSacrifice != 0 || !validSacrifice)
            {
                validSacrifice = false;
                m_view.askForBlood(remainingSacrifice);
                String sacrificeInput = m_view.promptUser();

                if (sacrificeInput.matches("^sacrifier\\s[1-4]$"))
                {
                    remainingSacrifice-=m_game.sacrifice(Integer.parseInt(sacrificeInput.split(" ")[1]) - 1);
                    validSacrifice = true;
                }

                else
                {
                    System.out.println("Veuillez saisir une commande valide");
                }
            }
            boolean positionValid = false;
            while(!positionValid) {
                System.out.println("Où voulez vous poser la carte ?\n[placer] <numero de la case>");
                String sacrificePosition = m_view.promptUser();

                if (sacrificePosition.matches("^placer\\s[1-4]$")) {
                    valid = m_game.place(Integer.parseInt(sacrificePosition.split(" ")[1]) - 1, Integer.parseInt(input.split(" ")[2]) - 1);

                    if (!valid) {
                        System.out.println("Emplacement déjà occupé");
                        error++;
                    }

                    else {
                        positionValid = true;
                    }
                }
            }
            error = 0;
        } else if (verifBone(input) && getBloodCost(input) == 0 ) {
                valid = m_game.place(Integer.parseInt(input.split(" ")[1]) - 1, Integer.parseInt(input.split(" ")[2]) - 1);
                if (!valid) {
                    System.out.println("Emplacement déjà occupé");
                    error++;
                } else {
                    error = 0;
                }
            }
        if (error == 0) {
            m_view.show();
        }
        return valid;
    }

    private void handleDeckSacrifice()
    {
        while (true)
        {
            m_view.askSacrificeFromDeck();
            String input = m_view.promptUser().trim().toLowerCase();
            if (input.equals("oui"))
            {
                performDeckSacrifice();
                return;
            }
            else if (input.equals("non"))
            {
                return;
            }
            else
            {
                System.out.println("Veuillez répondre par oui ou non.");
            }
        }
    }

    private void performDeckSacrifice()
    {
        if (m_game.getDeckSize() == 0)
        {
            System.out.println("Aucune carte dans le deck à sacrifier.");
            return;
        }

        boolean validSelection = false;
        while (!validSelection)
        {
            m_view.showDeckCards(m_game.getDeckCardDescriptions());
            m_view.askDeckSacrificeChoice();
            String input = m_view.promptUser();
            if (input.matches("^sacrifier\\s[1-9][0-9]*$"))
            {
                int choice = Integer.parseInt(input.split(" ")[1]) - 1;
                if (choice < 0 || choice >= m_game.getDeckSize())
                {
                    System.out.println("Choix invalide.");
                    continue;
                }

                AliveCard sacrificed = m_game.removeDeckCard(choice);
                validSelection = true;
                java.util.ArrayList<String> modifiers = AliveCardFactory.getModifiers(sacrificed);

                if (!modifiers.isEmpty() && m_game.getDeckSize() > 0)
                {
                    while (true)
                    {
                        m_view.askTransferModifiers(String.join(", ", modifiers));
                        String transferInput = m_view.promptUser().trim().toLowerCase();
                        if (transferInput.equals("oui"))
                        {
                            m_view.showDeckCards(m_game.getDeckCardDescriptions());
                            m_view.askTransferTarget();
                            String targetInput = m_view.promptUser();
                            if (targetInput.matches("^transfert\\s[1-9][0-9]*$"))
                            {
                                int targetChoice = Integer.parseInt(targetInput.split(" ")[1]) - 1;
                                if (targetChoice < 0 || targetChoice >= m_game.getDeckSize())
                                {
                                    System.out.println("Choix de cible invalide.");
                                    continue;
                                }

                                String targetName = m_game.getDeckCardName(targetChoice);
                                m_game.registerAnimalModifiers(targetName, modifiers);
                                System.out.println("Les modifs ont été transférées à toutes les cartes " + targetName + ".");
                                break;
                            }
                            else
                            {
                                System.out.println("Veuillez utiliser la commande 'transfert <numero>'.");
                            }
                        }
                        else if (transferInput.equals("non"))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Veuillez répondre par oui ou non.");
                        }
                    }
                }
            }
            else
            {
                System.out.println("Veuillez saisir une commande valide.");
            }
        }
    }

    public String getNewCard(){
        String[] newCards = {"Elan", "Vipère", "Porc-épic"};
        int indexCard = -1;

        do {
            this.m_view.askNewCard();
            String input = this.m_view.promptUser();

            if (input.matches("^[1-4]$"))
            {
                indexCard = Integer.parseInt(input);
            }
        } while (indexCard < 1 || indexCard >= 4);

        return newCards[indexCard - 1];
    }
}
