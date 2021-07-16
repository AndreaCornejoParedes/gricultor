

public class Edge<E>{
	private Vertex<E> refDest;
	private int weight;
	private String state;
	
	public Edge(Vertex<E> refDest) {
		this(refDest,-1);
	}
	public Vertex<E> getRefDest(){
		return this.refDest;
	}
	public int getWeight() {
		return this.weight;
	}
	public Edge(Vertex<E> refDest, int weight) {
		this.refDest = refDest;
		this.weight = weight;
		this.state = "Unexplored";
	}
	public void changeState(int e) {
		if(e == 1) {
			this.state = "Explored";
		}
		else if(e == 2){
			this.state = "Back";
		}
		else {
			System.out.print("ERROR");
		}
	}
	public String getState() {
		return this.state;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Edge<?>) {
			Edge<E> e = (Edge<E>)o;
			return this.refDest.equals(e.refDest);
		}
		return false;
	}
	public String toString() {
		if(this.weight > -1)
			return refDest.getData()+ " [" + this.weight+"], ";
		else
			return refDest.getData()+", ";
	}
}
