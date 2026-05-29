package models.cards.decorators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.cards.AnimalCard;
import models.gameplay.PlayerBoard;

public class AnimalDecoratorsTest {
    @Test
    public void TouchOfDeath(){
        AnimalCard viper = AnimalCard.Vipere();

        assertEquals("Contact mortel", viper.getModif());
        assertEquals(Integer.MAX_VALUE, viper.getAttack());
    }

    @Test 
    public void Stinky(){
        AnimalCard bedbug = AnimalCard.Punaise();

        assertEquals("Puant", bedbug.getModif());
        bedbug.getDamaged(2);
        assertEquals(1, bedbug.getHp());
    }

    @Test
    public void SharpQuills(){
        AnimalCard porcupine = AnimalCard.PorcEpic();
        AnimalCard grizzly = AnimalCard.Grizzly();
        

        assertEquals("Piques pointues", porcupine.getModif());
        grizzly.attack(porcupine);
        assertEquals(5, grizzly.getHp());
    }

    @Test
    public void ManyLives(){
        AnimalCard cat = AnimalCard.Chat();
        assertEquals("Nombreuses vies", cat.getModif());

        PlayerBoard pb = new PlayerBoard();

        pb.set(0, cat);
        assertEquals(1, pb.sacrifice(0));
        assertTrue(pb.isOccupied(0));
    }

    @Test 
    public void Airborne(){
        AnimalCard raven = AnimalCard.Corbeau();
        AnimalCard cat = AnimalCard.Chat();
        assertEquals("Volant", raven.getModif());


        PlayerBoard pb = new PlayerBoard();
        pb.set(0, raven);
        pb.set(2, cat);

        assertTrue(pb.isAirborne(0));
        assertTrue(!pb.isAirborne(1));
        assertTrue(!pb.isAirborne(2));
    }

    @Test
    public void Sprinter(){
        AnimalCard elk = AnimalCard.Elan();

        assertEquals("Coureur", elk.getModif());

        PlayerBoard pb = new PlayerBoard();
        AnimalCard cat = AnimalCard.Chat();

        pb.set(0, elk);
        pb.set(1, cat);

        assertTrue(pb.isSprinter(0));
        assertTrue(!pb.isSprinter(1));
        assertTrue(!pb.isSprinter(2));
    }
}
