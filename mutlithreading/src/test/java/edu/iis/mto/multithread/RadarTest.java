package edu.iis.mto.multithread;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {

    private PatriotBattery batteryMock;
    private Scud enemyMissile;

    @BeforeEach
    public void init()
    {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(10)
    public void launchPatriotZeroTimesWhenNoticesAScudMissile() {
        LaunchPatriotTask launchTask = new LaunchPatriotTask(batteryMock, 0);
        BetterRadar radar = new BetterRadar(launchTask);
        radar.notice(enemyMissile);
        try {
            launchTask.join();
        } catch (InterruptedException e){
            fail("Interrupted");
        };
        verify(batteryMock, times(0)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        LaunchPatriotTask launchTask = new LaunchPatriotTask(batteryMock, 1);
        BetterRadar radar = new BetterRadar(launchTask);
        radar.notice(enemyMissile);
        try {
            launchTask.join();
        } catch (InterruptedException e){
            fail("Interrupted");
        };
        verify(batteryMock).launchPatriot(enemyMissile);
    }

}
