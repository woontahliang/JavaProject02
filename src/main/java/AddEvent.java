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
 * Servlet implementation class StoreP
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetching data from Registration.html
		String a1 = request.getParameter("EventNo");
		String a2 = request.getParameter("EventName");
		String a3 = request.getParameter("coordinatorName");
		String a4 = request.getParameter("CoordinatorNo");
		String a5 = request.getParameter("fee");
		String a6 = request.getParameter("venue");
		String a7 = request.getParameter("date");

		a1 = (a1 != null && a1.trim().isEmpty()) ? null : a1.trim();
		a2 = (a2 != null && a2.trim().isEmpty()) ? null : a2.trim();
		a3 = (a3 != null && a3.trim().isEmpty()) ? null : a3.trim();
		a4 = (a4 != null && a4.trim().isEmpty()) ? null : a4.trim();
		a5 = (a5 != null && a5.trim().isEmpty()) ? null : a5.trim();
		a6 = (a6 != null && a6.trim().isEmpty()) ? null : a6.trim();
		a7 = (a7 != null && a7.trim().isEmpty()) ? null : a7.trim();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;

		if (a1 != null && a2 != null && a3 != null && a4 != null && a5 != null && a6 != null && a7 != null) {
			try {
				bool_success = EventManagementDAO.addEvent(a1, a2, a3, a4, a5, a6, a7);
				str_next_url = "CreateE.html";
				str_msg = "New Administrator Event added";
			} catch (Exception exe) {
				bool_success = false;
				str_next_url = "CreateE.html";
				str_msg = "!! " + exe + " !!";
				System.out.println(exe);
			}
		} else {
			bool_success = false;
			str_next_url = "CreateE.html";
			str_msg = "!! Event Number, Event Name, Coordinator Name, Coordinator Number, Fee, Venue and Date cannot be null !!";
		}

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).build();
		str_json = jsonObj.toString();

		out.print(str_json);
		out.flush();
		out.close();
	}
}