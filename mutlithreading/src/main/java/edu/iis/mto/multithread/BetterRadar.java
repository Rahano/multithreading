package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int missiles;
    private LaunchHandler launchHandler;

    public BetterRadar(PatriotBattery battery, int missiles, LaunchHandler launchHandler) {
        this.battery = battery;
        this.missiles = missiles;
        this.launchHandler = launchHandler;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, missiles);
    }

    private void launchPatriot(Scud enemyMissle, int missiles) {
        Runnable missileLauncher = () -> {
            for (int i = 0; i < missiles; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        launchHandler.launch(missileLauncher);
    }
}
