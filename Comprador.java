import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Usuario {
	private OrderListLinked<Carro> carrito;
	Scanner reader = new Scanner(System.in);
	
	public Comprador(String dni, String nombre, String apellidos, String email, String contraseña,
		ArrayList<Integer> calificacion, String telefono) {
	super(dni, nombre, apellidos, email, contraseña, calificacion, telefono);
	// TODO Auto-generated constructor stub
	}

	public void RealizarPedido() {
		Carro c1;
		int cant;
		String destino;
		System.out.println("================= Pedido =================");
		System.out.print("Ingrese la cantidad de productos: ");
		cant=reader.nextInt();
		c1.setCantidad(cant);
		System.out.print("Ingrese el destino al que llegara su pedido: ");
		destino = reader.nextLine();
		c1.setDestino(destino);

		System.out.print("Su codigo de su pedido es: "+c1.getCodigoPedido());
		carrito.insertNode(c1);
	}
	public void CancelarPedido() {
		int cod;
		System.out.print("¿Esta seguro de querer cancelar su pedido?(Si/No) ");
		String res="";
		Scanner reader = new Scanner(System.in);
		res = reader.nextLine();
		while(res!= "Si" || res!= "si"|| res!= "SI" ||res!="No"||res!="no"||res!="NO") {
			System.out.println("Ingrese una opcion valida ");
			res = reader.nextLine();
		}
		if(res=="Si"|| res== "si"|| res== "SI") {
			System.out.print("Ingrese el codigo de su pedido: ");
			cod=reader.nextInt();
			if(carrito.search(cod)==-1) {
				System.out.print("El numero de pedido ingresado no existe");
				break;
			}
			else {
				//de prueba
				Carro c1;
				carrito.remove(c1)=null;
				System.out.println("Su pedido ha sido cancelado");
			}
		}
		else{
			break;
		}
	}
	@Override
	public String toString() {
		return "============ Comprador ============\\n"  
				+ "Nombre del comprador:\t" + getNombre()  
				+" Apellidos:\t" + getApellidos()+"\nDNI:\t" + getDni()+ "\nEmail:\t" + getEmail() 
				+ "\n Numero telefonico:\t"+ getTelefono()+ "\n Calificacion:\t" + getCalificacion();
	}
	
}
