import java.util.Scanner;

public class Boleta extends Comprobante{
	private String nroDoc;
	private String nombre;
	public Boleta(OrderListLinked<Producto> listaProductos) {
		super(listaProductos);
		this.nombre="";
		this.nroDoc="";
	}

	@Override
	public void agregarComprobante() {
		super.agregarComprobante();
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n\t* Ingrese el nombre: ");
		this.nombre = in.next();
		System.out.println("\n\t* Ingrese el numero del documento: ");
		this.nroDoc = in.next();
	}

	public String toString() {
		return 	super.toString()+
				"\n\t==========================================" +
				"\n\t           DETALLES DE LA BOLETA          " +
				"\n\t==========================================" +
				"\n\tNro documento: \t"+this.nroDoc+
				"\n\tNombre: \t"+this.nombre;
		
	}

}
