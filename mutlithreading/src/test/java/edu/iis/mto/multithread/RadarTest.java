package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.IntStream;

public class RadarTest {
	
	private Radar radar;
	private PatriotBattery batteryMock;
	
	@BeforeEach
	void setUp() {
		
		batteryMock = mock(PatriotBattery.class);
	}
	
	@RepeatedTest(10)
	public void launchPatriotOnceForEachEnemyMissileWhenNoticesAny() {
		int rocketsToLaunch = 1;
		AimingMechanism aimingMechanism = createAimingMechanismMock(rocketsToLaunch, batteryMock);
		Radar radar = new Radar(batteryMock, aimingMechanism, rocketsToLaunch);
		
		
		Scud enemyMissle = new Scud();
		radar.notice(enemyMissle);
		verify(batteryMock, times(rocketsToLaunch)).launchPatriot(enemyMissle);
	}
	
	@Test
	public void launchPatriotTwoTimesForEachEnemyMissileWhenNoticesAny() {
		int rocketsToLaunch = 2;
		AimingMechanism aimingMechanism = createAimingMechanismMock(rocketsToLaunch, batteryMock);
		Radar radar = new Radar(batteryMock, aimingMechanism, rocketsToLaunch);
		
		
		Scud enemyMissle = new Scud();
		radar.notice(enemyMissle);
		verify(batteryMock, times(rocketsToLaunch)).launchPatriot(enemyMissle);
	}
	
	private AimingMechanism createAimingMechanismMock(int rocketsToLaunch, PatriotBattery batteryMock) {
		AimingMechanism aimingMock = mock(AimingMechanism.class);
		Mockito.doAnswer(c -> {
			((Runnable) c.getArgument(0)).run();
			return null;
		}).when(aimingMock)
				.launchRocketsAgainst(any(Runnable.class));
		return aimingMock;
	}
}
