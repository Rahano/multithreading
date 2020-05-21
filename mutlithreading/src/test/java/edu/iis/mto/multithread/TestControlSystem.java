package edu.iis.mto.multithread;

public class TestControlSystem implements ControlSystem {
    public void launchVolley(PatriotBattery patriotBattery, int volleySize, Scud enemyMissile) {
        for(int i = 0; i < volleySize; i++) {
            patriotBattery.launchPatriot(enemyMissile);
        }
    }
}
