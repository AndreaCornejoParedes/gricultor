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
		
		System.out.println("\nIngrese el nombre: ");
		this.nombre = in.next();
		System.out.println("\nIngrese el numero del documento: ");
		this.nroDoc = in.next();
		in.close();
	}

	public String toString() {
		return 	super.toString()+
				"\nNro documento: "+this.nroDoc+
				"\nnombre: "+this.nombre;
		
	}

}
