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
}
