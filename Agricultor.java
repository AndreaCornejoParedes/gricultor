import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Agricultor extends Usuario{
	LinkedList Productos;
	public Agricultor(String nombre, String apellidos) {
		super(nombre, apellidos);
		
	}
	public Agricultor() {
		super();
	}
	
	public void menuopciones(Usuario Agricultor, Web Gricultor) throws ItemNoFound,ParseException
{
		
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;
		CategoriaProducto x;
		int indice,cantidad,aux;
		
		while(true) {
				while(salir != true) {
					System.out.println("\t==========================================");
					System.out.println("\t                   MENU                   ");
					System.out.println("\t==========================================");
					System.out.println("\tElija una opcion");
					System.out.println("\t 1 : Añadir producto a la venta");
					System.out.println("\t 2 : Ver productos");
					System.out.println("\t 3 : Borrar productos");
					System.out.println("\t 4 : Aumentar Sto"
							+ "ck de productos");
					System.out.println("\t 5 : Cerrar sesion");
					System.out.print("\tOpc: ");
					aux = entrada.nextInt();
					switch(aux) {
					case 1:
						System.out.println("\t* Seleccione categoria donde desea agregar un nuevo producto: ");
						Gricultor.modiProducto(this);
						break;
					case 2:
						System.out.println("\t* Seleccione categoria que desea listar:  ");
						x = Gricultor.getProductos();
						x.listarProductos();
						break;
					case 3:
						System.out.println("\t* Seleccione categoria donde desea eliminar algun producto: ");
						x = Gricultor.getProductos();
						System.out.println("\t* Indique cual es el producto al que desea eliminar: ");
						x.listarProductos();
						System.out.print("\tIndice: ");
						indice = entrada.nextInt();
						x.eliminarProducto(indice);
						break;
					case 4:
						System.out.println("\t* ¿En que categoria desea aumentar stock?: ");
						x = Gricultor.getProductos();
						System.out.println("\t* Indique cual es el producto al que desea aumentar stock: ");
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
			}
		}

}
	

