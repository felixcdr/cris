package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.apsv.cris.model.Publication;
import es.upm.dit.apsv.cris.model.Researcher;

@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Researcher user = (Researcher) (request.getSession().getAttribute("user"));
		if ((user != null)) {
			Publication p = new Publication();
			p.setId(request.getParameter("id"));
			p.setTitle(request.getParameter("title"));
			p.setPublicationName(request.getParameter("publicationname"));
			p.setPublicationDate(request.getParameter("publicationdate"));
			p.setAuthors(request.getParameter("authors"));
			
			ClientConfig config = new ClientConfig();
	        Client client = ClientBuilder.newClient(config);
	        client.target(URLHelper.getInstance().getCrisURL() + "/rest/Publications/").request()
	                .post(Entity.entity(p, MediaType.APPLICATION_JSON), Response.class);

			response.sendRedirect(request.getContextPath() + "/AdminServlet");
		}
		else {
			request.setAttribute("message", "You are not allowed to add Publications");
			getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
		}
	}
}
