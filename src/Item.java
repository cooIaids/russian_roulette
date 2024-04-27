public class Item {

    enum TypeOfItem{
        HANDCUFFS, POCKET_KNIFE, BEER, MAGNIFYING_GLASS, CIGARETTES, ADRENALINE, FLIP_PHONE, EXPIRED_MEDICINE
    }

    private TypeOfItem type;

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
