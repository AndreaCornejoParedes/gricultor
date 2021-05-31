import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Usuario {
	
	private ListLinked<Carro> carrito;
	Scanner reader = new Scanner(System.in);
	
	

	public Comprador() {
		super();
	}

	public Comprador(int i) {
		super(i);
	}

	public void RealizarPedido() {
		
		System.out.println("\t================= PEDIDO =================");

		Carro c1 = new Carro();
		CategoriaProducto p1 = null;
		int cant;double precio, desc;
		String nom, nomPro;
		
		System.out.print("\nIngrese el nombre de la categoria que busca: ");
		nom= reader.nextLine();
		if(p1.equals(nom) == false) {
			System.out.println("\nNo se encontro la categoria solicitada");
			this.RealizarPedido();
		}
		else {
			p1.toString();
			System.out.print("Ingrese el nombre del producto deseado: ");
			nomPro=reader.nextLine();
			if(c1.getProducto().equals(nomPro)==false) {
				System.out.println("\nNo se encontro el producto solicitado");
				this.RealizarPedido();
			}
			System.out.print("Ingrese la cantidad de productos que desee comprar: ");
			cant=reader.nextInt();
			c1.setCantidad(cant);
			precio=(c1.getProducto().getPrecio())*cant;
			System.out.println("Recuerde que si su compra excede un limite de productos se le aplicara un descuento");
			if(cant>30) {
				desc= 5.70;
				c1.setDescuento(desc);
				precio=precio-desc;
			}
			System.out.println("\n El total de su pedido es: "+precio);
			System.out.println("\nSu codigo de su pedido es: "+c1.getCodigoVenta());
			carrito.insertLast(c1);
			System.out.println("\n **** Gracias por su compra en Gricultor **** ");
			System.out.println("\n *** Esperamos su proxima compra *** ");
			
		}
	}
	
	public void CancelarPedido() {
		
		int cod;
		System.out.println("\t================= CANCELACION DE SU PEDIDO =================");
		System.out.print("\n¿Esta seguro de querer cancelar su pedido?(1.Si/2.No): ");
		int res=0;
		Scanner reader = new Scanner(System.in);
		res = reader.nextInt();
		
		while(res!= 1 && res!= 2) {
			System.out.print("Ingrese una opcion valida: ");
			res = reader.nextInt();
		}
		
		if(res==1) {
			System.out.print("Ingrese el codigo de su pedido: ");
			cod=reader.nextInt();
			Node<Carro> auxNode=carrito.getFirst();
			for(int i=0;i<carrito.length();i++) {
				auxNode=carrito.getFirst();
				if(auxNode.getData().getCodigoVenta()==cod) {
					auxNode.getData().vaciarCarro();
					System.out.println("Su pedido ha sido cancelado correctamente");
				}
			}	
			System.out.println("El numero de pedido ingresado no existe");
			System.out.println("\t--No hay pedido que eliminar--");
		}
		else{
			System.out.println("\nSu pedido no se cancelara");
			System.out.println("\t\t\t *** GRACIAS POR SU COMPRA *** ");
		}
	}
	
	
}
