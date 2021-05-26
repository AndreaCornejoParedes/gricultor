import BSTree.Node;

public class BSTree<E extends Comparable <E>> {
	class Node{
		protected E data;
		protected Node left, right;
		public Node(E data) {
			this (data,null,null);
		}
		public Node(E data,Node left,Node right) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	private Node rootNode;
	public BSTree(){
		this.rootNode=null;
	}
	public boolean isEmpty() {
		return this.rootNode==null;
	}
	public void insert(E x) throws ItemDuplicated{
		this.rootNode=insertRec(x, this.rootNode);
	}
	private Node insertRec(E x,Node actual) throws ItemDuplicated{
		Node res=actual;
		if(actual==null) {
			res=new Node(x);
		}else {
			int resC=actual.data.compareTo(x);
			if(resC==0)
				throw new ItemDuplicated("El dato "+x+" ya se encontraba en el arbol...");
			if(resC<0) res.right=insertRec(x, actual.right);
			else res.left=insertRec(x, actual.left);
		}
		return res;
	}
	public E search(E x)throws ItemNoFound {
		Node resp=searchRec(x,this.rootNode);
		if (resp==null)
			throw new ItemNoFound("El dato"+x+"no se encuentra...");
		return resp.data;
	}
	public Node searchRec(E x, Node actual)throws ItemNoFound {
		if (actual==null)
			return null;
		else {
			int resC=actual.data.compareTo(x);
			if (resC<0)			return searchRec(x, actual.right);
			else if (resC>0)	return searchRec(x, actual.left);
			else return actual;
			
		}
		
	}
	public Node remove(E x)throws ItemNoFound{
		return this.rootNode=removeRec(x, rootNode);
		
	}
	public Node removeRec(E x,Node actual)throws ItemNoFound{
		Node res=actual;
		if(actual==null) {
			throw new ItemNoFound("El dato"+x+"no se encuentra...");
		}else {
			int resC=actual.data.compareTo(x);	
			if(resC<0) res.right=removeRec(x, actual.right);
			else if(resC>0) res.left=removeRec(x, actual.left);
			else {
				if(actual.left!=null&&actual.right!=null)
					System.out.println("Caso 3");
				else {
					res=(actual.left!=null)? actual.left:actual.right;
				}
			}
		}
		return res;
	}
	
	public String toString() {
		return "BSTree [rootNode=" + rootNode + "]";
	}
	public void inOrden() {
		if(this.isEmpty())
			System.out.println("El arbol esta vacio...");
		else {
			inOrden(this.rootNode);
		System.out.println();
		}
	}
	protected void inOrden(Node actual) {
		if(actual.left!=null)inOrden(actual.left);
		System.out.println(actual.data.toString()+" ,");
		if(actual.right!=null)inOrden(actual.right);
	}
	
}
