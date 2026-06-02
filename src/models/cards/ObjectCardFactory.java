package models.cards;

public class ObjectCardFactory {
    public static Card Rocher(){
        return new ObjectCard("Rocher", 5);
    } 

    public static Card Sapin(){
        return new ObjectCard("Sapin", 3);
    }
}
