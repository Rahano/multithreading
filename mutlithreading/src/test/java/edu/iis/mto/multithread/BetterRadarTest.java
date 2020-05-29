package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private Scud enemyMissile;
    private PatriotBattery batteryMock;

    @BeforeEach public void prepare() {
        enemyMissile = new Scud();
        batteryMock = mock(PatriotBattery.class);
    }

    @RepeatedTest(1000) public void launchPatriotOnceWhenNoticesAScudMissile() {
        int missilesToLaunch = 5;
        BetterRadar radar = new BetterRadar(batteryMock, missilesToLaunch);
        radar.notice(enemyMissile);
        verify(batteryMock, times(missilesToLaunch)).launchPatriot(enemyMissile);
    }

}
