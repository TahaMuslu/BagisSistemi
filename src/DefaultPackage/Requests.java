package DefaultPackage;

import java.util.Date;

public class Requests {
	
	private int requestId;
	private String requestDate;
	private String requestType;
	private String requestDetails;
	private int requestIban;
	private String requestStatus;
	private int userId;
	private double requestAmount;
	
	public static int currentRequestId;
	
	private static int requestOfNumbers=0;
	
	
	

	public Requests(int requestId, String requestDate, double requestAmount) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestAmount = requestAmount;
	}

	public Requests(int requestId, String requestDate, String requestType, String requestDetails, int requestIban,
			String requestStatus, int userId, double requestAmount) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestType = requestType;
		this.requestDetails = requestDetails;
		this.requestIban = requestIban;
		this.requestStatus = requestStatus;
		this.userId = userId;
		this.requestAmount = requestAmount;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	public int getRequestIban() {
		return requestIban;
	}

	public void setRequestIban(int requestIban) {
		this.requestIban = requestIban;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(int requestAmount) {
		this.requestAmount = requestAmount;
	}

	public static int getRequestOfNumbers() {
		return requestOfNumbers;
	}

	public static void setRequestOfNumbers(int requestOfNumbers) {
		Requests.requestOfNumbers = requestOfNumbers;
	}
	
	

}
