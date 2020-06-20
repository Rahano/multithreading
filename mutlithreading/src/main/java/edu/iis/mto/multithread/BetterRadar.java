package edu.iis.mto.multithread;

public class BetterRadar {

    private final PatriotBattery battery;
    private final TargetMechanism targetMechanism;
    private int missileQuantity = 0;

    public BetterRadar(PatriotBattery battery, TargetMechanism targetMechanism, int missileQuantity) {
        this.battery = battery;
        this.targetMechanism = targetMechanism;
        this.missileQuantity = missileQuantity;
    }

    public void notice(Scud enemyMissile) {
        targetMechanism.launchPatriot(() -> {
            for (int i = 0; i < missileQuantity; i++) {
                battery.launchPatriot(enemyMissile);
            }
        });
    }
}
