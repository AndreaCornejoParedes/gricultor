import java.text.ParseException;
import java.util.Scanner;
public class CategoriaProducto implements Comparable<CategoriaProducto>{
	private int codCat;
	private String nomCat;
	private ListLinked<Producto> Productos;
	
	public CategoriaProducto(int codCat, String nomCat) {
		super();
		this.codCat=codCat;
		this.nomCat=nomCat;
		this.Productos = new ListLinked();
	}
	
	public CategoriaProducto() {
		super();
	}
	public void listarProductos() {
		
		System.out.println("\t==========================================");
		System.out.println("\t                Productos	                ");
		System.out.println("\t==========================================");
		System.out.println("\tMostrando productos para la categoria: "+this.nomCat);
		System.out.println("\tCodigo: "+this.codCat);
		if(this.Productos.isEmptyList()) {
			System.out.print("\tAun no existen productos en esta categoria.....");
		}
		else{
			System.out.println(this.Productos);
		}
	}
	public void agregarStockProducto(int i,int cant) {
		if(this.Productos.isEmptyList()) {
			System.out.println("\t Error: Esta categoria esta aun vacia, agrege productos.");
		}
		else {
			if(this.Productos.getCount() < i) {
				System.out.println("\tIndex no valido");
			}
			Producto x = this.Productos.search(i);
			x.aumentarStock(cant);
		}
	}
	
	public void eliminarProducto(int i) {
		if(this.Productos.isEmptyList()) {
			System.out.println("\tEsta categoria esta aun vacia, agrege productos.");
		}
		else {
			if(this.Productos.getCount() < i) {
				System.out.println("\tIndex no valido");
			}
			Producto x = this.Productos.search(i);
			this.Productos.remove(x);
		}
	}
	
	
	
	public void agregarProducto() throws ParseException {
		Producto auxProducto = new Producto();
		this.Productos.insertLast(auxProducto);
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
	

	public ListLinked getProductos() {
		return Productos;
	}

	public void setProductos(ListLinked productos) {
		Productos = productos;
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
	public ListArray<OrderListLinked<Producto>> clasififcar(Producto x) {
	ListArray<OrderListLinked<Producto>> clasificacion = new ListArray<OrderListLinked<Producto>>(2);
	OrderListLinked<Producto> menores = new OrderListLinked<Producto>();
	OrderListLinked<Producto> mayores = new OrderListLinked<Producto>();
	Node<Producto> aux = Productos.getFirst();
	while(aux.getNext() != null) {
		if(aux.getData().compareTo(x) > 0 || aux.getData().compareTo(x) == 0) {
			mayores.insertNode(aux.getData());
		}
		else {
			menores.insertNode(aux.getData());
		}
		aux = aux.getNext();
	}
	clasificacion.insertFirst(menores);
	clasificacion.insertLast(mayores);
	return clasificacion;
	}
	public int compareTo(CategoriaProducto o) {
		if (this.codCat>o.codCat) return 1;
		if (this.codCat<o.codCat) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if(o instanceof CategoriaProducto) {
			CategoriaProducto p = (CategoriaProducto) o;
			return this.codCat == p.getCodCat();
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
