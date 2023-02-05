package allc;

public class festival {
	String name;
	String time;
	String place;
	String historyfi;


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getHistoryfi() {
		return historyfi;
	}

	public void setHistoryfi(String historyfi) {
		this.historyfi = historyfi;
	}
	public void festival(String name, String time, String place, String historyfi)
    {
        this.name = name;
        this.time = time;
        this.place = place;
        this.historyfi = historyfi;
    }
}
