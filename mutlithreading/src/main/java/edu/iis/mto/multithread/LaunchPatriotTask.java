package edu.iis.mto.multithread;

public class LaunchPatriotTask extends Thread {

    private PatriotBattery battery;
    private Scud enemyMissile = new Scud();
    private int nLaunches;

    public LaunchPatriotTask(PatriotBattery battery, int nLaunches) {
        this.battery = battery;
        this.nLaunches = nLaunches;
    }

    public void setEnemyMissile(Scud enemyMissile) {
        this.enemyMissile = enemyMissile;
    }

    @Override
    public void run() {
        for (int i = 0; i < nLaunches; i++) {
            battery.launchPatriot(enemyMissile);
        }
    }
}
