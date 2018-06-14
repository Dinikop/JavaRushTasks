package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State prevState = target.getState();
        System.out.println(prevState.name());

        while (true) {
            State currentState = target.getState();
            if (prevState != currentState) {
                System.out.println(currentState.name());
                prevState = currentState;
            }
            if (currentState == State.TERMINATED) break;
        }

    }
}
