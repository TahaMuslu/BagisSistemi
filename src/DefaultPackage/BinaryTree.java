package DefaultPackage;

import java.util.ArrayList;

public class BinaryTree {
	
	BinaryTreeNode root;
	
	 
    public BinaryTree() {
    	root = null;
    	start();
    	}
    
    public ArrayList<Requests> executeQuery(String query) {
    	BinaryTreeNode current = root;
    	for(int i=0;i<query.length();i++) {
    		current=execute1(query.charAt(i), current);
    	}
		return current.getRequests();
    }
    
    public BinaryTreeNode execute1(char x,BinaryTreeNode node) {
    	if(Character.getNumericValue(x)==1) 
    		return node.right;
    	else
    		return node.left;
    	
    }
    
    public void start() {
    	int i;
    	Requests current;
    	Queue queue = MySqlHelper.sqlPullRequests();
    	root = new BinaryTreeNode("-1");
    	for(i=0;i<queue.elementCount();i++) {
    		root.getRequests().add(queue.get(i).getRequest());
    	}
    	
    	root.right= new BinaryTreeNode("1");
    	root.left=new BinaryTreeNode("0");
    	
    	root.right.right=new BinaryTreeNode("11");
    	root.right.left=new BinaryTreeNode("10");
    	root.left.right=new BinaryTreeNode("01");
    	root.left.left=new BinaryTreeNode("00");
    	
    	root.right.right.right=new BinaryTreeNode("111");
    	root.right.left.right=new BinaryTreeNode("101");
    	root.left.right.right=new BinaryTreeNode("011");
    	root.left.left.right=new BinaryTreeNode("001");
    	root.right.right.left=new BinaryTreeNode("110");
    	root.right.left.left=new BinaryTreeNode("100");
    	root.left.right.left=new BinaryTreeNode("010");
    	root.left.left.left=new BinaryTreeNode("000");
    	
    	
    	for(i=0;i<root.getRequests().size();i++) {
    		current = root.getRequests().get(i);
    		if(current.getRequestAmount()>1000) {
    			root.right.getRequests().add(current);
    		}
    		root.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.right.getRequests().size();i++) {
    		current=root.right.getRequests().get(i);
    		if(Integer.parseInt(""+current.getRequestDate().charAt(6))<4) {
    			root.right.right.getRequests().add(current);
    		}
    		root.right.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.left.getRequests().size();i++) {
    		current=root.left.getRequests().get(i);
    		if(Integer.parseInt(""+current.getRequestDate().charAt(6))<4) {
    			root.left.right.getRequests().add(current);
    		}
    		root.left.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.right.right.getRequests().size();i++) {
    		current=root.right.right.getRequests().get(i);
    		if(current.getRequestStatus().equals("Kabul Edildi")) {
    			root.right.right.right.getRequests().add(current);
    		}
    		root.right.right.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.right.left.getRequests().size();i++) {
    		current=root.right.left.getRequests().get(i);
    		if(current.getRequestStatus().equals("Kabul Edildi")) {
    			root.right.left.right.getRequests().add(current);
    		}
    		root.right.left.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.left.right.getRequests().size();i++) {
    		current=root.left.right.getRequests().get(i);
    		if(current.getRequestStatus().equals("Kabul Edildi")) {
    			root.left.right.right.getRequests().add(current);
    		}
    		root.left.right.left.getRequests().add(current);
    	}
    	
    	for(i=0;i<root.left.left.getRequests().size();i++) {
    		current=root.left.left.getRequests().get(i);
    		if(current.getRequestStatus().equals("Kabul Edildi")) {
    			root.left.left.right.getRequests().add(current);
    		}
    		root.left.left.left.getRequests().add(current);
    	}
    	

    	
    }

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	
    
    
}
