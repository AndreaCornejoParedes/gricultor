import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

public class Web {
	/* Atributos */
	private HashC <Usuario> Usuarios ;
	private BSTree<CategoriaProducto> CategoriaProductos;
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    private CategoriaProducto CatCereales= new CategoriaProducto(1, "Cereales");
    private CategoriaProducto CatTallo= new CategoriaProducto(2, "Tallo");
    private CategoriaProducto CatHortalizas= new CategoriaProducto(3, "Hortalizas");
    private CategoriaProducto CatTuberculo= new CategoriaProducto(4, "Tuberculo");
    /* ------ */
	public HashC<Usuario> getUsuarios() {
		return Usuarios;
	}
	public void setUsuarios(HashC<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	
	public BSTree<CategoriaProducto> getCategoriaProductos() {
		return CategoriaProductos;
	}
	public void setCategoriaProductos(BSTree<CategoriaProducto> categoriaProductos) {
		this.CategoriaProductos = categoriaProductos;
	}
	public Web() throws ItemDuplicated {
		super();
		boolean x=true;
		this.Usuarios=new HashC<Usuario>(40);
		this.CategoriaProductos= new BSTree();
		LinkedList productos = new LinkedList<Producto>();
		CategoriaProductos.insert(this.CatCereales);
		CategoriaProductos.insert(this.CatTallo);
		CategoriaProductos.insert(this.CatHortalizas);
		CategoriaProductos.insert(this.CatTuberculo );
	}
	
	@SuppressWarnings("resource")
	public Usuario validarUsuario() throws NumberFormatException, IOException, ItemDuplicated  {
		boolean state=false;

		if(this.Usuarios.getTable().isEmpty()) {
			System.out.println();
			System.out.println("\t================== ERROR ==================");
			System.out.println("\t\t¡No hay usuarios registrados!");
			System.out.println();
			
			return null;
		}
			if(state==false) {
				java.util.Scanner input = new java.util.Scanner(System.in);
				System.out.println("\t\t *** ¡Que gusto volvernos a ver! ***");
				System.out.print("\t* Ingrese su id: ");
				String id = input.next();
				System.out.print("\t* Ingrese su contraseña: ");
				String contraseña = input.next();
		        String posicion = Files.readAllLines(Paths.get("E:\\LABORATORIOAED\\archivo.txt")).get(Integer.valueOf(id));
		        
		         if(posicion.equals(contraseña)) {  
		        	 Usuario auxNode= new Usuario(id);
		        	 int posi=this.Usuarios.search(auxNode);
		        	 auxNode = this.Usuarios.search(posi);
		        	 System.out.println("\tEntrando "+auxNode);
		        	 System.out.println("\t********USUARIO VALIDO, BIENVENIDO********");
	        		 state=true;
	        		 return auxNode;
	        	 }
			}
			System.out.println(" ------ USUARIO INVÁLIDO ------");
			return null;
	}
	
	

	@SuppressWarnings("unchecked")
	public void modiProducto(Agricultor vendedor) throws ItemNoFound, ParseException{
		int opc=0;
		int cont=0;
		boolean seguir=true;
		while (seguir) {
			Scanner sc=new Scanner(System.in);
			System.out.println("\n\t  1.Cereales\n\t  2.Tallos\n\t  3.Hortalizas\n\t  4.Tubérculos\n\t  5.Dejar de añadir\n");
			System.out.print("\t* Seleccione la categoria o respuesta: ");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				this.CategoriaProductos.search(this.CatCereales).agregarProducto(vendedor);
				break;
			case 2:
				this.CategoriaProductos.search(this.CatTallo).agregarProducto(vendedor);
				break;
			case 3:
				this.CategoriaProductos.search(this.CatHortalizas).agregarProducto(vendedor);
				break;
			case 4:
				this.CategoriaProductos.search(this.CatTuberculo).agregarProducto(vendedor);
				break;
			case 5:
				seguir=false;
				break;
			default:
				System.out.println("\t--------Opcion invalida--------"); 
			}
		}
	}
	public CategoriaProducto getProductos() throws ItemNoFound{
		int opc=0;
		boolean seguir=true;
		while (seguir) {
			Scanner sc=new Scanner(System.in);
			System.out.println("\n\t  1.Cereales\n\t  2.Tallos\n\t  3.Hortalizas\n\t  4.Tubérculos\n\t  5.Salir\n");
			System.out.print("\t* Seleccione la categoría: ");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				return this.CategoriaProductos.search(this.CatCereales);
			case 2:
				return this.CategoriaProductos.search(this.CatTallo);
			case 3:
				return this.CategoriaProductos.search(this.CatHortalizas);
			case 4:
				return this.CategoriaProductos.search(this.CatTuberculo);
			case 5:
				seguir=false;
				break;
			default:
				System.out.println("\t--------Opcion invalida--------"); 
			}
		}
		return null;
	}
}
