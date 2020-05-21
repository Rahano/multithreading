package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery controller;
    private int batteryCounter;

    public BetterRadar(PatriotBattery controller, int batteryCounter) {
        this.controller = controller;
        this.batteryCounter = batteryCounter;
    }

    public void notice(Scud enemyMissile) {
        for (int i = 0; i < batteryCounter; i++) {
            controller.launchPatriot(enemyMissile);
        }
    }
}