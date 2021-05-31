import java.util.*;
public class Carro  { 
	/**
	 * Atributos_de_la_clase_Producto
	 */
	public final int noExisteElem = -1;
	private int codigoVenta;
	private int codPro;
	private int cantidad = 0;
	private double descuento = 0.0;
	private Producto producto;
	
	public Carro() {
		arregloCarro = new ArrayList<Producto>();
	}
	private ArrayList<Producto> arregloCarro;
	
	public Carro(int codigoVenta, int codPro, int cantidad, double descuento) {
		super();
		this.codigoVenta = codigoVenta;
		this.codPro = codPro;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}
	
	public int getCodigoVenta() { 
		return codigoVenta;
	}
	
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	
	public int getCodPro() { 
		return codPro;
	}
	
	public void setCodPro(int codPro) {	
		this.codPro = codPro;
	}
	
	public int getCantidad() {	
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Producto getProducto () { 
		return producto; 
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//MetodoAgregarDescuento
	public void agregarDescuento(double descuento) {
		this.descuento +=descuento;
	}
	//MetodoAgregarCantidad
	public void agregarCantidad(int cantidad){
		this.cantidad += cantidad;
	}
	@Override
	//
	public boolean equals(Object obj) {
		//comprueba el que el detalle de la venta no sea nulo
		if (obj != null && obj instanceof Producto) {
			boolean productoIgual = this.codPro == ((Producto) obj).getCodPro();
			boolean ventaIgual = this.codigoVenta == ((Carro) obj).getCodigoVenta();
			return productoIgual && ventaIgual;
		}
		return super.equals(obj);
	}
	
	
	////////////////////////////////////////////////////////
	public void agregarItem (Producto ventita) {
		int codiPro = ventita.getCodPro();
		if (this.prodCarro(codiPro)){
			this.agregarCantidad(cantidad);;
			this.agregarDescuento(descuento);
		} else{
			ventita.setCodPro(codPro);
			arregloCarro.add(ventita);
		}
		
	}
	private int getIndex(int codPro) {
		Producto ventita = new Producto();
		ventita.setCodPro(codPro);
		
		return arregloCarro.indexOf(ventita);
	}
	public Producto getProducto (int codPro) {
		Producto ventita = null;
		int index = getIndex(codPro);
		if (index != noExisteElem) {
			ventita = arregloCarro.get(index);
		}
		return ventita;
	}
	
	public ArrayList <Producto> getCarro(){
		return arregloCarro;
	}
	public void vaciarCarro () { /*vaciar el carro una vez realizada la compra*/
		arregloCarro.clear();
	}
	
	public void borrarItem (int codPro) { //eliminar un elemento del carrito
		int index = getIndex (codPro);
		if (index != noExisteElem) {
			arregloCarro.remove(index);
		}
	}
	
	public boolean prodCarro (int codPro) { //verifica que haya elementos en el carro
		return getIndex (codPro) != noExisteElem;
	}
	
	//////////////////////////////////////////////////////////////////////////

			
}
