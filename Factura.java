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
		System.out.println("=========== Nueva "+this.getClass().getName()+" ===========");
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Ingrese un RUC valido: ");
			ruc = in.next();
		}while(!validarRuc(ruc));
		
		System.out.println("Razon social: ");
		this.razonSocial = in.next();
		in.close();
	}
	private boolean validarRuc(String ruc) {
		return ruc.matches("[0-9]{11}");
	}
	@Override
	public String toString() {
		return 	super.toString()+
				"\nRUC: "+this.ruc+
				"\nRazon Social: "+this.razonSocial;
		
	}
	
}
