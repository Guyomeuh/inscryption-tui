package models.cards.decorators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.cards.AnimalCard;
import models.gameplay.PlayerBoard;

public class AnimalDecoratorsTest {
    @Test
    public void TouchOfDeath(){
        TouchOfDeathAnimal viper = new TouchOfDeathAnimal(new AnimalCard("Viper", 1, 1, 2, 0));

        assertEquals("Contact mortel", viper.getModif());
        assertEquals(Integer.MAX_VALUE, viper.getAttack());
    }

    @Test 
    public void Stinky(){
        StinkyAnimal bedbug = new StinkyAnimal(new AnimalCard("Bedbug", 2, 1, 0, 2));

        assertEquals("Puant", bedbug.getModif());
        bedbug.getDamaged(2);
        assertEquals(1, bedbug.getHp());
    }

    @Test
    public void SharpQuills(){
        SharpQuillsAnimal porcupine = new SharpQuillsAnimal(new AnimalCard("Porcupine", 2, 1, 1, 0));
        AnimalCard grizzly = new AnimalCard("grizzly", 6, 4, 3, 0);

        assertEquals("Piques pointues", porcupine.getModif());
        grizzly.attack(porcupine);
        assertEquals(5, grizzly.getHp());
    }

    @Test
    public void ManyLives(){
        ManyLivesAnimal cat = new ManyLivesAnimal(new AnimalCard("cat", 1, 0, 1, 0));
        assertEquals("Nombreuses vies", cat.getModif());

        PlayerBoard pb = new PlayerBoard();

        pb.set(0, cat);
        assertEquals(1, pb.sacrifice(0));
        assertTrue(pb.isOccupied(0));
    }
}
