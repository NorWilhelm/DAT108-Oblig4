package no.hvl.dat108.oblig4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="Deltakerliste", urlPatterns= "/Deltakerliste")
public class Deltakerliste extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
	//public void init() {
	//}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO: DB-spørringer. Vurder å bruke egen DeltakerDAO for å hente data
        EntityManager em = emf.createEntityManager();
        Deltaker testDeltaker; // Skal være en liste av deltakere
            testDeltaker = em.find(Deltaker.class, 91100230);
        ;
        request.setAttribute("deltaker", testDeltaker);

        // TODO: Feilmeldingsboks
        // List<Melding> meldinger = meldingEAO.henteNSisteMeldinger(visningsantall);
        // request.setAttribute("meldinger", meldinger);

        request.getRequestDispatcher("WEB-INF/deltakerliste.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Behandle innloggingen
        String passord = request.getParameter("passord");

        response.sendRedirect("logginn?feilkode=1");

        response.sendRedirect("Handleside");
    }
}