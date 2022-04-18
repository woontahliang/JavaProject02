public class Card {
	private String cardno;
	private String edate;
	private String cvv;
	private String cname;
	private String enumb;
	private String ename;

	public Card(String cardno, String edate, String cvv, String cname, String enumb, String ename) {
		super();
		this.cardno = cardno;
		this.edate = edate;
		this.cvv = cvv;
		this.cname = cname;
		this.enumb = enumb;
		this.ename = ename;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEnumb() {
		return enumb;
	}

	public void setEnumb(String enumb) {
		this.enumb = enumb;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
}
