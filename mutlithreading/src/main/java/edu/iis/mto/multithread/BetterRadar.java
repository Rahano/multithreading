package edu.iis.mto.multithread;

public class BetterRadar {
	private PatriotBattery battery;
	private final int numberOfMissles;
	private LaunchPatriotic launchPatriotic;
	
	public BetterRadar(PatriotBattery battery, LaunchPatriotic launchPatriotic, int numberOfMissles) {
		this.battery = battery;
		this.numberOfMissles = numberOfMissles;
		this.launchPatriotic = launchPatriotic;
	}

	public void notice(Scud enemyMissle) {
		launchPatriotic.launchPatriot(battery, enemyMissle);
	}

}
