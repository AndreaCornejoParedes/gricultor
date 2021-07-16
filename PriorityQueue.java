public class PriorityQueue <E extends Comparable<E>>{
	protected ListLinked<E> queue;
	
	PriorityQueue(){
		queue = new ListLinked<E>();
	}
	public boolean isEmpty() {
		return queue.isEmptyList();
	}
	public void enqueue(E data) {
		queue.insertFirst(data);
	}
	
	public E dequeue() {
		E menor = null;
		if(!this.isEmpty()) {
			menor=queue.getFirst().getData();
			for(Node<E> aux=queue.getFirst().getNext();aux!=null;aux=aux.getNext()) {
				if(menor.compareTo(aux.getData())>0) {
					menor =aux.getData();
				}
				
			}
			queue.remove(menor);
		}
		return menor;
	}
}