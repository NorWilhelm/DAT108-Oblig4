package no.hvl.dat108.semafor;

import java.util.concurrent.Semaphore;

public class KritiskRegion {

    // Maks 4 kunder tillatt samtidig inne i forretningen i henhold til gjeldende kårånatiltak
    static Semaphore kundeTillater = new Semaphore(4);


    static class KunderIForretningenTråd extends Thread {

        String kundenavn = "";

        KunderIForretningenTråd(String kundenavn) { this.kundenavn = kundenavn; }

        public void run() {



        }

    }
}
