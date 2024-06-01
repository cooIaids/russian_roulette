package TestClasses;

import EntitiesAndItems.*;
import Guns.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**
     * Tests the method useAnItem()
     */

    @Test
    void useAnItem() {
        Gun g = new Gun();
        Player p = new Player();
        p.addItem(new Item(Item.TypeOfItem.POCKET_KNIFE));

        int initialDamage = 5;
        g.setDamage(initialDamage);
        p.useAnItem(0,g);
        assertEquals(5 * 2, g.getDamage());
    }
}