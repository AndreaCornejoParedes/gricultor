import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import sun.jvm.hotspot.oops.ObjectHistogram;


public class SourceGricultor {
	public static void main(String[] args) throws NumberFormatException, IOException, ItemDuplicated {
		java.util.Scanner input = new java.util.Scanner(System.in);	
		Usuario NewUser = null;	
		int aux;
		String aux1=" ";
		Web Gricultor = new Web();
		System.out.println("BUEN DÍA USUARIO ");
		NewUser=SourceGricultor.inicio();
		
		System.out.println(NewUser);
		//SourceGricultor.menuopciones(NewUser,Gricultor);
		
		
		
	}
	 
	
	public static Usuario inicio() throws ItemDuplicated, NumberFormatException, IOException {
		Usuario NewUser = null;
		int opc;
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("¿Tiene usted una cuenta?");
		System.out.println("Opc1 : Registrase");
		System.out.println("Opc2 : Iniciar Sesion \n Ingrese su elección:");
		opc = input.nextInt();
		System.out.println(opc+"soy opc");
		int aux;
		String aux1=" ";
		Web Gricultor = new Web();
		if (opc==1) {
			System.out.println("¿Es usted un agricultor o un comerciante?");
			aux1=input.next();
			if (aux1.equals("agricultor")) {
				System.out.println("Usted selecciono agricultor");
				NewUser =new Agricultor();
			}else {
				System.out.println("Usted selecciono comerciante");
				NewUser = new Comprador();
			}
			
			while(!(aux1.equals("Aceptar"))) {
			System.out.println(NewUser);
			System.out.println("Ingrese Aceptar para confirmar que la informacion es correcta");
			aux1=input.next();
			}
			aux=Gricultor.añadirUsuario(NewUser);
			System.out.println("SU Id generado es..."+aux);
			Gricultor.getUsuarios().insertLast(NewUser);
			return NewUser;
		}else {
			NewUser=Gricultor.validarUsuario();	
			return NewUser;
		}

	}
	public static void menuopciones(Agricultor newUser, Web gricultor) {
		System.out.println("¿Que haremos hoy?");
		System.out.println("Opc1 : Añadir producto a la venta");
		System.out.println("Opc2 : Ver productos:");
		System.out.println("Opc3 : Cerrar sesion :");
		int opc;
		java.util.Scanner input = new java.util.Scanner(System.in);
		opc = input.nextInt();
		switch (opc) {
		case 1:
			System.out.println(gricultor.getCategoriaProductos().toString());
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
		
	}
	private static void menuopciones(Comprador newUser, Web gricultor) {
		System.out.println("¿Que haremos hoy?");
		System.out.println("Opc1 : Añadir producto a la venta");
		System.out.println("Opc2 : Ver productos:");
		System.out.println("Opc3 : Cerrar sesion :");
	
	}
}
