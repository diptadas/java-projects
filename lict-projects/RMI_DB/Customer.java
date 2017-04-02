public class Customer implements java.io.Serializable{
	private int acc_no;
	private String firstname,lastname;
	private float amount;

	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int accNo) {
		acc_no = accNo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
