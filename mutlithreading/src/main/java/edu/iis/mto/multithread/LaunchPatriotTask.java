package edu.iis.mto.multithread;

public class LaunchPatriotTask extends Thread {

    private PatriotBattery battery;
    private Scud enemyMissile = new Scud();
    private int nLaunches = 1;

    public LaunchPatriotTask(PatriotBattery battery) {
        this.battery = battery;
    }

    public void setEnemyMissile(Scud enemyMissile) {
        this.enemyMissile = enemyMissile;
    }

    public void setNumberOfLaunches(int nLaunches) {
        this.nLaunches = nLaunches;
    }

    @Override
    public void run() {
        for (int i = 0; i < nLaunches; i++) {
            battery.launchPatriot(enemyMissile);
        }
    }
}
