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
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		String a1 = request.getParameter("cardno");
		String a2 = request.getParameter("edate");
		String a3 = request.getParameter("cvv");
		String a4 = request.getParameter("cname");
		String a5 = request.getParameter("enum");
		String a6 = request.getParameter("ename");

		a1 = (a1 != null && a1.trim().isEmpty()) ? null : a1.trim();
		a2 = (a2 != null && a2.trim().isEmpty()) ? null : a2.trim();
		a3 = (a3 != null && a3.trim().isEmpty()) ? null : a3.trim();
		a4 = (a4 != null && a4.trim().isEmpty()) ? null : a4.trim();
		a5 = (a5 != null && a5.trim().isEmpty()) ? null : a5.trim();
		a6 = (a6 != null && a6.trim().isEmpty()) ? null : a6.trim();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;

		if (a1 != null && a2 != null && a3 != null && a4 != null && a5 != null && a6 != null) {
			try {
				bool_success = EventManagementDAO.addParticipantRegistration(a1, a2, a3, a4, a5, a6);
				str_next_url = "Payment.html";
				str_msg = "New participant registration added";
			} catch (Exception exe) {
				bool_success = false;
				str_next_url = "Registration.html";
				str_msg = "!! " + exe + " !!";
				System.out.println(exe);
			}
		} else {
			bool_success = false;
			str_next_url = "Registration.html";
			str_msg = "!! Card Number, Expiry Date, CVV, Card Name, Event Number and Event Name cannot be null !!";
		}

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).build();
		str_json = jsonObj.toString();

		out.print(str_json);
		out.flush();
		out.close();
	}
}