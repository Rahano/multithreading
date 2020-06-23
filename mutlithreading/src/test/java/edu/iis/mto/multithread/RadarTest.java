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

        doAnswer(i -> {
            ((Runnable) i.getArgument(0)).run();
            return null;
        }).when(targetMechanismMock).launchPatriot(any(Runnable.class));
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, targetMechanismMock, 1);
        betterRadar.notice(enemyMissile);
        verify(batteryMock, times(1)).launchPatriot(enemyMissile);
    }

}
