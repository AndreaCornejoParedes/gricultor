import java.io.IOException;
import java.util.*;

public class SourceGricultor {
	public static void main(String[] args) throws NumberFormatException, IOException, ItemDuplicated, ItemNoFound {
		Usuario NewUser;
		Web Gricultor = new Web();
		while(true) {
			NewUser = SourceGricultor.inicio(Gricultor);
			SourceGricultor.menuopciones(NewUser,Gricultor);
		}
	}
	 
	
	public static Usuario inicio(Web Gricultor) throws ItemDuplicated, NumberFormatException, IOException {
		int opc;
		Scanner input = new Scanner(System.in);
		System.out.println("\t==========================================");
		System.out.println("\t                   LOGIN                  ");
		System.out.println("\t==========================================");
		System.out.println("\t¿Tiene usted una cuenta?");
		System.out.println("\t[ 1 ] : Registrase");
		System.out.println("\t[ 2 ] : Iniciar Sesion");
		System.out.print("\tIngrese su elección:");
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
		
		if (aux1.toLowerCase().equals("agricultor")) {
			System.out.println("\tUsted selecciono agricultor");
			NewUser =new Agricultor();
		}else {
			System.out.println("\tUsted selecciono comprador");
			NewUser = new Comprador();
		}
		
		while(!(aux1.equals("Aceptar"))) {
			System.out.println(NewUser);
			System.out.print("\tIngrese Aceptar para confirmar: ");
			aux1=entrada.next();
		}
		aux = Gricultor.añadirUsuario(NewUser);
		System.out.println("\tSu ID generado es....."+aux);
		Gricultor.getUsuarios().insertLast(NewUser);
		return NewUser;
	}
	private static void menuopciones(Usuario newUser, Web gricultor) throws ItemNoFound {
		
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;
		CategoriaProducto x;
		int indice,cantidad,aux;
		
		while(true) {
			if(newUser.getClass().getName()=="Agricultor"){
				Agricultor agricultor = (Agricultor)newUser;
				while(salir != true) {
					System.out.println("\t==========================================");
					System.out.println("\t                   MENU                   ");
					System.out.println("\t==========================================");
					System.out.println("\tElija una opcion");
					System.out.println("\t1 : Añadir producto a la venta");
					System.out.println("\t2 : Ver productos");
					System.out.println("\t3 : Borrar productos");
					System.out.println("\t4 : Aumentar Stock de productos");
					System.out.println("\t5 : Cerrar sesion");
					System.out.print("\tOpc: ");
					aux = entrada.nextInt();
					switch(aux) {
					case 1:
						System.out.println("\tSeleccione categoria que desea agregar un nuevo producto: ");
						gricultor.modiProducto();
						break;
					case 2:
						System.out.println("\tSeleccione categoria que desea listar:  ");
						x = gricultor.getProductos();
						x.listarProductos();
						break;
					case 3:
						System.out.println("\tSeleccione categoria donde desea eliminar algun producto: ");
						x = gricultor.getProductos();
						System.out.println("\tIndique cual es el producto al que desea eliminar: ");
						x.listarProductos();
						System.out.print("\tIndice: ");
						indice = entrada.nextInt();
						x.eliminarProducto(indice);
						break;
					case 4:
						System.out.println("\tEn que categoria desea aumentar stock: ");
						x = gricultor.getProductos();
						System.out.println("\tIndique cual es el producto al que desea aumentar stock: ");
						x.listarProductos();
						
						System.out.print("\tIndice: ");
						indice = entrada.nextInt();
						System.out.print("\tStock a aumentar: ");
						cantidad = entrada.nextInt();
						x.agregarStockProducto(indice, cantidad);
						break; 
					case 5:
						salir = true;
						break;
					default:
						break;
					}
				}
				break;
				
			}else if(newUser.getClass().getName()=="Comprador"){
				Scanner m = new Scanner(System.in);
				Comprador comprador = (Comprador)newUser;
				while(!salir) {
					System.out.println();
					System.out.println("\t==========================================");
					System.out.println("\t                   MENU                   ");
					System.out.println("\t==========================================");
					
					System.out.println("\tElija una opcion");
					System.out.println("\t1 : Comprar");
					System.out.println("\t2 : Ver carrito:");
					System.out.println("\t3 : Confirmar compra y facturar:");
					System.out.println("\t4 : Borrar productos del carrito");
					System.out.println("\t5 : Salir");
					System.out.print("\tOpc: ");
					aux = m.nextInt();
					
					switch(aux) {
					case 1:
						comprador.RealizarPedido(gricultor);
						//System.out.println(gricultor.getCategoriaProductos().toString());
						//gricultor.modiProducto();
						break;
					case 2:
						if(comprador.getCarrito().isEmpty()) {
							System.out.println("\t Carrito vacio");
						}
						else {
							System.out.println(comprador.getCarrito());
						}
						break;
					case 3:
						comprador.ConfirmarPedido();
						break;
					case 4:
						comprador.getCarrito().destruirCarrito();
						break;
					case 5:
						salir = true;
						break;
					default:
						break;
					}
				}
				break;
			}
		}
	}
}
