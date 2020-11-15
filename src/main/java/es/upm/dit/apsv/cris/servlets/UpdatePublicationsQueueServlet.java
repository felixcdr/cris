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


@WebServlet("/UpdatePublicationsQueueServlet")
public class UpdatePublicationsQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id"); // researcherId
		if ((id == null) || id.contentEquals(""))
			getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
        Client client = ClientBuilder.newClient(new ClientConfig());
        client.target(URLHelper.getInstance().getCrisURL() + "/rest/Researchers/" + id + "/UpdatePublications").request()
          		.post(Entity.entity(id, MediaType.APPLICATION_JSON), Response.class);
		response.sendRedirect(request.getContextPath() + "/ResearcherServlet?id=" + id);
	}
}
