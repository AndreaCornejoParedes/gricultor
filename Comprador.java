import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Usuario {
	private Carro carrito;
	
	public Comprador() {
		super();
		this.carrito = new Carro();
	}
	
	public Carro getCarrito() {
		return this.carrito;
	}

	public void RealizarPedido(Web x) {
		System.out.println("\t==========================================");
		System.out.println("\t                  PEDIDO                  ");
		System.out.println("\t==========================================");
		System.out.println("\tVamos a realizar un nuevo Pedido");
		this.carrito.AgregarProductos(x);
	}

	public void ConfirmarPedido() {
		int rpta,rpt;
		Comprobante c1;
		Scanner x = new Scanner(System.in);
		System.out.println("\tDesea confirmar el pedido (Si/No): ");
		System.out.println("\t [1]: Si ");
		System.out.println("\t [2]: No ");
		System.out.print("\tIngrese su eleccion: ");
		rpt = x.nextInt();
		if(rpt == 1) {
			if(this.carrito.isEmpty()) {
				System.out.println("\tNada que facturar...");
			}
			else {
				System.out.println("\tQue tipo de comprobante desea? \n [1] Boleta \n [2] Factura");
				rpta = x.nextInt();
				switch(rpta) {
				case 1:
					c1 = new Boleta(this.carrito.getProductosCarrito());
					c1.agregarComprobante();
					System.out.println(c1);
					break;
				case 2:
					c1 = new Factura(this.carrito.getProductosCarrito());
					c1.agregarComprobante();
					System.out.println(c1);

					break;
				default:
					System.out.println("\tOpcion no valida...");
				}
			}
		}
		else {
			System.out.println("\tPuede seguir agregando productos...");
		}
	}
	public void CancelarPedido() {
		System.out.println("\t==========================================");
		System.out.println("\t          CANCELACION DE PEDIDO           ");
		System.out.println("\t==========================================");
		System.out.print("\n\t¿Esta seguro de querer cancelar su pedido?");
		System.out.print("\n\t [1] Si");
		System.out.print("\n\t [2] No");
		System.out.print("\tIngrese su eleccion: ");
		int res=0;
		Scanner reader = new Scanner(System.in);
		res = reader.nextInt();
		
		while(res!= 1 && res!= 2) {
			System.out.print("\tIngrese una opcion valida: ");
			res = reader.nextInt();
		}
		if(res == 1) {
			this.carrito.destruirCarrito();
		}
		else if(res == 2){
			System.out.println("\tSu pedido no se cancelara");
		}
	}
	public void menuopciones(Usuario Comprador, Web Gricultor) throws ItemNoFound, ParseException  {
		Scanner m = new Scanner(System.in);
		CategoriaProducto x;
		int indice,cantidad,aux;
		boolean salir = false;
		while(!salir) {
			System.out.println();
			System.out.println("\t==========================================");
			System.out.println("\t                   MENU                   ");
			System.out.println("\t==========================================");
			
			System.out.println("\tElija una opcion");
			System.out.println("\t1 : Comprar");
			System.out.println("\t2 : Ver carrito");
			System.out.println("\t3 : Confirmar compra y facturar");
			System.out.println("\t4 : Borrar productos del carrito");
			System.out.println("\t5 : Salir");
			System.out.print("\tOpc: ");
			aux = m.nextInt();
			
			switch(aux) {
			case 1:
				((Comprador) Comprador).RealizarPedido(Gricultor);
				break;
			case 2:
				if(((Comprador) Comprador).getCarrito().isEmpty()) {
					System.out.println("\t-----------El carro esta vacio------------");
				}
				else {
					System.out.println(((Comprador) Comprador).getCarrito());
				}
				break;
			case 3:
				((Comprador) Comprador).ConfirmarPedido();
				
				break;
			case 4:
				System.out.println(((Comprador) Comprador).getCarrito());
				System.out.print("\t* Indique cual es el producto al que desea eliminar: ");
				int pos=m.nextInt();
				((Comprador) Comprador).getCarrito().eliminarCarroProducto(pos, Gricultor);
				break;
			case 5:
				salir = true;
				break;
			default:
				break;
			}
		}
	}
}
