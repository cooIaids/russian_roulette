package TestClasses;

import GameModes.RevolverGameModeAI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.mockito.Mockito.*;

class GameStartTest {

    @org.junit.jupiter.api.Test
    void playersChoiceForGameMode() {
        String simulatedInput = "1 \n 1 \n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        RevolverGameModeAI revolverGameModeAI = mock(RevolverGameModeAI.class);
        verify(revolverGameModeAI, times(1)).startGame();





    }
}