
public class Vertex<E> implements Comparable<Vertex<E>> {
	private E data;
	protected ListLinked<Edge<E>> listAdj;
	protected int label;
	protected int dist;
	protected Vertex<E> path;
	private String state;
	
	public Vertex(E data) {
		this.data = data;
		listAdj = new ListLinked<Edge<E>>();
		this.state = "Unexplored";
	}
	public String getState() {
		return this.state;
	}
	public void changeState() {
		this.state = "Explored";
	}
	public E getData() {
		return data;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Vertex<?>) {
			Vertex<E> v = (Vertex<E>)o;
			return this.data.equals(v.data);
		}
		return false;
	}
	public ListLinked<Edge<E>> getlistAdj(){
		return this.listAdj;
	}
	public String toString() {
		return this.data + " --> " +this.listAdj.toString()+"\n";
	}
	@Override
	public int compareTo(Vertex<E> v) {
		return this.dist-v.dist;
	}
	
}


