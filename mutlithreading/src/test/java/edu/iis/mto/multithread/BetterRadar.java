package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class BetterRadar {

    private PatriotBattery battery;
    private int amountOfPatriotsForOneScud = 0;

    public BetterRadar(PatriotBattery battery, int amountOfPatriotsForOneScud) {
        this.battery = battery;
        this.amountOfPatriotsForOneScud = amountOfPatriotsForOneScud;

        doNothing().when(this.battery).launchPatriot(any(Scud.class));
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override public void run() {
                if (amountOfPatriotsForOneScud <= 0) {
                    for (int i = 0; i < 10; i++) {
                        battery.launchPatriot(enemyMissle);
                    }
                } else {
                    for (int i = 0; i < amountOfPatriotsForOneScud; i++) {
                        battery.launchPatriot(enemyMissle);
                    }
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();

        try {
            launchingThread.join();
        } catch (InterruptedException e) {
        }
    }
}
