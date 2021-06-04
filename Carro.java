import java.util.*;
public class Carro  { 
	/**
	 * Atributos_de_la_clase_Producto
	 */
	private String codigoVenta;
	private int CantidadProductos = 0;
	private OrderListLinked<Producto> arregloCarro;
	private Double MontoTotal;
	
	public Carro() {
		this.setCodigoVenta();
		this.CantidadProductos = 0;
		this.MontoTotal = 0.0;
		this.arregloCarro = new OrderListLinked<Producto>();
	}
	public OrderListLinked<Producto> getProductosCarrito(){
		return this.arregloCarro;
	}
	public String getCodigoVenta() { 
		return codigoVenta;
	}
	public boolean isEmpty(){
		return this.arregloCarro.isEmptyList();
	}
	
	public void setCodigoVenta() {
		this.codigoVenta = Integer.toString((int)Math.random()*1000);
	}
	
	public int getCantidadProductos() {	
		return CantidadProductos;
	}
	
	public void setCantidadProductos(int CantidadProductos) {
		if(CantidadProductos < 0) {
			System.out.println("La cantidad no puede ser negativa.");
		}
		else {
			this.CantidadProductos = this.arregloCarro.getCount();
		}
	}
	
	public void CalcularMontoTotal() {
		if(!this.arregloCarro.isEmptyList()) {
			Node<Producto>  aux = this.arregloCarro.getFirst();
			if(this.arregloCarro.getFirst() != null && aux.getNext() == null) {
				this.MontoTotal = (double) (aux.getData().getCantPro() * aux.getData().getPrecio());
			}
			else {
				while(aux.getNext() != null) {
					this.MontoTotal += aux.getData().getPrecio() * aux.getData().getCantPro();
					aux = aux.getNext();
				}
				this.MontoTotal += aux.getData().getPrecio() * aux.getData().getCantPro();
			}
		}
		else {
			System.out.println("El carro esta aun esta vacio");
		}
	}
	
	public void disminuirStockC(Web x) {
		
		for(int i=0;i<this.arregloCarro.getCount();i++ ) {
			
		}
	}
	public void destruirCarrito() {
		this.arregloCarro.destroyList();
	}
	public String toString() {
		return "\n Codigo venta "+this.codigoVenta
				+ "\n =====Productos====="
				+ this.arregloCarro.toString();
	}
	
	public void AgregarProductos(Web x) {
		Scanner entrada = new Scanner(System.in);
		Producto aux,aux2;
		int opcion,cant,stock;
		System.out.println("Ingrese la categoria de productos de la cual desea comprar: ");
		try {
			CategoriaProducto p = x.getProductos();
			if(p.getProductos().getCount() == 0) {
				System.out.println("Categoria sin productos");
			}
			else {
				System.out.println("Escoja un producto");
				p.listarProductos();
			
					System.out.println("\nInserte el ID del producto que desea agregar:");
					opcion = entrada.nextInt();
					System.out.println("\nInserte la cantidad");
					cant = entrada.nextInt();
					if(opcion > -1 && opcion < p.getProductos().getCount()) {
						aux = (Producto) p.getProductos().search(opcion);
						aux2 = aux.disminuirStock(cant);
						if(aux2 == null) {
							System.out.println("\tProducto no agregado");
						}
						else {
							this.arregloCarro.insertNode(aux2);
						}
					}
					else {
						System.out.println("Error: Algo salio mal");
					}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
