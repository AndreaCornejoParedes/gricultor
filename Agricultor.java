import java.util.LinkedList;
import java.util.Scanner;

public class Agricultor extends Usuario{
	LinkedList Productos;
	public Agricultor(String nombre, String apellidos) {
		super(nombre, apellidos);
		// TODO Auto-generated constructor stub
	}
	public Agricultor() {
		super();
	}
	public Agricultor(int x) {
		super(x);
	}
public void menuopciones(Usuario Agricultor, Web Gricultor) throws ItemNoFound {
		
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
					System.out.println("\t1 : A�adir producto a la venta");
					System.out.println("\t2 : Ver productos");
					System.out.println("\t3 : Borrar productos");
					System.out.println("\t4 : Aumentar Stock de productos");
					System.out.println("\t5 : Cerrar sesion");
					System.out.print("\tOpc: ");
					aux = entrada.nextInt();
					switch(aux) {
					case 1:
						System.out.println("\tSeleccione categoria que desea agregar un nuevo producto: ");
						Gricultor.modiProducto();
						break;
					case 2:
						System.out.println("\tSeleccione categoria que desea listar:  ");
						x = Gricultor.getProductos();
						x.listarProductos();
						break;
					case 3:
						System.out.println("\tSeleccione categoria donde desea eliminar algun producto: ");
						x = Gricultor.getProductos();
						System.out.println("\tIndique cual es el producto al que desea eliminar: ");
						x.listarProductos();
						System.out.print("\tIndice: ");
						indice = entrada.nextInt();
						x.eliminarProducto(indice);
						break;
					case 4:
						System.out.println("\tEn que categoria desea aumentar stock: ");
						x = Gricultor.getProductos();
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
	
			}
		}

}
	

