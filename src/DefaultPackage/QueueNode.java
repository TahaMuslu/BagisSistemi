package DefaultPackage;

public class QueueNode {
	private Requests request;
	private QueueNode next;
		
	public QueueNode(Requests request) {
		this.request=request;
		this.next=null;
	}

	public Requests getRequest() {
		return request;
	}

	public void setRequest(Requests request) {
		this.request = request;
	}

	public QueueNode getNext() {
		return next;
	}

	public void setNext(QueueNode next) {
		this.next = next;
	}

	
	
}
