package no.hvl.dat108.oblig4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PameldingServlet")
public class PameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO meldingpaaDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Paameldingsskjema paameldskjema = new Paameldingsskjema(request);
		boolean deltagerfinnes = false;
		
		if (paameldskjema.gyldigSkjema() && !meldingpaaDAO.deltagerFinnes(request.getParameter("mobil"))) { 
			
			HttpSession sesjon = request.getSession(false);

			Deltager deltager = paameldskjema.lagDeltager();
			meldingpaaDAO.leggTilDeltager(deltager);
			
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);

			request.getSession().setAttribute("fornavn", paameldskjema.getFornavn());
			request.getSession().setAttribute("etternavn", paameldskjema.getEtternavn());
			request.getSession().setAttribute("mobil", paameldskjema.getMobil());
			request.getSession().setAttribute("kjonn", paameldskjema.getKjonn());
			request.getSession().removeAttribute("Skjema");
			response.sendRedirect("Bekreftelse");

		} else {
			deltagerfinnes = true;
			paameldskjema.deltagerMobilfinnes(deltagerfinnes);
			paameldskjema.feilmeldinger();
			request.getSession().setAttribute("Skjema", paameldskjema);
			response.sendRedirect("PameldingServlet" + "");

		}
	}

}
