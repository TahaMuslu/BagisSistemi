package DefaultPackage;

import javafx.scene.Parent;

public class Stack {
	private static StackNode head;
	
	
	public Stack() {
		head=null;
	}
	
	public static void push(Parent root) {
		StackNode oldNode = head;
		head = new StackNode(root);
		head.setNext(oldNode);
	}
	
	public static Parent pop() {
		if(head==null)
			return null;
		else {
			Parent oldRoot = head.getRoot();
			head=head.getNext();
			return oldRoot;
		}
		
	}
	
	public static Parent peek() {
		if(head!=null)
		return head.getRoot();
		else
			return null;
	}
	
	public static void clear() {
		head=null;
	}
	
	public static boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;	
	}
	

}
