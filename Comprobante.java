import java.util.Date;
import java.util.Scanner;

public class Comprobante {
	private String numeroComprobante;
	private Date fechaEmision;
	private String tipoDoc;
	private Double MontoTotal;
	private OrderListLinked<Producto> productos;
	
	public Comprobante(OrderListLinked<Producto> listaProductos) {
		//this.productos =  new OrderListLinked<Producto>();
		this.productos = listaProductos;
		this.numeroComprobante= "0";
		this.fechaEmision 	= null;
		this.tipoDoc = "1";
		this.MontoTotal = 0.0;
	}
	
	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Double getMontoTotal() {
		return MontoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		if(montoTotal < 0)
			MontoTotal = 0.0;
		else {
			MontoTotal = montoTotal;
		}
	}

	public  void agregarComprobante() {
		if(!this.productos.isEmptyList()) {
			Node<Producto>  aux = this.productos.getFirst();
			if(this.productos.getFirst() != null && aux.getNext() == null) {
				this.MontoTotal = (double) (aux.getData().getCantPro() * aux.getData().getPrecio());
			}
			else {
				while(aux.getNext() != null) {
					this.MontoTotal += aux.getData().getPrecio() * aux.getData().getCantPro();
					aux = aux.getNext();
				}
				this.MontoTotal += aux.getData().getPrecio() * aux.getData().getCantPro();
			}
			this.fechaEmision = new Date();
			this.numeroComprobante = Integer.toString((int)Math.random()*10000);
		}
		else {
			System.out.println("\tSin productos no se puede crear un comprobante");
		}
	}
	public  void EliminarComprobante() {
		
	}
	
	public String toString() {
		return  "\n\t==========================================" +
				"\n\t                COMPROBANTE               " +
				"\n\t==========================================" +
				"\n\t - Nro: \t" + this.getNumeroComprobante()+
				"\n\t - Fecha de emision: \t"+this.fechaEmision.toString()+
				"\n\t - Tipo documento: \t"+this.getTipoDoc() + 
				"\n\t - Monto total: \t"+this.getMontoTotal() +
				"\n\t==========================================" +
				"\n\t             Lista de Productos           " +
				"\n\t==========================================" +
				this.productos.toString();
		
	}
}
