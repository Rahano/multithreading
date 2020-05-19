package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class BetterRadar {
    private int missilesCount;
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery battery, int missilesCount){
        this.battery = battery;
        this.missilesCount = missilesCount;
    }

    public void notice(Scud enemyMissile){

    }

    private Runnable prepareTaskForDefenseSystem(Scud noticedMissile){
        return () -> IntStream.range(0, missilesCount).forEach(patriot -> battery.launchPatriot(noticedMissile));
    }
}
