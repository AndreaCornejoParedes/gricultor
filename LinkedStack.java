
public class LinkedStack<E>  implements Stack<E>{
	private Node<E> tope;
	public LinkedStack() {
		this.tope=null;
	}
	public void push(E x) {
		this.tope=new Node <E> (x,this.tope);
	}
	public E pop() throws ExceptionIsEmpty{
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Stack is empty...");
		else {
			E auxE=this.tope.getData();
			this.tope=this.tope.getNext();
			return auxE;
		}
		
	}
	public E top() throws ExceptionIsEmpty{
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Stack is empty...");
		else {			
			return tope.getData();
		}
	}
	public boolean isEmpty() {
		return this.tope==null;
	}
	public String toString() {
		String str="";
		Node<E> auxNode=this.tope;
		for (int i=0;auxNode!=null;auxNode=auxNode.getNext(),i++)
			str+="["+i+"]"+"\t"+auxNode.getData()+"\n";
		return str;
	}
	
	
}
