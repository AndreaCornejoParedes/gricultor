import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphLink<E> {
	protected ListLinked<Vertex<E>> listVertex;
	
	public GraphLink() {
		listVertex = new ListLinked<Vertex<E>>();
	}
	
	public void insertVertex(E data) {
		Vertex<E> nuevo = new Vertex<E>(data);
		if(this.listVertex.searchData(nuevo) != null) {
			System.out.println("Vertice ya fue insertado.....");
			return;
		}
		this.listVertex.insertFirst(nuevo);
	}
	public void removeVertex(E x) throws IsNotFound{
		Vertex<E> aux = this.searchVertex(x);
		if (aux == null) {
			throw new IsNotFound("Ese vertex no existe....");
		}
		else {
			Node<Vertex<E>> vertices = this.listVertex.getFirst();
			ListLinked<Vertex<E>> verticesAristas = new ListLinked<Vertex<E>>();
			while(true) {
				//ListLinked<Edge<E>> edges = vertices.getData().listAdj;
				if(this.searchEdge(vertices.getData(), aux) != null) {
					verticesAristas.insertFirst(vertices.getData());
					vertices = vertices.getNext();
				}else {
					if(vertices.getNext() == null) {
						break;
					}else {
						vertices = vertices.getNext();
					}
				}
			}
			
			if(verticesAristas.isEmptyList()) {
				this.listVertex.remove(aux);
			}
			else {
				Node<Vertex<E>> vertexA =  verticesAristas.getFirst();
				while(true) {
					this.removeEdge(vertexA.getData().getData(), aux.getData());
					vertexA = vertexA.getNext();
					if(vertexA == null) {
						break;
					}
					//break;
				}
				this.listVertex.remove(aux);
			}
		}
	}
	
	public boolean removeEdge(E v,E w) {
		Vertex<E> aux = this.searchVertex(v);
		Vertex<E> aux2 = this.searchVertex(w);
		
		if(aux ==null || aux2 ==null) {
			return false;
		}else {
			
			Edge<E> x = this.searchEdge(aux, aux2);
			Edge<E> y = this.searchEdge(aux2, aux);
			if(x == null || y ==null) {
				return false;
			}else {
				aux.listAdj.remove(x);
				aux2.listAdj.remove(y);
				return true;
			}
		}
	}

	public void insertEdge(E verOri, E verDes) {
		this.insertEdge(verOri, verDes, -1);
	}
	
	
	public void insertEdge(E verOri, E verDes,int weight) {
		Vertex<E> refOri=this.listVertex.searchData(new Vertex<E>(verOri));
		Vertex<E> refDes=this.listVertex.searchData(new Vertex<E>(verDes));
		
		if(refOri==null || refDes==null) {
			System.out.println("Vertice origen y/o destino no existen...");
			return;
		}
		
		if(refOri.listAdj.searchData(new Edge<E>(refDes))!=null) {
			System.out.println("Arista ya insertada anteriormente...");
			return;
		}
		refOri.listAdj.insertFirst(new Edge<E>(refDes,weight));
		refDes.listAdj.insertFirst(new Edge<E>(refOri,weight));
	}
	public void bfs(E vertice) {
		Vertex<E> verticeI = this.listVertex.searchData(new Vertex<E>(vertice));
		if(verticeI == null) {
			System.out.println("No existe");
		}
		else {
			this.bfs(verticeI);
		}
	}
	private void bfs(Vertex<E> e) {
		Queue<Vertex<E>> cola = new LinkedQueue<>();
		Vertex<E> aux = e;
		Vertex<E> aux2;
		Queue<Vertex<E>> unexplored;
		e.changeState();
		System.out.println(e.getData());
 		cola.enqueue(e);
 		//unexplored = this.hasUnexploredVertexBFS(aux);
		do {
			if(cola.isEmpty() && this.hasUnexploredVertexBFS(aux).isEmpty()) {
				break;
			}
			unexplored = this.hasUnexploredVertexBFS(aux);
			try {
				
				if(unexplored.isEmpty() ) {
					aux = cola.dequeue();
					//unexplored = this.hasUnexploredVertexBFS(aux);
				}else {
					aux2  = unexplored.dequeue();
					while(true) {
						aux2.changeState();
						System.out.println(aux2.getData());
						cola.enqueue(aux2);
						//aux = aux2;
						if(unexplored.isEmpty()) {
							break;
						}else {
							aux2  = unexplored.dequeue();
						}
					}
				}
				
			}catch(Exception x) {
				System.out.println(x);
			}
			/*
			if(cola.isEmpty() ) {
				break;
			}*/
		}while(true);
	}
	private Queue<Vertex<E>> hasUnexploredVertexBFS(Vertex<E> e){
		Queue<Vertex<E>> unexplored = new LinkedQueue<>();
		ListLinked<Edge<E>> x = e.listAdj;
		Node<Edge<E>>  aux = x.getFirst();
		while(true) {
			Edge<E> edge = aux.getData();
			if(edge.getRefDest().getState() == "Unexplored") {
				unexplored.enqueue(edge.getRefDest());
				aux = aux.getNext();
			}
			if(edge.getRefDest().getState() == "Explored") {
				aux = aux.getNext();
			}
			if(aux == null) {
				break;
			}
		}
		return unexplored;
	}
	public void dfs(E vertice) {
		Vertex<E> verticeI = this.listVertex.searchData(new Vertex<E>(vertice));
		if(verticeI == null) {
			System.out.println("No existe");
		}
		else {
			this.dfs(verticeI);
		}
	}
	private void dfs(Vertex<E> e) {
			Vertex<E> aux = e;
			Vertex<E> aux2;
			Stack<Vertex<E>> pila = new Stack<>();
			pila.add(e);
			e.changeState();
			System.out.println(aux.getData());
			do {
				ListLinked<Edge<E>> edges = aux.listAdj;
				if(edges.isEmptyList()) {
					aux = pila.pop();
				}else {
					//Node<Edge<E>> node = edges.getFirst();
					Edge<E> noExplorated =  this.hasUnexploredVertex(aux);
					if(noExplorated == null) {
						aux2 = pila.pop();
						if(aux == aux2) {
							aux = pila.pop();
						}
					}else {
						noExplorated.changeState(1);
						noExplorated.getRefDest().changeState();
						Edge<E> op = this.searchEdge(noExplorated.getRefDest(),aux);
						op.changeState(1);
						pila.add(noExplorated.getRefDest());
						System.out.println(noExplorated.getRefDest().getData());
						aux = noExplorated.getRefDest();
					}
				}
			}while(!pila.isEmpty());
	}
	private Edge<E> hasUnexploredVertex(Vertex<E> e){
		ListLinked<Edge<E>> x = e.listAdj;
		Node<Edge<E>> aux = x.getFirst();
		while(true) {
			if(aux.getData().getState() == "Unexplored" && aux.getData().getRefDest().getState() == "Explored") {
				aux.getData().changeState(2);
				aux=aux.getNext();
			}
			else if(aux.getData().getState() == "Explored" && aux.getData().getRefDest().getState() == "Explored") {
				aux = aux.getNext();
			}
			else if(aux.getData().getState() == "Unexplored" && aux.getData().getRefDest().getState() == "Unexplored") {
				return aux.getData();
			}
			if (aux == null) {
				return null;
			}
		}
	}
	public ArrayList<Vertex<E>> shortPath(Vertex<E> x,Vertex<E> z){
		return null;
	}
	/*Disktra*/
	public void Dijkstra(E info,E destino) {
		PriorityQueue<Vertex<E>> q= new PriorityQueue<Vertex<E>>();
		Vertex<E> u=this.listVertex.searchData(new Vertex<E>(info));
		Node<Vertex<E>> aux=this.listVertex.getFirst();
		for(;aux!=null;aux=aux.getNext()) {
			if(aux.getData()==u) aux.getData().dist=0;
			else aux.getData().dist=9999;
		aux.getData().path=null;
		aux.getData().label=0;
		q.enqueue(aux.getData());
		}
		while(!q.isEmpty()) {
			u=q.dequeue();
			u.label=1;
			Node<Edge<E>> e =u.listAdj.getFirst();
			for(;e!=null;e=e.getNext()) {
				Vertex<E>z=e.getData().getRefDest();
				if(z.label==0) {
					if(z.dist>(u.dist+e.getData().getWeight())) {
						z.dist=u.dist+e.getData().getWeight();
						z.path=u;
					}
				}
			}
		}
		//return this.printDijkstra(info,destino);
		this.getPath(this.searchVertex(info),this.searchVertex(destino));
	}
	
	public void printDijkstra(E a) {
		Node<Vertex<E>> aux = this.listVertex.getFirst();
		System.out.println("Vertex\tDistancia\tPath");
		for(;aux!=null;aux=aux.getNext()) {
			Vertex<E> ver=aux.getData();
			if(ver.path!=null) System.out.println(ver.getData()+"\t"+ver.dist+"\t"+ver.path.getData());
			else System.out.println(ver.getData()+"\t"+ver.dist+"\t--");
		}
		
		//return this.getPath(this.searchVertex(a),this.searchVertex(b));
	}
	private void getPath(Vertex<E> inicio,Vertex<E> fin) {
		ArrayList<E> path = new ArrayList<E>();
		path.add(fin.getData());
		Vertex<E> aux = fin.path;
		while(aux.getData() != inicio.getData()) {
			path.add(aux.getData());
			aux = aux.path;
		}
		path.add(inicio.getData());
		String p = "";
		for(int i=path.size()-1;i>=0;i--) {
			p += path.get(i)+" -> ";
		}
		
		System.out.println("La ruta recomendada es " + p);
		System.out.print("La distancia es: "+fin.dist);
		//return path;
	}
	
	
	/**
	 * 
	 */
	
	public Vertex<E> searchVertex(E vertex){
		Node<Vertex<E>> aux = this.listVertex.getFirst();
		while(true) {
			if(aux.getData().getData() == vertex) {
				return aux.getData();
			}
			else if(aux.getNext() != null) {
				aux = aux.getNext();
			}
			else {
				break;
			}
		}
		return null;
	}
	public Edge<E> searchEdge(Vertex<E> x,Vertex<E> z){
		ListLinked<Edge<E>> edges = x.listAdj;
		Node<Edge<E>> aux = edges.getFirst();
		while(true) {
			if(aux == null) {
				break;
			}
			Edge<E> data = aux.getData();
			if(data.getRefDest().getData() == z.getData()) {
				return aux.getData();
			}
			else {
				aux = aux.getNext();
			}
		}
		return null;
	}
	
	
	public String toString() {
		return this.listVertex.toString();
	}
	
	
}
