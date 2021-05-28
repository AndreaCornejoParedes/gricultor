
public class CategoriaProducto implements Comparable<CategoriaProducto>{
	private int codCat;
	private String nomCat;
	private ListLinked Productos;
	
	public CategoriaProducto(ListLinked productos) {
		super();
		this.Productos = productos;
	}
	
	public CategoriaProducto() {
		super();
		this.Productos=null;
		this.codCat=0;
		this.nomCat="";
	}
	
	public int getCodCat() {
		return codCat;
	}

	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public ListLinked<Integer> ocurrencias(String x){
		int con=0;
		int arr[] = new int[Productos.length()];
		TDAList <Integer> list=new ListLinked<Integer>();
		Node<Producto> aux=Productos.getFirst();
		for (int i=0;aux!=null;aux=aux.getNext(),i++) {
			if (aux.getData().equals(x)) {
				arr[con]=i;
				con++;
			}
		}
		for(int j=0;j<con;j++) {
			list.insertFirst(arr[j]);
		}
		return (ListLinked<Integer>) list;
	}
//	public ListArray<OrderListLinked<Producto>> clasififcar(float x) {
//	ListArray<OrderListLinked<Producto>> clasificacion = new ListArray<OrderListLinked<ProductoT>>(2);
//	OrderListLinked<Producto> menores = new OrderListLinked<Producto>();
//	OrderListLinked<Producto> mayores = new OrderListLinked<Producto>();
//	Node<Producto> aux = clasificacion.getFirst();
//	while(aux.getNext() != null) {
//		if(aux.getData().compareTo(x) > 0 || aux.getData().compareTo(x) == 0) {
//			mayores.insert(aux.getData());
//		}
//		else {
//			menores.insert(aux.getData());
//		}
//		aux = aux.getNext();
//	}
//	clasificacion.insertFirst(menores);
//	clasificacion.insertLast(mayores);
//	return clasificacion;
//	}
	public int compareTo(CategoriaProducto o) {
		if (this.codCat>o.codCat) return 1;
		if (this.codCat<o.codCat) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if(o instanceof CategoriaProducto) {
			CategoriaProducto p = (CategoriaProducto) o;
			return this.nomCat == p.getNomCat();
		}
		return false;
	}

	@Override
	public String toString() {
		return "\nCódigo: " + this.codCat + 
				"\nNombre: " + this.nomCat + 
				"\nProductos: " + this.Productos;
	}
	
}
