package models.cards;

public class ObjectCard extends BaseCard {
    public ObjectCard(String name, int hp){
        super(name, hp);
    }

    @Override
    public boolean isSacrifiable() {
        return false;
    }
}
