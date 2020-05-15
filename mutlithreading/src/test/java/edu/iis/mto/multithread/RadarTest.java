package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        int amount = 1;

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock, amount);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, timeout(100).times(amount)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissleWithBetterRadarClass() {
        int amount = 1;

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, amount);
        Scud enemyMissle = mock(Scud.class);
        radar.notice(enemyMissle);
        verify(batteryMock, times(amount)).launchPatriot(enemyMissle);
    }

}
