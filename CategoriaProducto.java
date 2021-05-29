import java.util.Scanner;
public class CategoriaProducto implements Comparable<CategoriaProducto>{
	private int codCat;
	private String nomCat;
	private ListLinked Productos;
	
	public CategoriaProducto(int codCat, String nomCat, ListLinked productos) {
		super();
		this.codCat=codCat;
		this.nomCat=nomCat;
		this.Productos = productos;
	}
	
	public CategoriaProducto() {
		super();
		boolean x=true;
		this.Productos=new ListLinked();
		Scanner sccod=new Scanner(System.in);
		System.out.println("\t----MENÚ CATEGORÍA----\nINGRESE LOS SIGUIENTES DATOS");
		System.out.println("CÓDIGO: "); int cod=sccod.nextInt();
		Scanner scnom=new Scanner(System.in);
		System.out.println("NOMBRE: "); String nom=scnom.nextLine();
		Scanner scdes=new Scanner(System.in);
		this.codCat=cod; this.nomCat=nom;
		while (x==true) {
			System.out.println("Desea ingresar productos? (1.Sí 2.No) ");
			Scanner opc=new Scanner(System.in);
			int op=opc.nextInt();
			switch (op) {
			case 1:
				Producto prod=new Producto();
				this.Productos.insertLast(prod);
				break;
			case 2:
				System.out.println("Se creó la categoría...");
				x=false;
				break;
			default:
				System.out.println("Opción inválida...");
				break;
			}
		}
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
