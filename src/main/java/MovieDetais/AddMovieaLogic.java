package MovieDetais;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/add")
@MultipartConfig
public class AddMovieaLogic extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("add_movie.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String moviename = req.getParameter("moviename");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
        int rating = Integer.parseInt(req.getParameter("rating"));
		String[] genre = req.getParameterValues("genre");
		Part image = req.getPart("poster");
		
		Movies movie=new Movies();
		 movie.setDescription(description);
		 movie.setGenre(genre);
		 movie.setLanguage(language);
		 movie.setMoviename(moviename);
		 movie.setRating(rating);
		 
		 byte[] poster=new byte[image.getInputStream().available()];
		 image.getInputStream().read(poster);
		 movie.setPoster(poster);
		 
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("movie.dev");
 		 EntityManager manger=factory.createEntityManager();
 		 EntityTransaction transction=manger.getTransaction();
 		
 		 transction.begin();
 		 manger.persist(movie);
         transction.commit();
         resp.getWriter().print("<h1>adding susefully<h1>");
         req.getRequestDispatcher("home.html").include(req, resp);
    	}
}
