package edu.iis.mto.multithread;

public class MissileLauncher implements Runnable {
    private Scud enemyMissile;
    private int missilesToLaunch;
    private PatriotBattery battery;
    MissileLauncher(Scud enemyMissile, int missilesToLaunch, PatriotBattery battery){
        this.enemyMissile = enemyMissile;
        this.missilesToLaunch = missilesToLaunch;
        this.battery = battery;
    }

    @Override public void run() {
        for (int i = 0; i < missilesToLaunch; i++) {
            battery.launchPatriot(enemyMissile);
        }

    }
}
