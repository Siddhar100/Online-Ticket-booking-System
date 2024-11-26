package model;

public class Transaction {
    private String transaction_id;
    private String transaction_date;
    private int transaction_amount;
    private String transaction_reason;
    private String transaction_status;
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getTransaction_reason() {
		return transaction_reason;
	}
	public void setTransaction_reason(String transaction_reason) {
		this.transaction_reason = transaction_reason;
	}
	public String getTransaction_status() {
		return transaction_status;
	}
	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}
    
}
