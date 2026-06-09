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
        AliveCard copy = new AnimalCard(other.getName(), other.getHp(), other.getAttack(), other.getBloodCost(), other.getBoneCost());

        if (other instanceof ManyLivesAnimal) {
            copy = new ManyLivesAnimal(copy);
        } else if (other instanceof AirborneAnimal) {
            copy = new AirborneAnimal(copy);
        } else if (other instanceof FledglingAnimal) {
            copy = new FledglingAnimal(copy);
        } else if (other instanceof StinkyAnimal) {
            copy = new StinkyAnimal(copy);
        } else if (other instanceof SprinterAnimal) {
            copy = new SprinterAnimal(copy);
        } else if (other instanceof TouchOfDeathAnimal) {
            copy = new TouchOfDeathAnimal(copy);
        } else if (other instanceof SharpQuillsAnimal) {
            copy = new SharpQuillsAnimal(copy);
        }

        return copy;
    }

    public static AliveCard applyModifier(AliveCard other, String modif)
    {
        return switch (modif)
        {
            case "Nombreuses vies" -> new ManyLivesAnimal(other);
            case "Volant" -> new AirborneAnimal(other);
            case "Croissance" -> new FledglingAnimal(other);
            case "Puant" -> new StinkyAnimal(other);
            case "Coureur" -> new SprinterAnimal(other);
            case "Piques pointues" -> new SharpQuillsAnimal(other);
            case "Contact mortel" -> new TouchOfDeathAnimal(other);
            default -> other;
        };
    }
}
