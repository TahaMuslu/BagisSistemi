package DefaultPackage;

import java.util.ArrayList;

public class Donor extends User{
	
	private String donorName;
	private Card card = new Card();
	private ArrayList<Donations> donationsMade = new ArrayList<Donations>();
	private static int donorOfNumbers=0;
	
	
	
	@Override
	public void register() {
		// TODO Auto-generated method stub
		super.register();
	}
	
	
	
	
	
}
