package org.example;

public class Application {

    private final Bootstrap bootstrap;


    public Application() {
        bootstrap = new Bootstrap();

    }

    public void run() {
        while (true) {
            bootstrap.getScreenService().update();
        }
    }
}
