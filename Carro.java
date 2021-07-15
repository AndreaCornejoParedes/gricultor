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
			System.out.println("\tLa cantidad no puede ser negativa.");
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
			System.out.println("\t------------El carro esta vacio-----------");
		}
	}
	
	public void destruirCarrito() {
		this.arregloCarro.destroyList();
	}
	public String toString() {
		return "\t=========================================="+
				"\n\t                  CARRITO                 "+
				"\n\t=========================================="+
				"\n\tCodigo venta: \t"+this.codigoVenta
				+ "\n\t=====Productos====="
				+ this.arregloCarro.toString();
	}
	
	public void AgregarProductos(Web x) {
		Scanner entrada = new Scanner(System.in);
		Producto aux,aux2;
		int opcion,cant,stock;
		System.out.println("\t* Ingrese la categoria de productos de la cual desea comprar: ");
		try {
			CategoriaProducto p = x.getProductos();
			if(p.getProductos().getCount() == 0) {
				System.out.println("\tCategoria sin productos");
			}
			else {
				System.out.println("\t* Escoja un producto: ");
				p.listarProductos();
			
					System.out.println("\n\t* Inserte el ID del producto que desea agregar: ");
					opcion = entrada.nextInt();
					System.out.println("\n\t* Inserte la cantidad: ");
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
						System.out.println("\t================== ERROR ==================");
						System.out.println("\t               ALGO SALIO MAL              ");
					}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void eliminarCarroProducto(int i, Web x) throws ItemNoFound {
		System.out.println("\t* Ingrese la categoria del cual desea eliminar: \n"); 
		CategoriaProducto p = x.getProductos();
		Producto aux;
		if(this.arregloCarro.isEmptyList()) {
			System.out.println("\tEsta categoria esta aun vacia, agregue productos."); 
		} 
		else {
			if(this.arregloCarro.getCount() < i) { 
				System.out.println("\t--------Index no valido--------"); 
			}
			aux=(Producto) p.getProductos().search(i);
			Producto pr = this.arregloCarro.search(i); 
			p.agregarStockProducto(i, pr.getCantPro());
			pr.getCantPro();
			this.arregloCarro.remove(pr); 
		}
	}
}
