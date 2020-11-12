package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.Paameldingsskjema;
import no.hvl.dat108.oblig4.Validator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Foresp�rselen din krever p�logging. " + "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUsername") != null) {
			loginMessage = "Manglende eller ugyldig brukernavn/passord";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");

		if (!Validator.gyldigMobil(mobil) || !Validator.gyldigPassord(passord)) {
			response.sendRedirect("Login" + "?invalidUsername");
		} else {

			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(90);

			sesjon.setAttribute("mobil", mobil);
			sesjon.setAttribute("passord", passord);
			sesjon.setAttribute("deltager", new Paameldingsskjema());

			response.sendRedirect("Deltagerliste");
		}

	}

}
