import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Usuario {
	
	private Carro carrito;
	
	public Comprador() {
		super();
		this.carrito = new Carro();
	}

	public Comprador(int i) {
		super(i);
	}
	public Carro getCarrito() {
		return this.carrito;
	}

	public void RealizarPedido(Web x) {
		//Carro c1 = new Carro();
		System.out.println("\t================= PEDIDO =================");
		System.out.println("\tVamos a realizar un nuevo Pedido");
		
		this.carrito.AgregarProductos(x);
		
	}
	/*
	public void realizarCompra(Web app) {
			this.RealizarPedido(app);
			this.ConfirmarPedido();
	}*/
	public void ConfirmarPedido() {
		int rpta,rpt;
		Comprobante c1;
		Scanner x = new Scanner(System.in);
		System.out.println("\tDesea confirmar el pedido (Si/No): ");
		System.out.println("\t[1]: Si ");
		System.out.println("\t[2]: No ");
		rpt = x.nextInt();
		if(rpt == 1) {
			if(this.carrito.isEmpty()) {
				System.out.println("\tNada que facturar.....");
			}
			else {
				System.out.println("\tQue tipo de comprobante desea? \n [1] Boleta \n [2] Factura");
				rpta = x.nextInt();
				switch(rpta) {
				case 1:
					c1 = new Boleta(this.carrito.getProductosCarrito());
					c1.agregarComprobante();
					break;
				case 2:
					c1 = new Factura(this.carrito.getProductosCarrito());
					c1.agregarComprobante();
					break;
				default:
					System.out.println("Opcion no valida......");
				}
			}
		}
		else {
			System.out.println("Puede seguir agregando productos......");
		}
	}
	public void CancelarPedido() {

		System.out.println("\t================= CANCELACION DE SU PEDIDO =================");
		System.out.print("\n¿Esta seguro de querer cancelar su pedido?");
		System.out.print("\n[1] Si");
		System.out.print("\n[2] No");
		int res=0;
		Scanner reader = new Scanner(System.in);
		res = reader.nextInt();
		
		while(res!= 1 && res!= 2) {
			System.out.print("Ingrese una opcion valida: ");
			res = reader.nextInt();
		}
		if(res == 1) {
			this.carrito.destruirCarrito();
		}
		else if(res == 2){
			System.out.println("\tOk puede seguir comprando.....");
			//this.ConfirmarPedido();
		}
	}
	
	
}
