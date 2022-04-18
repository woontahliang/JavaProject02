import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventManagementDAO {
	public static boolean validate(String User_name, String Pass_word) {
		boolean status = false;
		Connection con = MySQLDBConnector.getDbConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from plogindeatils where User_name=? and Pass_word=?");
			ps.setString(1, User_name);
			ps.setString(2, Pass_word);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static boolean addParticipant(String username, String password, String name) throws SQLException {

		Connection con = MySQLDBConnector.getDbConnection();

		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int count = 0;
		boolean status = false;
		// SQL statement
		String Qs = "insert into plogindeatils values('" + username + "','" + password + "','" + name + "') ";
		count = stmt.executeUpdate(Qs);
		if (count == 1) {
			status = true;
		}
		con.close();

		System.out.println("Rows inserted: " + count);
		return status;
	}

	public static boolean addParticipantRegistration(String cardno, String edate, String cvv, String cname,
			String evtnum, String ename) throws SQLException {

		Connection con = MySQLDBConnector.getDbConnection();

		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int count = 0;
		boolean status = false;
		// SQL statement
		String Qs = "insert into card values('" + cardno + "','" + edate + "','" + cvv + "','" + cname + "','" + evtnum
				+ "','" + ename + "') ";
		count = stmt.executeUpdate(Qs);
		if (count == 1) {
			status = true;
		}
		con.close();

		System.out.println("Rows inserted: " + count);
		return status;
	}

	public static List<Event> getAllEvents() {
		// String str_json_events = null;
		Connection con = MySQLDBConnector.getDbConnection();
		List<Event> list_event = new ArrayList<Event>();
		try {
			Statement stmt1 = con.createStatement();
			ResultSet rp = stmt1.executeQuery("select * from Event");
			while (rp.next()) {
				String evtNum = rp.getString("enum");
				String evtName = rp.getString("ename");
				String coord = rp.getString("coord");
				String coordnum = rp.getString("coordnum");
				String fee = rp.getString("fee");
				String venue = rp.getString("venue");
				String edate = rp.getString("edate");
				Event event = new Event(evtNum, evtName, coord, coordnum, fee, venue, edate);
				list_event.add(event);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (!list_event.isEmpty()) {
//			Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true));
//			str_json_events = jsonb.toJson(list_event);
//		}

		return list_event;
	}

	public static List<Card> getAllCards() {
		Connection con = MySQLDBConnector.getDbConnection();
		List<Card> list_card = new ArrayList<Card>();
		try {
			Statement stmt1 = con.createStatement();
			ResultSet rp = stmt1.executeQuery("select * from card");
			while (rp.next()) {
				String cardno = rp.getString("cardno");
				String edate = rp.getString("edate");
				String cvv = rp.getString("cvv");
				String cname = rp.getString("cname");
				String enumb = rp.getString("enum");
				String ename = rp.getString("ename");
				Card card = new Card(cardno, edate, cvv, cname, enumb, ename);
				list_card.add(card);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list_card;
	}

	public static boolean addEvent(String EventNo, String EventName, String coordinatorName, String CoordinatorNo,
			String fee, String venue, String date) throws SQLException {

		Connection con = MySQLDBConnector.getDbConnection();

		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int count = 0;
		boolean status = false;
		// SQL statement
		String Qs = "insert into Event values('" + EventNo + "','" + EventName + "','" + coordinatorName + "','"
				+ CoordinatorNo + "','" + fee + "','" + venue + "','" + date + "') ";
		count = stmt.executeUpdate(Qs);
		if (count == 1) {
			status = true;
		}
		con.close();

		System.out.println("Rows inserted: " + count);
		return status;
	}
}