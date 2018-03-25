package istic.ila;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet(
	    name = "Ajouter",
	    urlPatterns = {"/ajouter"}
)
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String offre = request.getParameter("offre");
	    String prix = request.getParameter("prix");
	    String date = request.getParameter("date");
	    
	    Annonce annonce = new Annonce(offre, Long.parseLong(prix));
	    annonce.save();

	    response.sendRedirect("/WEB-INF/ajouter_2.jsp");
		
		
//        request.setAttribute("offre", offre);
//        request.setAttribute("prix", prix);
//        request.setAttribute("date", date);
//        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_2").forward(request, response);
	}

}
