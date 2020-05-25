package edu.iis.mto.multithread;

public class BetterRadar {

    private LaunchPatriotTask launchPatriot;

    public BetterRadar(LaunchPatriotTask launchPatriot) {
        this.launchPatriot = launchPatriot;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        launchPatriot.setEnemyMissile(enemyMissile);
        launchPatriot.start();
    }
}
