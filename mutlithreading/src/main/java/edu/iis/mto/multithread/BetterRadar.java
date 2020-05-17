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
		for(int i = 0; i < numberOfMissles; ++i){
			launchPatriotic.launchPatriot(battery, enemyMissle);
		}
	}

}
