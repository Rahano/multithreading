package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher implements LaunchHandler {

    @Override
    public void launch(Runnable missileLauncher) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(missileLauncher);
    }

}
