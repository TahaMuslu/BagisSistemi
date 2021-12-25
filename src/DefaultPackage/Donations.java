package DefaultPackage;

import java.util.ArrayList;

public class Donations {
	
	private double donateAmount;
	private String donationType;
	private static double donationPool;
	
	
	
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
