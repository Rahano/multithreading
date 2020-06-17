package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class RadarTest {

    private PatriotBattery batteryMock;
    private DefenseSystem defenseSystem;
    private Scud enemyMissile;

    @BeforeEach
    public void initialize() {
        batteryMock = mock(PatriotBattery.class);
        defenseSystem = mock(DefenseSystem.class);
        enemyMissile = mock(Scud.class);
    }

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(10)
    public void launchOnePatriotOnceWhenNoticesAScudMissileWithBetterRadarClass() {
        int amount = 1;

        doAnswer(temp -> {
            IntStream.range(0, amount).forEach(i -> batteryMock.launchPatriot(temp.getArgument(0)));
            return 0;
        }).when(defenseSystem).activateBatteries(any(Scud.class), anyInt());

        BetterRadar radar = new BetterRadar(batteryMock, defenseSystem, amount);
        radar.notice(enemyMissile);
        verify(batteryMock, times(amount)).launchPatriot(enemyMissile);
    }
}
