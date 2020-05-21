package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery controller;
    private int batteryCounter;

    // I think that Radar should not be concerned with how many rockets
    // is battery going to launch. We could use for example command
    // pattern, then radar would use only PatriotBattery launchPatriot
    // method
    public BetterRadar(PatriotBattery controller) {
        this.controller = controller;
        this.batteryCounter = 1;
    }

    public void changePatriotsCounter(int counter) {
        this.batteryCounter = counter;
    }

    public void notice(Scud enemyMissile) {
        for (int i = 0; i < batteryCounter; i++) {
            controller.launchPatriot(enemyMissile);
        }
    }
}