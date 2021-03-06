import java.util.ArrayList;

public class ListLinked <T> implements TDAList<T>{
	private Node<T> first;
	private int count;
	public ListLinked() {
		this.first = null;
		this.count=0;
	}
	
	
	public boolean isEmptyList() {
		return this.first==null;
	}
	public T searchData(T Data) {
		Node<T> nodo = this.first;
		while(nodo != null && !nodo.getData().equals(Data)) {
			nodo = nodo.getNext();
		}
		if(nodo != null) {
			return nodo.getData();
		}
		return null;
	}

	public int length() {
		return this.count;
	}


	public void destroyList() {
		while(this.first!=null)
			this.first=this.first.getNext();	
		this.count=0;
	}


	public int search(T x) {
		Node<T> auxNode=this.first;
		for(int i=0;auxNode!=null;auxNode=auxNode.getNext(),i++)
			if(auxNode.getData().equals(x))
				return i;
		return -1;
	}
	public T search(int x) {
		Node<T> auxNode=this.first;
		int count = 0;
		for(int i=0;auxNode!=null;auxNode=auxNode.getNext(),i++) {
			if(count == x) {
				return auxNode.getData();
			}
			count++;
		}
		return null;
	}

	
	public void insertLast(T x) {
		if(this.isEmptyList())
			this.insertFirst(x);
		else {
			Node<T> lastNode=getLastNode();
			lastNode.setNext(new Node<T>(x));
			this.count++;
		}
	}
	private Node<T> getLastNode(){
		Node<T> auxNode=this.first;
		while(auxNode.getNext()!=null)
			auxNode=auxNode.getNext();
		return auxNode;
	}


	public void insertFirst(T x) {
		this.first= new Node<T>(x,this.first);
		this.count++;
		
	}
	public void showNode(T x) {
		int pos=this.search(x);
		int i=0;
		Node<T> auxNode=this.first;
		if(auxNode.getData().equals(x)) {
			System.out.println(auxNode);
			return;
		}else if (pos!= -1) {			
			while(i<pos-1) {
				auxNode=auxNode.getNext();
				i++;
			}
			System.out.println(auxNode);
		}
	}

	/*
	public void remove(T x) {		
		int pos=this.search(x);
		int i=0;
		Node<T> auxNode=this.first;
		if(auxNode.getData().equals(x)) {
			this.first=this.first.getNext();
			this.count--;
			return;
		}else if (pos!= -1) {			
			while(i<pos-1) {
				auxNode=auxNode.getNext();
				i++;
			}
			auxNode.setNext(auxNode.getNext().getNext());
			this.count--;
		}
		else {
			System.out.println("No se encuentra el elemento...");
		}		
	}
	*/
	public void remove(T x) {
		if(this.isEmptyList())
			System.out.println("La lista se encuentra vacia...");
		else if(this.first.getData().equals(x)){
			this.first= first.getNext();
			this.count--;
		}
		else {
			
			Node <T> prevNode=this.first;
			Node <T> aux= prevNode.getNext();
			while(aux.getNext() !=null && !(aux.getData().equals(x))) {
				prevNode= prevNode.getNext();
				aux= aux.getNext();
			}
			prevNode.setNext(aux.getNext());
			this.count--;
			
		}
		
	}
	
	
	
	
	public String toString() {
		String str="";
		Node<T> auxNode=this.first;
		for (int i=0;auxNode!=null;auxNode=auxNode.getNext(),i++)
			//str+="["+i+"]"+"\t"+auxNode.getData()+"\n";
			str+=" "+auxNode.getData();
		return str;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	}


