package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

     Thread thread;

    @Override
    public void start(String threadName) { // создаем трэд и запускаем
        Thread thread = new Thread(this, threadName);
        this.thread = thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt(); // прерываем трэд
    }

    @Override
    public void run() {
        try { // Если interrupt() был вызван до выполнения Thread.sleep(100), вызывается try-catch и завершается трэд.
            while (!thread.currentThread().isInterrupted()) { // Проверка на прерывание если interrupt() был вызван во время выполнения Thread.sleep(100), и завершается трэд.
                System.out.println(thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}
