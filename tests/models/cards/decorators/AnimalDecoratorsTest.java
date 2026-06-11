package models.cards.decorators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.cards.Card;
import models.cards.ObjectCardFactory;
import models.gameplay.Player;
import models.gameplay.Board;
import view.PlayerTextObserver;

public class AnimalDecoratorsTest {
    @Test
    public void TouchOfDeath(){
        AliveCard viper = AliveCardFactory.Vipere();
        AliveCard grizzly = AliveCardFactory.Grizzly();
        AliveCard porcupine = AliveCardFactory.PorcEpic();
        Card rock = ObjectCardFactory.Rocher();

        assertEquals("Contact mortel", viper.getModif());

        viper.attack(grizzly);
        assertEquals(0, grizzly.getHp());

        viper.attack(rock);
        assertEquals(4, rock.getHp());

        viper.attack(porcupine);
        assertEquals(0, porcupine.getHp());
        assertEquals(0, viper.getHp());
    }

    @Test 
    public void Stinky(){
        AliveCard bedbug = AliveCardFactory.Punaise();

        assertEquals("Puant", bedbug.getModif());
        bedbug.getDamaged(2);
        assertEquals(1, bedbug.getHp());
        bedbug.getDamaged(0);
        assertEquals(1, bedbug.getHp());
    }

    @Test
    public void SharpQuills(){
        AliveCard porcupine = AliveCardFactory.PorcEpic();
        AliveCard grizzly = AliveCardFactory.Grizzly();

        assertEquals("Piques pointues", porcupine.getModif());
        grizzly.attack(porcupine);
        assertEquals(0, porcupine.getHp());
        assertEquals(5, grizzly.getHp());
    }

    @Test
    public void ManyLives(){
        AliveCard cat = AliveCardFactory.Chat();
        assertEquals("Nombreuses vies", cat.getModif());

        Board pb = new Board();

        pb.set(0, cat);
        assertEquals(1, pb.sacrifice(0));
        assertTrue(pb.isOccupied(0));
    }

    @Test 
    public void Airborne(){
        AliveCard raven = AliveCardFactory.Corbeau();
        AliveCard cat = AliveCardFactory.Chat();
        assertEquals("Volant", raven.getModif());


        Board pb = new Board();
        pb.set(0, raven);
        pb.set(2, cat);

        assertTrue(pb.isAirborne(0));
        assertTrue(!pb.isAirborne(1));
        assertTrue(!pb.isAirborne(2));
    }

    @Test
    public void Sprinter(){
        AliveCard elk = AliveCardFactory.Elan();

        assertEquals("Coureur", elk.getModif());

        Board pb = new Board();
        AliveCard cat = AliveCardFactory.Chat();

        pb.set(0, elk);
        pb.set(1, cat);

        assertTrue(pb.isSprinter(0));
        assertTrue(!pb.isSprinter(1));
        assertTrue(!pb.isSprinter(2));
    }

    @Test
    public void Fledgling(){
        AliveCard wolfCub = AliveCardFactory.Louveteau();

        assertEquals("Croissance", wolfCub.getModif());

        Board pb = new Board();
        pb.set(0, wolfCub);
        Player p = new Player(new ArrayList<>(), new Board(), new PlayerTextObserver());
        p.setNewBoard(pb);
        p.endTurn();

        assertEquals("", pb.getModif(0));
        assertEquals("Loup", pb.getName(0));
    }
}
