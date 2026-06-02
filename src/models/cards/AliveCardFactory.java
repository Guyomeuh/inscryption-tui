package models.cards;

import models.cards.decorators.*;

public class AliveCardFactory {
    public static AliveCard Chat()
    {
        return new ManyLivesAnimal(new AnimalCard("Chat",1,1,0,0));
    }

    public static AliveCard Grizzly()
    {
        return new AnimalCard("Grizzly", 6, 4, 3, 0);
    }

    public static AliveCard Coyote()
    {
        return new AnimalCard("Coyote", 1, 2, 0, 4);
    }

    public static AliveCard Moineau()
    {
        return new AirborneAnimal(new AnimalCard("Moineau", 2,1,0,0));
    }

    public static AliveCard Corbeau()
    {
        return new AirborneAnimal(new AnimalCard("Corbeau", 3, 2, 2, 0));
    }

    public static AliveCard Ecureuil()
    {
        return new AnimalCard("Ecureuil", 1,0,0,0);
    }

    public static AliveCard Hermine()
    {
        return new AnimalCard("Hermine", 3, 1, 1, 0);
    }

    public static AliveCard Louveteau()
    {
        return new FledglingAnimal(new AnimalCard("Louveteau", 1,1,1,0));
    }

    public static AliveCard Loup()
    {
        return new AnimalCard("Loup",2,3,2,0);
    }

    public static AliveCard Punaise()
    {
        return new StinkyAnimal(new AnimalCard("Punaise", 2,1,0,2));
    }

    public static AliveCard Elan()
    {
        return new SprinterAnimal(new AnimalCard("Elan", 4,2,2,0));
    }

    public static AliveCard Vipere()
    {
        return new TouchOfDeathAnimal(new AnimalCard("Vipère",1, 1,2,0));
    }

    public static AliveCard PorcEpic()
    {
        return new SharpQuillsAnimal(new AnimalCard("Porc-épic", 2,1,1,0));
    }

    public static AliveCard Copy(AliveCard other)
    {
        return new AnimalCard(other.getName(), other.getHp(), other.getAttack(), other.getBloodCost(), other.getBoneCost());
    }

    public static AliveCard applyModifier(AliveCard other, String modif)
    {
        switch (modif)
        {
            default -> {
                return other;
            }
        }
    }
}
