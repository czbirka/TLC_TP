package istic.ila;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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

        
        Annonce annonce;

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser(); // Find out who the user is.

//        String guestbookName = req.getParameter("guestbookName");
//        String titre = request.getParameter("titre");
//        String prix = request.getParameter("prix");
//        String date = request.getParameter("date");
//        if (user != null) {
//        	annonce = new Annonce(guestbookName, content, user.getUserId(), user.getEmail());
//        } else {
//        	annonce = new Annonce(guestbookName, content);
//        }

        //annonce.save();

 //       response.sendRedirect("/guestbook.jsp?guestbookName=" + guestbookName);
	}

}
