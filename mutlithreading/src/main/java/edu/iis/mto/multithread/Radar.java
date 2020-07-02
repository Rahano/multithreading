package edu.iis.mto.multithread;

public class Radar {

    private PatriotBattery battery;

    public Radar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
    
