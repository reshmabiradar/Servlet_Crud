package MovieDetais;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch-all")
public class Featch_movies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("movie.dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Movies> movie = manager.createQuery("select x from Movies x").getResultList();

		if (movie.isEmpty()) {
			resp.getWriter().print("<h1>no moviess foundddd</h1>");
			req.getRequestDispatcher("home.html");

		} else {
			req.setAttribute("M", movie);
			req.getRequestDispatcher("fetch-all.jsp").include(req, resp);
		}

	}
}
