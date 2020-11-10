package no.hvl.dat108.oblig4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public class DeltakerlisteDAO {

    @PersistenceContext(name = "persistenceUnit")
    private static EntityManagerFactory emf;

    public static Deltaker hentTestDeltaker() {
        // Test: Hente en enkelt deltaker

        EntityManager em = emf.createEntityManager();
        Deltaker testDeltaker = em.find(Deltaker.class, 91429001);
        return testDeltaker;
    }
    // TODO: Hente liste med deltakere

}
