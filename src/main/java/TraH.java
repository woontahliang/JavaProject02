
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
@WebServlet("/TraH")
public class TraH extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TraH() {
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

		List<Card> list_card = EventManagementDAO.getAllCards();
		if (!list_card.isEmpty()) {
			bool_success = true;
			str_next_url = "TraH.html";
			str_msg = "Card successfully loaded";
		} else {
			bool_success = false;
			str_next_url = "TraH.html";
			str_msg = "!! No Card Loaded !!";
		}

		// System.out.println(str_json_events);
		JsonArrayBuilder jsArrayBuilder = Json.createArrayBuilder();
		for (Card card : list_card) {
			jsArrayBuilder.add(Json.createObjectBuilder().add("Card Number", card.getCardno())
					.add("Expiry Date", card.getEdate()).add("CVV", card.getCvv()).add("Card Name", card.getCname())
					.add("Event Number", card.getEnumb()).add("Event Name", card.getEname()));
		}
		JsonArray jsArray = jsArrayBuilder.build();

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).add("list_card", jsArray).build();
		str_json = jsonObj.toString();
		System.out.println(str_json);

		out.print(str_json);
		out.flush();
		out.close();
	}
}