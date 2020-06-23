package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RadarTest {

    BetterRadar betterRadar;
    Scud enemyMissle;

    @Mock
    PatriotBattery batteryMock;

    @Mock
    DefenceMechanism defenceMechanism;

    @BeforeEach
    public void setUp() {
        enemyMissle = new Scud();
        doAnswer(invocation -> {
            Runnable runnable = invocation.getArgument(0);
            runnable.run();
            return null;
        }).when(defenceMechanism)
          .defence(any());
    }

    @RepeatedTest(value = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        final int MISSILES_COUNT = 1;
        betterRadar = new BetterRadar(batteryMock, MISSILES_COUNT, defenceMechanism);
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(MISSILES_COUNT)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(value = 10)
    public void launchPatriotTenTimesWhenNoticesAScudMissle() {
        final int MISSILES_COUNT = 10;
        betterRadar = new BetterRadar(batteryMock, MISSILES_COUNT, defenceMechanism);
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(MISSILES_COUNT)).launchPatriot(enemyMissle);
    }

}
