package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class LaunchPatrioticMock implements LaunchPatriotic {
	private PatriotBattery battery;
	private int numberOfMissles = 0;

	public LaunchPatrioticMock(int numberOfMissles){
		this.numberOfMissles = numberOfMissles;
	}

	@Override
	public void launchPatriot(PatriotBattery battery, Scud enemyMissle) {
		if(this.battery == null) this.battery = battery;
		Runnable task = () -> IntStream.range(0, numberOfMissles).forEach(i -> battery.launchPatriot(enemyMissle));
		task.run();
	}
}
