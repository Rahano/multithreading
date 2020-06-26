package edu.iis.mto.multithread;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Base64;

public class RadarTest {

    private PatriotBattery batteryMock;
    private RocketLauncher launcherMock;
    private Scud enemyMissile;

    @BeforeEach
    public void init()
    {
        enemyMissile = new Scud();
        batteryMock = mock(PatriotBattery.class);
        launcherMock = mock(RocketLauncher.class);
        doAnswer(i -> {
            batteryMock.launchPatriot(enemyMissile);
            return null;
        }).when(launcherMock).launch(enemyMissile);
    }

    @RepeatedTest(10)
    public void launchPatriotZeroTimesWhenNoticesAScudMissile() {
        int nLaunches = 0;
        BetterRadar radar = new BetterRadar(launcherMock, nLaunches);
        radar.notice(enemyMissile);
        verify(batteryMock, times(nLaunches)).launchPatriot(enemyMissile);
    }
/*
    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        launchTask.setNumberOfLaunches(1);
        radar.notice(enemyMissile);
        try {
            launchTask.join();
        } catch (InterruptedException e){
            fail("Interrupted");
        };
        verify(batteryMock).launchPatriot(enemyMissile);
    }

    @RepeatedTest(10)
    public void launchPatriotSixTimesWhenNoticesAScudMissile() {
        int nLaunches = 6;
        launchTask.setNumberOfLaunches(nLaunches);
        radar.notice(enemyMissile);
        try {
            launchTask.join();
        } catch (InterruptedException e){
            fail("Interrupted");
        };
        verify(batteryMock, times(nLaunches)).launchPatriot(enemyMissile);
    }
*/}
