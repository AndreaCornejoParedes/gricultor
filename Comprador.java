import java.util.Scanner;

public class Comprador extends Usuario {
	private Carrito<E> carrito;
	
	public Comprador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void RealizarPedido() {
		System.out.println("================= Pedido =================");
		Scanner reader = new Scanner(System.in);
		System.out.println("Elija un producto: ");
		for() {
			
		}
		
	}
	public void CancelarPedido() {
		System.out.print("¿Esta seguro de querer cancelar su pedido?(Si/No) ");
		String res="";
		Scanner reader = new Scanner(System.in);
		res = reader.nextLine();
		while(res!= "Si" || res!= "si"|| res!= "SI" ||res!="No"||res!="no"||res!="NO") {
			System.out.println("Ingrese una opcion valida ");
			res = reader.nextLine();
		}
		if(res=="Si"|| res== "si"|| res== "SI") {
			int cod;
			carrito=null;
		}
		else{
			break;
		}
	}
}
