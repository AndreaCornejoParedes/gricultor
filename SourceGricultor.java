import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class SourceGricultor {
	public static void main(String[] args) throws NumberFormatException, IOException, ItemDuplicated, ItemNoFound, ParseException {
	
		GraphLink<String> ciudades = new GraphLink<String>();
		
		/*ciudades.insertVertex("Apurimac");
		ciudades.insertVertex("Ayacucho");
		ciudades.insertVertex("Cusco");
		ciudades.insertVertex("Arequipa");
		ciudades.insertVertex("Ica");
		ciudades.insertVertex("Huancavelica");
		ciudades.insertVertex("Lima");
		ciudades.insertVertex("Junin");
		
		ciudades.insertEdge("Apurimac", "Ayacucho",157);
		ciudades.insertEdge("Apurimac", "Cusco",134);
		ciudades.insertEdge("Apurimac", "Arequipa",581);
		ciudades.insertEdge("Ayacucho", "Ica",410);
		ciudades.insertEdge("Ayacucho", "Arequipa",948);
		ciudades.insertEdge("Ayacucho", "Cusco",571);
		ciudades.insertEdge("Ayacucho", "Huancavelica",203);
		ciudades.insertEdge("Arequipa", "Ica",711);
		ciudades.insertEdge("Arequipa", "Cusco",323);
		ciudades.insertEdge("Huancavelica", "Lima",387);
		ciudades.insertEdge("Lima", "Junin",236);
		ciudades.insertEdge("Huancavelica", "Junin",319);
		ciudades.insertEdge("Huancavelica", "Ica",337);
		ciudades.insertEdge("Junin", "Cusco",1009);
		
		ciudades.Dijkstra("Apurimac", "Cusco");*/
		
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
		System.out.println("\n\t<<<<<<<<< BIENVENIDO A GRICULTOR >>>>>>>>>\n\n "
				+ "*Por favor asegurese de que la direccion de archivo sea correcta*\n");
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
		//aux1 = input.next();
		
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
		aux = Gricultor.agregarUsuario(NewUser);
		System.out.println("\tSu ID generado es..."+aux);
		Gricultor.getUsuarios().insertLast(NewUser);
		return NewUser;
	}
	
}
