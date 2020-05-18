package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

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
        this.enemyMissile = mock(Scud.class);

        this.numberOfMissiles = 5;
        this.betterRadar = new BetterRadar(this.batteryMock, this.batterySystemMock, this.numberOfMissiles);
    }

    @RepeatedTest(7)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        this.betterRadar.notice(this.enemyMissile);
        verify(this.batterySystemMock).launchPatriot(this.batteryMock, this.enemyMissile, this.numberOfMissiles);
    }

}
