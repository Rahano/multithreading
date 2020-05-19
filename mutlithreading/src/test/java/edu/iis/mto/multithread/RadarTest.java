package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    private DefenseSystem system;

    @BeforeEach
    void prepareDefenseSystemMock(){
        system = mock(DefenseSystem.class);
        doAnswer(invocationOnMock -> {((Runnable)invocationOnMock.getArgument(0)).run(); return null;})
                .when(system)
                .executeDefenseCommand(any(Runnable.class));
    }


    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, 1);
        radar.setDefenseSystem(system);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }

}
