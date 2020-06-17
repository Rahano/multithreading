package edu.iis.mto.multithread;

public class TestAimingInstruments implements AimingInstruments {
    public void launch(PatriotBattery patriotBattery, Scud enemyMissile) {
        patriotBattery.launchPatriot(enemyMissile);
    }
}
