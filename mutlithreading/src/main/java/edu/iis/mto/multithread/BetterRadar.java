package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class BetterRadar {

    private PatriotBattery battery;

    private final int missilesCount;

    private DefenceMechanism defenceMechanism;

    public BetterRadar(PatriotBattery battery, int missilesCount, DefenceMechanism defenceMechanism) {
        this.battery = battery;
        this.missilesCount = missilesCount;
        this.defenceMechanism = defenceMechanism;
    }

    public void notice(Scud enemyMissle) {
        defenceMechanism.defence(() -> IntStream.range(0, missilesCount)
                                                .forEach(i -> battery.launchPatriot(enemyMissle)));
    }
}
