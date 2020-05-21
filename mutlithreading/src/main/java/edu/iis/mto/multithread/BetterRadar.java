package edu.iis.mto.multithread;

public class BetterRadar {
    private final int volleySize;
    private PatriotBattery battery;
    private ControlSystem control;

    public BetterRadar(ControlSystem control, PatriotBattery battery, int volleySize) {
        this.control = control;
        this.battery = battery;
        this.volleySize = volleySize;
    }

    public void notice(Scud enemyMissile) {
        control.launchVolley(battery, volleySize, enemyMissile);
    }
}