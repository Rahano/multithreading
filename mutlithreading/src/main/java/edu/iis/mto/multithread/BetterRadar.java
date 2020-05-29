package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int missiles;

    public BetterRadar(PatriotBattery battery, int missiles) {
        this.battery = battery;
        this.missiles = missiles;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, missiles);
    }

    private void launchPatriot(Scud enemyMissle, int missiles) {
        Runnable missileLauncher = new MissileLauncher(enemyMissle, missiles, battery);
        Thread launchingThread = new Thread(missileLauncher);
        launchingThread.start();
        try {
            launchingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Error while joining launcher thread");
        }
    }
}
