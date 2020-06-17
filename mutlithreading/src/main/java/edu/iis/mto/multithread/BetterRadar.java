package edu.iis.mto.multithread;

public class BetterRadar {
    private final int volleySize;
    private PatriotBattery battery;
    private AimingInstruments aimingInstruments;

    public BetterRadar(AimingInstruments aimingInstruments, PatriotBattery battery, int volleySize) {
        this.aimingInstruments = aimingInstruments;
        this.battery = battery;
        this.volleySize = volleySize;
    }

    public void notice(Scud enemyMissile) {
        this.launchVolley(enemyMissile);
    }

    private void launchVolley(Scud enemyMissile) {
        for(int missileCounter = 0; missileCounter < volleySize; missileCounter++) {
            this.aimingInstruments.launch(battery, enemyMissile);
        }
    }
}