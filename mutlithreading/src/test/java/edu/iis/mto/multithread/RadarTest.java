package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    PatriotBattery batteryMock;
    TargetMechanism targetMechanismMock;
    Scud enemyMissile;

    @BeforeEach
    void setUp() {
        batteryMock = mock(PatriotBattery.class);
        targetMechanismMock = mock(TargetMechanism.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, targetMechanismMock, 1);
        betterRadar.notice(enemyMissile);
        verify(targetMechanismMock).launchPatriot(enemyMissile, 1);
    }

}
