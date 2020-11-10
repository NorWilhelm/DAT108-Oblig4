package no.hvl.dat108.semafor;

import java.util.concurrent.Semaphore;

public class SemaforTest {

    // maks 4 personer
    static Semaphore kundeTillater = new Semaphore(4);

    static class KunderIForretningenTråd extends Thread {

        String navn = "";

        KunderIForretningenTråd(String navn) { this.navn = navn; }

        public void run() {

            try {
                System.out.println(navn + " : Venter ute og vil inn i forretningen...");
                System.out.println(navn + " : ledig kundekapasitet i kritisk region (forretningen): " + kundeTillater.availablePermits());

                kundeTillater.acquire();
                System.out.println(navn + " : Tar på munnbind og går inn i forretningen!");

                try {
                    for (int i = 1; i <= 5; i++) {

                        System.out.println(navn + " : befinner seg i forretningen (kritisk region) " + i
                                + ", ledige kundekapasitet : " + kundeTillater.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);
                    }

                } finally {
                    // calling release() after a successful acquire()
                    System.out.println(navn + " : Går ut av forretningen og dynker hendene i sprit");
                    kundeTillater.release();
                    System.out.println(navn + " : ledig kundekapasitet: " + kundeTillater.availablePermits());
                }

            } catch (InterruptedException e) { e.printStackTrace(); }

        }
    }

    public static void main(String[] args) {

        System.out.println("Ledig kundekapasitet i henhold til gjeldende kårånatiltak : "
                + kundeTillater.availablePermits());

        KunderIForretningenTråd t1 = new KunderIForretningenTråd("A");
        t1.start();

        KunderIForretningenTråd t2 = new KunderIForretningenTråd("B");
        t2.start();

        KunderIForretningenTråd t3 = new KunderIForretningenTråd("C");
        t3.start();

        KunderIForretningenTråd t4 = new KunderIForretningenTråd("D");
        t4.start();

        KunderIForretningenTråd t5 = new KunderIForretningenTråd("E");
        t5.start();

        KunderIForretningenTråd t6 = new KunderIForretningenTråd("F");
        t6.start();

    }
}