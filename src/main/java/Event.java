public class Event {
	private String evtNum;
	private String evtName;
	private String coord;
	private String coordnum;
	private String fee;
	private String venue;
	private String edate;

	public Event(String evtNum, String evtName, String coord, String coordnum, String fee, String venue, String edate) {
		super();
		this.evtNum = evtNum;
		this.evtName = evtName;
		this.coord = coord;
		this.coordnum = coordnum;
		this.fee = fee;
		this.venue = venue;
		this.edate = edate;
	}

	public String getEvtNum() {
		return evtNum;
	}

	public void setEvtNum(String evtNum) {
		this.evtNum = evtNum;
	}

	public String getEvtName() {
		return evtName;
	}

	public void setEvtName(String evtName) {
		this.evtName = evtName;
	}

	public String getCoord() {
		return coord;
	}

	public void setCoord(String coord) {
		this.coord = coord;
	}

	public String getCoordnum() {
		return coordnum;
	}

	public void setCoordnum(String coordnum) {
		this.coordnum = coordnum;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
}