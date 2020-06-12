package edu.iis.mto.multithread;

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
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        defenceMechanism.defence(battery, missilesCount, enemyMissle);
    }
}
