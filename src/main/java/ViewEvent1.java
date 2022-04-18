
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VaPa
 */
@WebServlet("/ViewEvent1")
public class ViewEvent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEvent1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;
		// String str_json_events = null;

		List<Event> list_event = EventManagementDAO.getAllEvents();
		if (!list_event.isEmpty()) {
			// RequestDispatcher rd = request.getRequestDispatcher("ParticipantEvent.html");
			// rd.forward(request, response);
			bool_success = true;
			str_next_url = "ViewEvent1.html";
			str_msg = "Event successfully loaded";
		} else {
			// out.print("<center><h1>Sorry username and password incorrect</h1></center>");
			// RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");
			// rd.include(request, response);
			bool_success = false;
			str_next_url = "ViewEvent1.html";
			str_msg = "!! No Event Loaded !!";
		}

		// System.out.println(str_json_events);
		JsonArrayBuilder jsArrayBuilder = Json.createArrayBuilder();
		for (Event event : list_event) {
			jsArrayBuilder.add(Json.createObjectBuilder().add("Event Number", event.getEvtNum())
					.add("Event Name", event.getEvtName()).add("Coordinator", event.getCoord())
					.add("Coordinator Number", event.getCoordnum()).add("Fee", event.getFee())
					.add("Venue", event.getVenue()).add("Event Date", event.getEdate()));
		}
		JsonArray jsArray = jsArrayBuilder.build();

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).add("list_event", jsArray).build();
		str_json = jsonObj.toString();
		System.out.println(str_json);

		out.print(str_json);
		out.flush();
		out.close();
	}
}