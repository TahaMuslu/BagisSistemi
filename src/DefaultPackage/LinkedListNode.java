package DefaultPackage;

public class LinkedListNode {
	
	private Donations donate;
	private LinkedListNode next;
	
	public LinkedListNode(Donations donate) {
		this.donate=donate;
		next=null;
	}

	public Donations getDonate() {
		return donate;
	}

	public void setDonate(Donations donate) {
		this.donate = donate;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	

}
