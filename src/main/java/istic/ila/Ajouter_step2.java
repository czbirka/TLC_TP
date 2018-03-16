package istic.ila;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajouter_step2
 */
@WebServlet("/Ajouter_step2")
public class Ajouter_step2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_step2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Ajouter_step2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
        request.setAttribute("titre", titre);
        String prix = request.getParameter("prix");
        request.setAttribute("prix", prix);
        String date = request.getParameter("date");
        request.setAttribute("date", date);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Ajouter_step2.jsp").forward(request, response);
	}

}
