package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @RepeatedTest(value = 3, name = "One rocket volley test")
    public void launchPatriotOnceWhenNoticesAScudMissileAndVolleySizeIs1() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        AimingInstruments aimingInstruments = new TestAimingInstruments();
        BetterRadar radar = new BetterRadar(aimingInstruments, batteryMock, 1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(value = 3, name = "Four rockets volley test")
    public void launchPatriotFourTimesWhenNoticesAScudMissileAndVolleySizeIs4() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        AimingInstruments aimingInstruments = new TestAimingInstruments();
        int volleySize = 4;
        BetterRadar radar = new BetterRadar(aimingInstruments, batteryMock, volleySize);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(volleySize)).launchPatriot(enemyMissle);
    }
}
