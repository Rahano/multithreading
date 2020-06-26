package edu.iis.mto.multithread;

public class BetterRadar {

    private RocketLauncher rocketLauncher;
    private int nLaunches;

    public BetterRadar(RocketLauncher rocketLauncher, int nLaunches) {
        this.rocketLauncher = rocketLauncher;
        this.nLaunches = nLaunches;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        for(int i = 0; i < nLaunches; i++) {
            rocketLauncher.launch(enemyMissile);
        }
    }
}
