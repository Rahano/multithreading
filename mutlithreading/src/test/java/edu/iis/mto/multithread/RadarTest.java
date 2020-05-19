package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
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
    @Test

    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, 1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

}
