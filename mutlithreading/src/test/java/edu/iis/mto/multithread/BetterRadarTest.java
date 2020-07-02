package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private Scud enemyMissile;
    private PatriotBattery batteryMock;
    private LaunchHandler launcher;

    @BeforeEach public void prepare() {
        enemyMissile = new Scud();
        batteryMock = mock(PatriotBattery.class);
        launcher = new TestLauncher();
    }

    @RepeatedTest(1000) public void LaunchSetNumberOfMissilesWhenNoticesAScudMissile() {
        int missilesToLaunch = 5;
        BetterRadar radar = new BetterRadar(batteryMock, missilesToLaunch, launcher);

        radar.notice(enemyMissile);

        verify(batteryMock, times(missilesToLaunch)).launchPatriot(enemyMissile);
    }

}
