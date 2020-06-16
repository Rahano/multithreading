package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class BetterRadar {
    private int missilesCount;
    private PatriotBattery battery;
    private DefenseSystem system;

    public BetterRadar(PatriotBattery battery, int missilesCount){
        this.battery = battery;
        this.missilesCount = missilesCount;
        this.system = new StandardDefenseSystemImpl();
    }

    public void setDefenseSystem(DefenseSystem system){
        this.system = system;
    }

    public void notice(Scud enemyMissile){
        system.executeDefenseCommand(prepareTaskForDefenseSystem(enemyMissile));
    }

    private Runnable prepareTaskForDefenseSystem(Scud noticedMissile){
        return () -> IntStream.range(0, missilesCount).forEach(patriot -> battery.launchPatriot(noticedMissile));
    }
}