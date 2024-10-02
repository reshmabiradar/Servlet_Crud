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
@WebServlet("/edit")
public class EditServlet  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int  id=Integer.parseInt(req.getParameter("id"));
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("movie.dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction trasaction=manager.getTransaction();
	
    Movies movie=manager.find(Movies.class,id); 
    req.setAttribute("M", movie);
    req.getRequestDispatcher("edit.jsp").forward(req, resp);

}

}
