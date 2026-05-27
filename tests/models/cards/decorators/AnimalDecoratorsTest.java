package models.cards.decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.cards.AnimalCard;

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
}
