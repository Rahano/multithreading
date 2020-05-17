package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class RadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        int numberOfMissles = 1;
        LaunchPatriotic launchPatriotic = new LaunchPatrioticTask(numberOfMissles);
        BetterRadar radar = new BetterRadar(batteryMock, launchPatriotic, numberOfMissles);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        ((LaunchPatrioticTask) launchPatriotic).waitForAllMissles();
        verify(batteryMock).launchPatriot(enemyMissle);
    }

}
