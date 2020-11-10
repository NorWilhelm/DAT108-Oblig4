package no.hvl.dat108.semafor;

public class Semafor {
    private boolean signal = false;

    public synchronized void acquire() {
        signal = true;
        notify();
    }

    public synchronized void release() throws InterruptedException{
        while(!signal) {
            wait();
        }

        signal = false;
    }
}