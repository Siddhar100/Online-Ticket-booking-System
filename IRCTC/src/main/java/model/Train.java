package model;

public class Train {
    private String train_no;
    private String departed_form;
    private String reached_to;
    private int fare;
    private String date;
	public String getTrain_no() {
		return train_no;
	}
	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}
	public String getDeparted_form() {
		return departed_form;
	}
	public void setDeparted_form(String departed_form) {
		this.departed_form = departed_form;
	}
	public String getReached_to() {
		return reached_to;
	}
	public void setReached_to(String reached_to) {
		this.reached_to = reached_to;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
}
