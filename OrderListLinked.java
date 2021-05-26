
public class OrderListLinked<T extends Comparable <T>> extends ListLinked<T> {
		
	public OrderListLinked() {
		super();
		
	}
	

	public int search(T x) {
		Node<T> auxNode=this.getFirst();
		int i=0;
		while(auxNode!=null && ((Comparable<T>) auxNode.getData()).compareTo(x)<0) {
			auxNode=auxNode.getNext();
			i++;
		}
		if(auxNode!=null && auxNode.getData().equals(x))
			return i;
		return -1;
		
	}

	
	public void insertNode (T x) {
		Node<T> auxNode =null;
		Node<T> temp = new Node<T>(x);
		if(this.isEmptyList()||(this.getFirst().getData().compareTo(x) > 0))		{	
			this.insertFirst(x);
			return;}		 			
		 for(auxNode =this.getFirst(); auxNode.getNext() != null; auxNode = auxNode.getNext()) {
	            if(auxNode.getNext().getData().compareTo(x) > 0) {
	            	temp.setNext(auxNode.getNext());
	            	auxNode.setNext(temp);
	            	this.setCount(getCount()+1);
	              return;
	            }
	        }
	        auxNode.setNext(temp);
	        this.setCount(getCount()+1);
	    }
		
	public void remove(T x) {		

		Node<T> auxNode=this.getFirst();		
		if(auxNode.getData().equals(x)) {
			this.setFirst(this.getFirst().getNext());
			this.setCount(this.getCount()-1);
			return;
		}else {			
			while(auxNode.getNext()!=null && ((Comparable<T>) auxNode.getNext().getData()).compareTo(x)<0) {
				auxNode=auxNode.getNext();
			}
			auxNode.setNext(auxNode.getNext().getNext());
			this.setCount(getCount()-1);		
		}			
	}
}
