package DefaultPackage;

import java.util.Date;

public class Requests {
	
	private int requestId;
	private static int requestOfNumbers=0;
	private String requestType;
	private String requestDetails;
	private int requestIbanNumber;
	private String requestStatus;
	private Date requestDate = new Date();
	
	
	public boolean learnRequestStatus(int requestId) {
		
		return false;
	}
	
	
	public void createRequest() {
		
	}
	
	
	public void listRequests() {
		
	}
	
	
	public void learnRequestDetail(int requestId) {
		
	}
	
	
	public void approveRequest(int requestId) {
		
		
	}
	
	
	public void disapproveRequest(int requestId) {
		
		
	}

}
