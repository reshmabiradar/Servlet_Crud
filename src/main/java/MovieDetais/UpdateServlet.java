package MovieDetais;

import java.io.IOException;

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
@WebServlet("/update-movies")
@MultipartConfig
public class UpdateServlet extends HttpServlet{
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
		 
		 if(poster.length>0)
		 movie.setPoster(poster);
		 
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("movie.dev");
 		 EntityManager manger=factory.createEntityManager();
 		 EntityTransaction transction=manger.getTransaction();
 		
 		 transction.begin();
 		 manger.merge(movie);
         transction.commit();
         resp.getWriter().print("<h1>updated susefully</h1>");
      //   req.getRequestDispatcher("home.html").include(req, resp);
    	
		
	}

}
