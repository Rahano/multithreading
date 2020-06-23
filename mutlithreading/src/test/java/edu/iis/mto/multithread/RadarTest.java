package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    private PatriotBattery batteryMock;
    private BatterySystem batterySystemMock;
    private Scud enemyMissile;
    private int numberOfMissiles;

    private BetterRadar betterRadar;

    @BeforeEach
    public void setUp() {
        this.batteryMock = mock(PatriotBattery.class);
        this.batterySystemMock = mock(BatterySystem.class);
        this.enemyMissile = new Scud();

        this.numberOfMissiles = 5;
        this.betterRadar = new BetterRadar(this.batteryMock, this.batterySystemMock, this.numberOfMissiles);

        doAnswer(element -> {
            ((Runnable) element.getArgument(0)).run();
            return null;
        }).when(batterySystemMock).launch(any(Runnable.class));
    }

    @RepeatedTest(7)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        this.betterRadar.notice(this.enemyMissile);
        verify(this.batteryMock, times(this.numberOfMissiles)).launchPatriot(this.enemyMissile);
    }

}
