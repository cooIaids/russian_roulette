package TestClasses;

import GameModes.RevolverGameModePlayer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RevolverGameModePlayerTest {

    /**
     * Tests the method startGame()
     */

    @Test
    void startGame() {
        Scanner sc = new Scanner(System.in);
        String simulatedInput = "3\nname1\nname2\nname3\nno\nyou\nno\nyou\nno\nyou\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        RevolverGameModePlayer revolverGameModePlayer = new RevolverGameModePlayer();
        revolverGameModePlayer.startGame();

        String output = outputStream.toString();
        assertTrue(output.contains("CONGRATULATIONS"), "The game should have a winner");
        assertTrue(output.contains("name1") || output.contains("name2") || output.contains("nam3"),
                "One of the players won");
    }
}