package no.hvl.dat108.oblig4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="loggInn", urlPatterns= "/logginn")
public class loggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	String password;
	public void init() {
		password = getServletConfig().getInitParameter("password");
	}
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO: Feilmeldingsboks
		// List<Melding> meldinger = meldingEAO.henteNSisteMeldinger(visningsantall);
		// request.setAttribute("meldinger", meldinger);

		request.getRequestDispatcher("WEB-INF/loggInn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO: Behandle innloggingen
		String passord = request.getParameter("passord");


		response.sendRedirect("Handleside");

		// TODO: Feilkode og redirect til samme side ved feil passord fra databasen.
		// response.sendRedirect("logginn?feilkode=1");
	}
}