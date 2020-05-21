package edu.iis.mto.multithread;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissileAndVolleySizeIs1() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        ControlSystem controlSystem = new TestControlSystem();
        BetterRadar radar = new BetterRadar(controlSystem, batteryMock, 1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @Test
    public void launchPatriotFourTimesWhenNoticesAScudMissileAndVolleySizeIs4() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        ControlSystem controlSystem = new TestControlSystem();
        int volleySize = 4;
        BetterRadar radar = new BetterRadar(controlSystem, batteryMock, volleySize);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(volleySize)).launchPatriot(enemyMissle);
    }
}
