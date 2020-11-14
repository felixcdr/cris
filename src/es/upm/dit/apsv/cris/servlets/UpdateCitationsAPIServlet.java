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


@WebServlet("/UpdateCitationsAPIServlet")
public class UpdateCitationsAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("id");	
        Client client = ClientBuilder.newClient(new ClientConfig());
        client.target("http://localhost:8080/CRISSERVICE/rest/Publications/" + pid + "/UpdateCiteNumber").request()
          		.post(Entity.entity(pid, MediaType.APPLICATION_JSON), Response.class);
		response.sendRedirect(request.getContextPath()+"/PublicationServlet?id="+pid);
	}
 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
