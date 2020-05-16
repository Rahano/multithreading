package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.IntStream;

public class RadarTest {
	
	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		int rocketsToLaunch = 1;
		PatriotBattery batteryMock = mock(PatriotBattery.class);
        AimingMechanism aimingMock = createAimingMechanismMock(rocketsToLaunch, batteryMock);
        
        BetterRadar radar = new BetterRadar(batteryMock, aimingMock, rocketsToLaunch);
		Scud enemyMissle = new Scud();
		radar.notice(enemyMissle);
		verify(batteryMock).launchPatriot(enemyMissle);
	}
    
    private AimingMechanism createAimingMechanismMock(int rocketsToLaunch, PatriotBattery batteryMock) {
        AimingMechanism aimingMock = mock(AimingMechanism.class);
        Mockito.doAnswer(c -> {
IntStream.range(0, rocketsToLaunch).forEach(i -> batteryMock.launchPatriot(c.getArgument(0, Scud.class)));
            return null;
        })
                .when(aimingMock)
                .launchRocketsAgainst(Mockito.any(Scud.class), Mockito.anyInt());
        return aimingMock;
    }
    
}
