package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int amountOfPatriotsForOneScud = 0;
    private DefenseSystem defenseSystem;

    public BetterRadar(PatriotBattery battery, DefenseSystem defenseSystem, int amountOfPatriotsForOneScud) {
        this.battery = battery;
        this.amountOfPatriotsForOneScud = amountOfPatriotsForOneScud;
        this.defenseSystem = defenseSystem;
    }

    public void notice(Scud enemyMissle) {
        defenseSystem.activateBatteries(enemyMissle, amountOfPatriotsForOneScud);
    }
}
