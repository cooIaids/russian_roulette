import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PullTriggerCommandTest {

    @Test
    void execute() {
        GameMode gm = new GameMode();
        Gun g = new Gun();
        PullTriggerCommand ptc = new PullTriggerCommand(g);
        gm.setCommand(ptc);
        g.addRounds(new Bullet(true));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = gm.executeCommand();

        String output = outputStream.toString().trim();
        assertEquals("The round is... LIVE", output);
        assertTrue(result);
    }
}