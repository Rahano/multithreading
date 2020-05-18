package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private BatterySystem batterySystem;
    private int numberOfMissiles;

    public BetterRadar(PatriotBattery battery, BatterySystem batterySystem, int numberOfMissiles) {
        this.battery = battery;
        this.batterySystem = batterySystem;
        this.numberOfMissiles = numberOfMissiles;
    }

    public void notice(Scud enemyMissile) {
        this.batterySystem.launchPatriot(this.battery, enemyMissile, this.numberOfMissiles);
    }

}
