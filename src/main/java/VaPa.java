
import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VaPa
 */
@WebServlet("/VaPa")
public class VaPa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VaPa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetching data from HTML form
		String n = request.getParameter("Pausername");
		String p = request.getParameter("Papassword");

		n = (n != null && n.trim().isEmpty()) ? null : n.trim();
		p = (p != null && p.trim().isEmpty()) ? null : p.trim();

		String contentType = request.getContentType();
		System.out.println(contentType);
		System.out.println(n);
		System.out.println(p);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;

		if (n != null && p != null) {
			if (EventManagementDAO.validate(n, p)) {
				// RequestDispatcher rd = request.getRequestDispatcher("ParticipantEvent.html");
				// rd.forward(request, response);
				bool_success = true;
				str_next_url = "ParticipantEvent.html";
				str_msg = "Successful Participant Login";
			} else {
				// out.print("<center><h1>Sorry username and password incorrect</h1></center>");
				// RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");
				// rd.include(request, response);
				bool_success = false;
				str_next_url = "Plogin.html";
				str_msg = "!! Sorry Username and Password incorrect !!";
			}
		} else {
			// out.print("<center><h1>Sorry username and password incorrect</h1></center>");
			// RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");
			// rd.include(request, response);
			bool_success = false;
			str_next_url = "Plogin.html";
			str_msg = "!! Username and Password cannot be null !!";
		}

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).build();
		str_json = jsonObj.toString();

		out.print(str_json);
		out.flush();
		out.close();
	}
}