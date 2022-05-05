package DefaultPackage;

import java.util.ArrayList;

public class BinaryTreeNode {
	
	private ArrayList<Requests> requests = new ArrayList<Requests>();
	private String filter;
	BinaryTreeNode right,left;
	
	
	public BinaryTreeNode(String filter) {
		this();
		this.filter=filter;
	}
	
	public BinaryTreeNode() {
		
	}

	public ArrayList<Requests> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<Requests> requests) {
		this.requests = requests;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	

}
