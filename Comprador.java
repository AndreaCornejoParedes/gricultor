import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Usuario {
	
	private ListLinked<Carro> carrito;
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

		System.out.print("Su codigo de su pedido es: "+c1.getCodigoVenta());
		carrito.insertLast(c1);
		System.out.println(" *** Gracias por su compra en Gricultor *** ");
	}
	
	public void CancelarPedido() {
		int cod;
		System.out.println("================= Cancelacion de Pedido =================");
		System.out.print("\n¿Esta seguro de querer cancelar su pedido?(Si/No) ");
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
			Node<Carro> auxNode=carrito.getFirst();
			for(int i=0;i<carrito.length();i++) {
				auxNode=carrito.getFirst();
				if(auxNode.getData().getCodigoVenta()==cod) {
					auxNode.getData().vaciarCarro();
					System.out.println("Su pedido ha sido cancelado");
				}
			}	
			System.out.print("El numero de pedido ingresado no existe");
			
		}
		else{
			
			System.out.println("Su pedido no se cancelara");
			System.out.println(" *** Gracias por su compra *** ");
		}
	}
	
	@Override
	public String toString() {
		
		return "\n============ Comprador ============\\n"  
				+ "Nombre del comprador:\t" + getNombre()  
				+" Apellidos:\t" + getApellidos()+"\nDNI:\t" + getDni()+ "\nEmail:\t" + getEmail() 
				+ "\n Numero telefonico:\t"+ getTelefono()+ "\n Calificacion:\t" + getCalificacion();
	}
	
}
