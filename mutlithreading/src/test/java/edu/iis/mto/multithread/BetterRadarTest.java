package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BetterRadarTest {

    @Mock
    PatriotBattery patriotBatteryMock;

    @Mock
    TaskService taskService;

    @BeforeEach
    void init(){
        doAnswer(call -> {
            Runnable runnable = call.getArgument(0);
            runnable.run();
            return null;
        }).when(taskService).getTask(any());
    }

    @RepeatedTest(25)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        BetterRadar betterRadar = new BetterRadar(patriotBatteryMock, taskService, 1);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(patriotBatteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(25)
    public void launchPatriotFiveTimesWhenNoticesFiveScudMissle() {
        BetterRadar betterRadar = new BetterRadar(patriotBatteryMock, taskService, 5);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(patriotBatteryMock, times(5)).launchPatriot(enemyMissle);
    }

}
