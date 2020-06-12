package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.IntStream;

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
    }

    @RepeatedTest(value = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        final int MISSILES_COUNT = 1;
        prepareDefenceMechanism(MISSILES_COUNT);
        betterRadar = new BetterRadar(batteryMock, MISSILES_COUNT, defenceMechanism);
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(MISSILES_COUNT)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(value = 10)
    public void launchPatriotTenTimesWhenNoticesAScudMissle() {
        final int MISSILES_COUNT = 10;
        prepareDefenceMechanism(MISSILES_COUNT);
        betterRadar = new BetterRadar(batteryMock, MISSILES_COUNT, defenceMechanism);
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(MISSILES_COUNT)).launchPatriot(enemyMissle);
    }

    private void prepareDefenceMechanism(final int missilesCount) {
        doAnswer(invocation -> {
            Thread thread = new Thread(() -> {
                IntStream.range(0, missilesCount)
                         .forEach(i -> batteryMock.launchPatriot(invocation.getArgument(2, Scud.class)));
            });
            thread.start();
            thread.join();
            return null;
        }).when(defenceMechanism)
          .defence(any(), anyInt(), any());
    }

}
