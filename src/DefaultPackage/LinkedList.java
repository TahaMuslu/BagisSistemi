package DefaultPackage;

public class LinkedList {
	
	private LinkedListNode head=null;
	
	
	public void addLast(Donations donate) {
		if(head==null) {
			head=new LinkedListNode(donate);
		}
			else {
				LinkedListNode current;
				current=head;
				LinkedListNode newNode = new LinkedListNode(donate);
				while(current.getNext()!=null) {
					current=current.getNext();
				}
				current.setNext(newNode);
			}
	}
	
	
	public void addFront(Donations donate) {
		if(head==null)
			head=new LinkedListNode(donate);
			else {
				LinkedListNode newNode = new LinkedListNode(donate);
				newNode.setNext(head);
				head=newNode;
			}
	}
	
	
	public int elementCount() {
		LinkedListNode current = head;
		int count=0;
		while(current!=null) {
		count++;
		current=current.getNext();
		}
		return count;
	}
	
	
	public Donations delete(Donations donate) {
		LinkedListNode current = head;
		LinkedListNode oldNode = null;
		if(head.getDonate()==donate) {
			oldNode = new LinkedListNode(head.getDonate());
			head=head.getNext();
			return oldNode.getDonate();
		}
		while(current.getNext()!=null) {
			if(current.getNext().getDonate()==donate){
				oldNode = new LinkedListNode(current.getNext().getDonate());
				current.setNext(current.getNext().getNext());
				break;
			}
			current=current.getNext();
		}
		return oldNode.getDonate();
	}
	
	
	public Donations delete(int index) {
		LinkedListNode current = head;
		LinkedListNode oldNode = null;
		int count=1;
		
		if(index==0) {
		oldNode = new LinkedListNode(head.getDonate());
		head=head.getNext();
		return oldNode.getDonate();
		}
		
		while(current.getNext()!=null) {
			if(count==index) {
				oldNode = new LinkedListNode(current.getNext().getDonate());
				current.setNext(current.getNext().getNext());
				return oldNode.getDonate();
			}
			count++;
			current=current.getNext();
		}
		return null;
	}
	
	
	public Donations get(int index) {
		LinkedListNode current = head;
		int count=0;		
		while(current!=null) {
			if(count==index) {
				return current.getDonate();
			}
			count++;
			current=current.getNext();
		}
		return null;
	}
	
}