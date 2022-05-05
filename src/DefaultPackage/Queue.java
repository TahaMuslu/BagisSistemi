package DefaultPackage;

public class Queue {
	
	private QueueNode front;
	private QueueNode rear;
	
	public Queue(){
		front=null;
		rear=null;
	}
	
	public Requests peek() {
		return front.getRequest();
	}
	
	
	public Requests pop() {
		if(front==null)
			return null;
		QueueNode old = front;
		front=front.getNext();
		if(front==null)
			rear=null;
		return old.getRequest();
	}
	
	public void push(Requests request) {
		QueueNode newNode = new QueueNode(request);
		if(this.rear==null) {
		front=newNode;
		rear=newNode;
		}
		else {
		rear.setNext(newNode);
		rear=newNode;
		}
	}
	
	public void clear() {
		front=null;
		rear=null;
	}
	
	public boolean isEmpty() {
		if(front==null && rear==null)
			return true;
		else
			return false;
	}
	
	public Requests find(int requestId) {
		QueueNode current = front;
		while(current!=null) {
			if(current.getRequest().getRequestId()==requestId)
				return current.getRequest();
			current=current.getNext();
		}
		return null;
	}

	
	public int elementCount() {
		QueueNode current = front;
		int counter = 0;
		while(current!=null) {
			counter++;
			current=current.getNext();
		}
		return counter;
	}
	
	public QueueNode get(int i) {
		QueueNode current = front;
		int counter = 0;
		while(current!=null) {
			if(counter==i)
				return current;
			counter++;
			current=current.getNext();
		}
		return null;
		
	}
	
	
}
