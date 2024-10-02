package MovieDetais;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class deleteMovie extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	EntityManagerFactory entity=Persistence.createEntityManagerFactory("movie.dev");
	EntityManager manger=entity.createEntityManager();
	EntityTransaction trasaction=manger.getTransaction();
	
	Movies mev=manger.find(Movies.class, id);
	trasaction.begin();
	manger.remove(mev);
	trasaction.commit();
	
	  
	 resp.getWriter().print("<h1>Movie deleted</h1>");
	 req.getRequestDispatcher("fetch-all").include(req, resp);
}
}
