package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {
    
    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        int missilesToLaunch = 5;
        BetterRadar radar = new BetterRadar(batteryMock, missilesToLaunch);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, times(missilesToLaunch)).launchPatriot(enemyMissile);
    }

}
