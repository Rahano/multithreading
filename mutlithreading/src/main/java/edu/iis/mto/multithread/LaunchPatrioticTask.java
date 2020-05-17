package edu.iis.mto.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class LaunchPatrioticTask implements LaunchPatriotic, Runnable {
	private Scud enemyMissle;
	private PatriotBattery battery;
	private final int numberOfMissles;
	private AtomicInteger counter = new AtomicInteger(0);

	public LaunchPatrioticTask(int numberOfMissles){
		this.numberOfMissles = numberOfMissles;
	}

	@Override
	public void run() {
		battery.launchPatriot(enemyMissle);
		counter.getAndIncrement();
	}

	@Override
	public void launchPatriot(PatriotBattery battery, Scud enemyMissle) {
		this.enemyMissle = enemyMissle;
		this.battery = battery;
		this.run();
	}

	public void waitForAllMissles(){
		while(counter.get() < numberOfMissles);
	}
}
