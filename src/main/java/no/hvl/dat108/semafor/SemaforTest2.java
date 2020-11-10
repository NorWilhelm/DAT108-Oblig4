package no.hvl.dat108.semafor;

import java.util.concurrent.Semaphore;

public class SemaforTest2 {

    // maks 4 personer
    static Semaphore minibankTildeler = new Semaphore(4);

    static class minibankTråd extends Thread {

        String navn = "";

        minibankTråd(String navn) { this.navn = navn; }

        public void run() {

            try {
                System.out.println(navn + " : Ser etter ledig minibank...");
                System.out.println(navn + " : ledige minibank(er): "
                        + minibankTildeler.availablePermits());

                minibankTildeler.acquire();
                System.out.println(navn + " : Fikk ledig minibank!");

                try {
                    for (int i = 1; i <= 5; i++) {

                        System.out.println(navn + " : bruker minibank " + i
                                + ", ledige minibank(er) : "
                                + minibankTildeler.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);
                    }

                } finally {
                    // calling release() after a successful acquire()
                    System.out.println(navn + " : Går vekk fra minibanken (og dynker den i sprit)...");
                    minibankTildeler.release();
                    System.out.println(navn + " : Antall ledige minibanker: "
                            + minibankTildeler.availablePermits());
                }

            } catch (InterruptedException e) { e.printStackTrace(); }

        }
    }

    public static void main(String[] args) {

        System.out.println("Antall ledige minibanker : "
                + minibankTildeler.availablePermits());

        minibankTråd t1 = new minibankTråd("A");
        t1.start();

        minibankTråd t2 = new minibankTråd("B");
        t2.start();

        minibankTråd t3 = new minibankTråd("C");
        t3.start();

        minibankTråd t4 = new minibankTråd("D");
        t4.start();

        minibankTråd t5 = new minibankTråd("E");
        t5.start();

        minibankTråd t6 = new minibankTråd("F");
        t6.start();

    }
}