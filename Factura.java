package Default;

import java.util.Date;
import java.util.Scanner;

public class Factura extends Comprobante implements Comparable<Comprobante>{
	String ruc;
	String razonSocial;
	
	public Factura() {
		super();
	}

	@Override
	public void agregarComprobante() {

		
		Scanner in = new Scanner(System.in);
		
		this.setNumeroComprobante(Integer.toString(((int)Math.random()*100)+1));
		this.setFechaEmision(new Date());
		this.setMontoTotal((double)Math.random()*100 + 1);
		do {
			System.out.println("Ingrese un RUC valido: ");
			ruc = in.next();
		}while(!validarRuc(ruc));
		in.close();
	}
	private boolean validarRuc(String ruc) {
		return ruc.matches("[0-9]{11}");
	}
	@Override
	public void EliminarComprobante() {
		return ;
	}
	public String toString() {
		return 	super.toString()+
				"\nRUC: "+this.ruc+
				"\nRazon Social: "+this.razonSocial;
		
	}
	@Override
	public int compareTo(Comprobante o) {
		if(this.getNumeroComprobante().compareTo(o.getNumeroComprobante()) > 0) {
			return 1;
		}
		else if(this.getNumeroComprobante().compareTo(o.getNumeroComprobante()) == 0){
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
