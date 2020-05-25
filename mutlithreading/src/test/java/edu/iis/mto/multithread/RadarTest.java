package edu.iis.mto.multithread;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {

    private PatriotBattery batteryMock;
    private Scud enemyMissile;
    private LaunchPatriotTask launchTask;
    private BetterRadar radar;

    @BeforeEach
    public void init()
    {
        batteryMock = mock(PatriotBattery.class);
        launchTask = new LaunchPatriotTask(batteryMock);
        radar = new BetterRadar(launchTask);
        enemyMissile = new Scud();
    }

    @RepeatedTest(10)
    public void launchPatriotZeroTimesWhenNoticesAScudMissile() {
        int nLaunches = 0;
        launchTask.setNumberOfLaunches(nLaunches);
        radar.notice(enemyMissile);
        try {
            launchTask.join();
        } catch (InterruptedException e){
            fail("Interrupted");
        };
        verify(batteryMock, times(nLaunches)).launchPatriot(enemyMissile);
    }

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
}
