package edu.iis.mto.multithread;

public class BetterRadar {
    private int missilesCount;
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery battery, int missilesCount){
        this.battery = battery;
        this.missilesCount = missilesCount;
    }
}
