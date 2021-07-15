import java.util.Date;
import java.util.Scanner;

public class Factura extends Comprobante{
	String ruc;
	String razonSocial;
	
	public Factura(OrderListLinked<Producto> listaP) {
		super(listaP);
		this.razonSocial="";
		this.ruc="";
	}

	@Override
	public void agregarComprobante() {
		super.agregarComprobante();
		System.out.println("\t==========================================");
		System.out.println("\t    Nueva"+this.getClass().getName()+"    ");
		System.out.println("\t==========================================");
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("\t* Ingrese un RUC valido: ");
			ruc = in.nextLine();
		}while(!validarRuc(ruc));
		
		System.out.println("\tRazon social: ");
		this.razonSocial = in.next();
		in.close();
		System.out.println("\t==========================================");
	}
	private boolean validarRuc(String ruc) {
		return ruc.matches("[0-9]{11}");
	}
	@Override
	public String toString() {
		return 	super.toString()+
				"\n\t=========================================="+
				"\n\t          DETALLES DE LA FACTURA          "+
				"\n\t=========================================="+
				"\n\tRUC: \t"+this.ruc+
				"\n\tRazon Social: \t"+this.razonSocial;
	}
}
