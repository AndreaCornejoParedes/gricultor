import java.io.IOException;

import java.text.ParseException;
import java.util.*;



public class SourceGricultor {
	public static void main(String[] args) throws NumberFormatException, IOException, ItemDuplicated, ItemNoFound, ParseException {
		Usuario NewUser;
		Web Gricultor = new Web();
		while(true) {
		NewUser = SourceGricultor.inicio(Gricultor);
		NewUser.menuopciones(NewUser,Gricultor);
		}
	}
	 
	public static Usuario inicio(Web Gricultor) throws ItemDuplicated, NumberFormatException, IOException {
		int opc;
		Scanner input = new Scanner(System.in);
		System.out.println("\n\t<<<<<<<<< BIENVENIDO A GRICULTOR >>>>>>>>>");
		System.out.println("\t==========================================");
		System.out.println("\t                   LOGIN                  ");
		System.out.println("\t==========================================");
		System.out.println("\t¿Tiene usted una cuenta?");
		System.out.println("\t[ 1 ] : Registrase");
		System.out.println("\t[ 2 ] : Iniciar Sesion");
		System.out.print("\tIngrese su elección: ");
		opc = input.nextInt();
		if (opc==1) {
			return agregarUsuario(Gricultor);
		}else {
			Usuario NewUser = Gricultor.validarUsuario();
			if(NewUser == null) {
				return agregarUsuario(Gricultor);
			}
			return NewUser;
		}

	}
	private static Usuario agregarUsuario(Web Gricultor) throws ItemDuplicated, NumberFormatException, IOException {
		int aux;
		Scanner entrada = new Scanner(System.in);
		Usuario NewUser;
		String aux1;
	
		System.out.println("\t==========================================");
		System.out.println("\t                 REGISTRO                 ");
		System.out.println("\t==========================================");
		System.out.println("\t¿Cual es su rol?");
		System.out.println("\t- Agricultor");
		System.out.println("\t- Comprador");
		System.out.print("\tOpcion: ");
		
		aux1 = entrada.next();
		
		
		if (aux1.toLowerCase().equals("agricultor")|| aux1.toLowerCase().equals("Agricultor")) {
			System.out.println("\tUsted ha seleccionado agricultor");
			NewUser =new Agricultor();
		}else {
			System.out.println("\tUsted ha seleccionado comprador");
			NewUser = new Comprador();
		}
		
		while(!(aux1.equals("Aceptar"))) {
			System.out.println(NewUser);
			System.out.print("\tIngrese Aceptar para confirmar: ");
			aux1=entrada.next();
		}
		
		Gricultor.getUsuarios().insert(Integer.parseInt(NewUser.getId()), NewUser);
		
		return NewUser;
	}
	
}
