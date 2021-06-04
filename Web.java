import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Web {
	private ListLinked<Usuario> Usuarios;
	private BSTree<CategoriaProducto> CategoriaProductos;
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    private CategoriaProducto CatCereales= new CategoriaProducto(1, "Cereales");
    private CategoriaProducto CatTallo= new CategoriaProducto(2, "Tallo");
    private CategoriaProducto CatHortalizas= new CategoriaProducto(3, "Hortalizas");
    private CategoriaProducto CatTuberculo= new CategoriaProducto(4, "Tuberculo");
	
	public ListLinked<Usuario> getUsuarios() {
		return Usuarios;
	}
	public void setUsuarios(ListLinked<Usuario> usuarios) {
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
		this.Usuarios=new ListLinked();
		this.CategoriaProductos= new BSTree();
		LinkedList productos = new LinkedList<Producto>();
		CategoriaProductos.insert(this.CatCereales);
		CategoriaProductos.insert(this.CatTallo);
		CategoriaProductos.insert(this.CatHortalizas);
		CategoriaProductos.insert(this.CatTuberculo );
	}
	
	public Usuario validarUsuario() throws NumberFormatException, IOException, ItemDuplicated  {
		boolean state=false;
		if(this.Usuarios.isEmptyList()) {
			System.out.println();
			System.out.println("\t================== ERROR ==================");
			System.out.println("\t\t¡No hay usuarios registrados!");
			System.out.println();
			//SourceGricultor.inicio(this);
			return null;
		}
			while(state==false) {
				java.util.Scanner input = new java.util.Scanner(System.in);
				System.out.println("¡Que gusto volvernos a ver!");
				System.out.println("Ingrese su id");
				String id = input.next();
				System.out.println("Ingrese su contraseña");
				String contraseña = input.next();
		         String posicion = Files.readAllLines(Paths.get("F:\\LABORATORIOAED\\archivo.txt")).get(Integer.valueOf(id));
	     
		         Usuario auxNode = new Usuario(id,contraseña);
		         if(posicion.equals(contraseña)) {        		 
	        		 System.out.println(" USUARIO VALIDO, BIENVENIDO");
	        		 state=true;
	        		 return auxNode;
	        	 }
			}
			 System.out.println("USUARIO INVÁLIDO");
		        return null;
			
	}
	public int añadirUsuario(Usuario User) throws FileNotFoundException  {
		int cont=0;
		archivo = new File ("F:\\LABORATORIOAED\\archivo.txt");
		fr = new FileReader (archivo);
        br = new BufferedReader(fr);
	    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {	
            fichero = new FileWriter("F:\\LABORATORIOAED\\archivo.txt",true);
            pw = new PrintWriter(fichero);
            String linea;
            while((linea=br.readLine())!=null) {
            	cont++;
            }
            pw.println(User.getContraseña());
            User.setId(String.valueOf(cont)); 
            return cont;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		return 0;
	}
	/*public void getProductosId(int i) throws ItemNoFound{
			switch(i) {
			case 1:
				this.CategoriaProductos.search(this.CatCereales);
				break;
			case 2:
				this.CategoriaProductos.search(this.CatTallo);
				break;
			case 3:
				this.CategoriaProductos.search(this.CatHortalizas);
				break;
			case 4:
				this.CategoriaProductos.search(this.CatTuberculo);
				break;
			default:
				System.out.println("\tOpción inválida...");
				break;
			}
		
	}*/
	@SuppressWarnings("unchecked")
	public void modiProducto() throws ItemNoFound{
		int opc=0;
		boolean seguir=true;
		while (seguir) {
			Scanner sc=new Scanner(System.in);
			System.out.println("\n\t1.Cereales\n\t2.Tallos\n\t3.Hortalizas\n\t4.Tubérculos\n\t5.Salir\n");
			System.out.print("\tSeleccione la categoría: ");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				this.CategoriaProductos.search(this.CatCereales).agregarProducto();
				break;
			case 2:
				this.CategoriaProductos.search(this.CatTallo).agregarProducto();
				break;
			case 3:
				this.CategoriaProductos.search(this.CatHortalizas).agregarProducto();
				break;
			case 4:
				this.CategoriaProductos.search(this.CatTuberculo).agregarProducto();
				break;
			case 5:
				seguir=false;
				break;
			default:
				System.out.println("\tOpción inválida...");
			}
		}
	}
	public CategoriaProducto getProductos() throws ItemNoFound{
		int opc=0;
		boolean seguir=true;
		while (seguir) {
			Scanner sc=new Scanner(System.in);
			System.out.println("\n\t1.Cereales\n\t2.Tallos\n\t3.Hortalizas\n\t4.Tubérculos\n\t5.Salir\n\tSeleccione la categoría: ");
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
				System.out.println("\tOpción inválida...");
			}
		}
		return null;
	}
}
