package edu.iis.mto.multithread;

public class StandardDefenseSystemImpl implements DefenseSystem {
    @Override
    public void executeDefenseCommand(Runnable task) {
        var th = new Thread(task);
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
