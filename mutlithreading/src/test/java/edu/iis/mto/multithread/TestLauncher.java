package edu.iis.mto.multithread;

public class TestLauncher implements LaunchHandler {

    @Override public void launch(Runnable missileLauncher) {
        missileLauncher.run();
    }
}
