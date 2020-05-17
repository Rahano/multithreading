package edu.iis.mto.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class LaunchPatrioticTask implements LaunchPatriotic, Runnable {
	private Scud enemyMissle;
	private PatriotBattery battery;

	@Override
	public void run() {
		battery.launchPatriot(enemyMissle);
	}

	@Override
	public void launchPatriot(PatriotBattery battery, Scud enemyMissle) {
		if(this.battery == null || this.enemyMissle == null){
			this.enemyMissle = enemyMissle;
			this.battery = battery;
		}
		this.run();
	}
}
