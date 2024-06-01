package TestClasses;

import Guns.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class RevolverTest {

    /**
    * Tests the method addRounds()
    */

    @Test
    void addRounds() {
        Revolver revolver = new Revolver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 7; i++) {
            revolver.addRounds(new Bullet(true));
        }
        String output = outputStream.toString().trim();

        assertEquals(7, revolver.size());
        assertTrue(output.contains("Can't add more rounds"));
    }
}
