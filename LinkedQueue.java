public class LinkedQueue <E> implements Queue<E>{
	private Node<E> frontNode;
	private Node<E> backNode;
	
	public  LinkedQueue() {
		this.frontNode=null;
		this.backNode=null;
	}
	/*
	public boolean isFull() {
		return this.nElemen==this.array.length;
	}*/
	public void enqueue(E x) {
		Node<E> nuevoNode=new Node<E>(x);
		if(this.isEmpty()) {
			this.frontNode=nuevoNode;
		}else 
			this.backNode.setNext(nuevoNode);
		this.backNode=nuevoNode;
		
	
	}

	public E dequeue() throws ExceptionIsEmpty {
		if (this.isEmpty()) 
			throw new ExceptionIsEmpty("No se puede remover de una cola vacia");
		E auxE= this.frontNode.getData();
		this.frontNode=this.frontNode.getNext();
		if(this.frontNode==null)
			this.backNode=null;
		return auxE;
	}
	
	public E front() throws ExceptionIsEmpty {
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Stack is empty...");
		else {			
			return frontNode.getData();
		}
	}
	
	public E back() throws ExceptionIsEmpty {
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Stack is empty...");
		else {			
			return backNode.getData();
		}
	}
	
	public boolean isEmpty() {
		return this.frontNode==null;
	}
}
