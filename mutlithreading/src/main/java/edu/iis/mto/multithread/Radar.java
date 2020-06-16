package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class Radar {

    private int rocketsToLaunch;
    private PatriotBattery battery;
    private AimingMechanism aimingMechanism;
    
    public Radar(PatriotBattery battery, AimingMechanism aimingMechanism, int rocketsToLaunch) {
        this.rocketsToLaunch = rocketsToLaunch;
        this.battery = battery;
        this.aimingMechanism = aimingMechanism;
    }
    
    public void notice(Scud enemyMissle) {
        this.aimingMechanism.launchRocketsAgainst(
                () -> IntStream.range(0, this.rocketsToLaunch).forEach(missile -> battery.launchPatriot(enemyMissle))
        );
    }
    
    public Radar(PatriotBattery battery) {
        this.battery = battery;
    }
}
