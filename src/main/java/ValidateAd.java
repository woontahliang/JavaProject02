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
 * Servlet implementation class ValidateAd
 */
@WebServlet("/ValidateAd")
public class ValidateAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateAd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contentType = request.getContentType();
		System.out.println(contentType);

		String un = request.getParameter("Ausername"); // Fetch username
		String pw = request.getParameter("Apassword"); // Fetch password

		un = (un != null && un.trim().isEmpty()) ? null : un.trim();
		pw = (pw != null && pw.trim().isEmpty()) ? null : pw.trim();

		// Sets of Admin usernames & passwords
		String u1 = "A101";
		String p1 = "1234";

		String u2 = "A102";
		String p2 = "5678";

		String u3 = "A103";
		String p3 = "ABCD";

		String u4 = "A104";
		String p4 = "abcd";

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObj = null;
		boolean bool_success = false;
		String str_next_url = null;
		String str_msg = null;
		String str_json = null;

		// if-else ladder to check entries
		if (pw != null && un != null) {
			if (pw.equals(p1) && un.equals(u1) || (pw.equals(p2) && un.equals(u2)) || (pw.equals(p3) && un.equals(u3))
					|| (pw.equals(p4) && un.equals(u4))) {
				bool_success = true;
				str_next_url = "AdminEvent.html";
				str_msg = "Successful Adminstrator Login";
			}
			// Credentials incorrect stay on that page only
			else {
				bool_success = false;
				str_next_url = "Alogin.html";
				str_msg = "!! Please Enter Valid Username & Password for Admin !!";
			}
		} // Credentials incorrect stay on that page only
		else {
			bool_success = false;
			str_next_url = "Alogin.html";
			str_msg = "!! Username & Password cannot be null !!";
		}

		jsonObj = Json.createObjectBuilder().add("success", bool_success).add("next_url", str_next_url)
				.add("msg", str_msg).build();
		str_json = jsonObj.toString();

		out.print(str_json);
		out.flush();
		out.close();
	}
}