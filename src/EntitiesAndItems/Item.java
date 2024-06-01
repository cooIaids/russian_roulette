package EntitiesAndItems;

public class Item {

    public enum TypeOfItem{
         POCKET_KNIFE, BEER, MAGNIFYING_GLASS, CIGARETTES, FLIP_PHONE, EXPIRED_MEDICINE
    }

    private final TypeOfItem type;

    public Item(TypeOfItem type) {
        this.type = type;
    }

    public TypeOfItem getType() {
        return type;
    }


    @Override
    public String toString() {
        return "" + type;
    }
}
