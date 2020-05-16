package edu.iis.mto.multithread;

public class BetterRadar {
	private final int rocketsToLaunch;
	private PatriotBattery battery;
	private AimingMechanism aimingMechanism;
	
	public BetterRadar(PatriotBattery battery, AimingMechanism aimingMechanism, int rocketsToLaunch) {
		this.rocketsToLaunch = rocketsToLaunch;
		this.battery = battery;
		this.aimingMechanism = aimingMechanism;
	}
	
	public void notice(Scud enemyMissle) {
		this.aimingMechanism.launchRocketsAgainst(enemyMissle, this.rocketsToLaunch);
	}
}
