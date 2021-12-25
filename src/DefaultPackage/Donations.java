package DefaultPackage;

import java.util.ArrayList;

public class Donations {
	
	public static ArrayList<String> currentDonate = new ArrayList<String>();
	private int donate_id;
	private int user_id;
	private double donateAmount;
	private String donationType;
	private static double donationPool;
	
	
	
	public Donations(int donate_id, int user_id, double donateAmount, String donationType) {
		super();
		this.donate_id = donate_id;
		this.user_id = user_id;
		this.donateAmount = donateAmount;
		this.donationType = donationType;
	}
	public double getDonateAmount() {
		return donateAmount;
	}
	public void setDonateAmount(double donateAmount) {
		this.donateAmount = donateAmount;
	}
	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}
	public static double getDonationPool() {
		return donationPool;
	}
	public static void setDonationPool(double donationPool) {
		Donations.donationPool = donationPool;
	}
	public int getDonate_id() {
		return donate_id;
	}
	public void setDonate_id(int donate_id) {
		this.donate_id = donate_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
			
	
	
//	public void donate(double amount,int cardId) {
//		
//	}
//	
//	
//	public void donate(double amount,int cardId,String donateType) {
//		
//	}
//	
//	
//	public void donateInfo(int donateId) {
//		
//		
//	}
	
	
	
	

}
