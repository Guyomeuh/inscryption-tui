package view;

import model.observer.PlayerObserver;

import java.util.ArrayList;

public class PlayerTextObserver implements PlayerObserver {
    private Integer m_deckCardAmount;
    private String m_playerHand;
    private String m_playerBoard;
    private Boolean[] m_playerBoardState;

    public PlayerTextObserver()
    {
        m_deckCardAmount = 15;
        m_playerHand = "Votre main :\n"
                    +   "\t";
        m_playerBoard =
                "          *************   *************   *************   *************\n"
               +"          *           *   *           *   *           *   *           *\n"
               +"          *           *   *           *   *           *   *           *\n"
               +"          *     B1    *   *     B2    *   *    B3     *   *     B4    *\n"
               +"          *           *   *           *   *           *   *           *\n"
               +"          *           *   *           *   *           *   *           *\n"
               +"          *************   *************   *************   *************\n";
        m_playerBoardState = new Boolean[4];
    }
    @Override
    public void updatePlayerDeck(Integer cardAmount) {
        m_deckCardAmount = cardAmount;
    }

    @Override
    public void updatePlayerHand(String hand) {

    }

    @Override
    public void updatePlayerBoard(PlayerBoard board) {

    }

    public String getDeck()
    {
        return "";
    }

    public String getBoardCardName(Integer index)
    {
        return "Loup";
    }

    public String getBoardCardHp(Integer index)
    {
        return "Loup";
    }

    public String getBoardCardAtt(Integer index)
    {
        return "Loup";
    }

    public String getBoardCardModif(Integer index)
    {
        return "Loup";
    }
}
