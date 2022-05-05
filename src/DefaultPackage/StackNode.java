package DefaultPackage;

import javafx.scene.Parent;

public class StackNode {
	private Parent root;
	private StackNode next;
	
	public StackNode(Parent root) {
		this.root=root;
		this.next=null;
	}

	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public StackNode getNext() {
		return next;
	}

	public void setNext(StackNode next) {
		this.next = next;
	}
	
	
}
