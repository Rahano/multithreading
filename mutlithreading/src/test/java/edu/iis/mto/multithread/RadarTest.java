package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {
    private Scud enemyMissle;
    private PatriotBattery batteryMock;
    private int numberOfMissles = 0;

    @BeforeEach
    public void setUp(){
        enemyMissle = new Scud();
        batteryMock = mock(PatriotBattery.class);
    }

    @RepeatedTest(value = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        numberOfMissles = 1;
        LaunchPatriotic launchPatriotic = new LaunchPatrioticTask(numberOfMissles);
        BetterRadar radar = new BetterRadar(batteryMock, launchPatriotic, numberOfMissles);
        radar.notice(enemyMissle);
        ((LaunchPatrioticTask) launchPatriotic).waitForAllMissles();
        verify(batteryMock).launchPatriot(enemyMissle);
    }
}
