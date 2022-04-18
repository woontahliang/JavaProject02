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
@WebServlet("/StoreP")
public class StoreP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetching data from Psignup.html from user
		String a1 = request.getParameter("Pusername");
		String a2 = request.getParameter("Ppassword");
		String a3 = request.getParameter("Cpassword");
		String a4 = request.getParameter("Pname");

		a1 = (a1 != null && a1.trim().isEmpty()) ? null : a1.trim();
		a2 = (a2 != null && a2.trim().isEmpty()) ? null : a2.trim();
		a3 = (a3 != null && a3.trim().isEmpty()) ? null : a3.trim();
		a4 = (a4 != null && a4.trim().isEmpty()) ? null : a4.trim();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;

		if (a1 != null && a2 != null && a3 != null && a4 != null) {
			if (a2.equals(a3)) {
				try {
					bool_success = EventManagementDAO.addParticipant(a1, a2, a4);
					str_next_url = "Plogin.html";
					str_msg = "New participant added";
				} catch (java.sql.SQLIntegrityConstraintViolationException exe) {
					bool_success = false;
					str_next_url = "Psignup.html";
					str_msg = "!! " + "User name \"" + a1 + "\" is in use. Please try another user name." + " !!";
					System.out.println(exe);
				} catch (Exception exe) {
					bool_success = false;
					str_next_url = "Psignup.html";
					str_msg = "!! " + exe + " !!";
					System.out.println(exe);
				}
			} else {
				bool_success = false;
				str_next_url = "Psignup.html";
				str_msg = "!! Password and Confirm Password must be the same !!";
			}
		} else {
			bool_success = false;
			str_next_url = "Psignup.html";
			str_msg = "!! Name, Username, Password and Confirm Password cannot be null !!";
		}

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).build();
		str_json = jsonObj.toString();

		out.print(str_json);
		out.flush();
		out.close();
	}
}