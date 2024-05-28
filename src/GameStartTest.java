import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class GameStartTest {

    @org.junit.jupiter.api.Test
    void playersChoiceForGameMode() {
        Player p = new Player();
        Scanner sc = new Scanner(System.in);

        String simulatedInput = "1 \n 1 \n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        RevolverGameModeAI revolverGameModeAI = mock(RevolverGameModeAI.class);
        RevolverGameModePlayer revolverGameModePlayer = mock(RevolverGameModePlayer.class);
        ShotgunGameModePlayer shotgunGameModePlayer = mock(ShotgunGameModePlayer.class);
        ShotgunGameModeAI shotgunGameModeAI = mock(ShotgunGameModeAI.class);
    }
}