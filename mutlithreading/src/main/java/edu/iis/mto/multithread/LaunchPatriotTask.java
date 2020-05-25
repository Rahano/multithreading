package edu.iis.mto.multithread;

public class LaunchPatriotTask extends Thread {

    private PatriotBattery battery;
    private Scud enemyMissile = new Scud();

    public LaunchPatriotTask(PatriotBattery battery) {
        this.battery = battery;
    }

    public void setEnemyMissile(Scud enemyMissile) {
        this.enemyMissile = enemyMissile;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            battery.launchPatriot(enemyMissile);
        }
    }
}
