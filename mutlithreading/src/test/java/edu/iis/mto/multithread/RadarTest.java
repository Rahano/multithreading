package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RadarTest {

    private DefenseSystem system;
    private PatriotBattery batteryMock;
    private Scud enemyMissile;

    @BeforeEach
    void prepareNeededMocksAndData() {
        system = mock(DefenseSystem.class);
        doAnswer(invocationOnMock -> {
            ((Runnable) invocationOnMock.getArgument(0)).run();
            return null;
        }).when(system)
          .executeDefenseCommand(any(Runnable.class));

        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(batteryMock, 1);
        radar.setDefenseSystem(system);
        radar.notice(enemyMissile);
        verify(batteryMock, times(1)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(10)
    public void doNotLaunchPatriotWhenNoticesAScudMissileIfThereIsTheLackOfPatriotMissiles() {
        BetterRadar radar = new BetterRadar(batteryMock, 0);
        radar.setDefenseSystem(system);
        radar.notice(enemyMissile);
        verify(batteryMock, times(0)).launchPatriot(enemyMissile);
    }

    @Test
    public void applyingNullDefenseSystemShouldCauseNPE(){
        BetterRadar radar = new BetterRadar(batteryMock, 1);
        radar.setDefenseSystem(null);
        assertThrows(NullPointerException.class, ()-> radar.notice(enemyMissile));
    }


}
