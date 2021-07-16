import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;


public class Web {
	/* Atributos */
	private ListLinked<Usuario> Usuarios;
	private BSTree<CategoriaProducto> CategoriaProductos;
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    private CategoriaProducto CatCereales= new CategoriaProducto(1, "Cereales");
    private CategoriaProducto CatTallo= new CategoriaProducto(2, "Tallo");
    private CategoriaProducto CatHortalizas= new CategoriaProducto(3, "Hortalizas");
    private CategoriaProducto CatTuberculo= new CategoriaProducto(4, "Tuberculo");
    /* ------ */
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
	
	@SuppressWarnings("resource")
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
			if(state==false) {
				java.util.Scanner input = new java.util.Scanner(System.in);
				System.out.println("\t\t * ¡Que gusto volvernos a ver! *");
				System.out.print("\t* Ingrese su id: ");
				String id = input.next();
				System.out.print("\t* Ingrese su contraseña: ");
				String contraseña = input.next();
		        String posicion = Files.readAllLines(Paths.get("C:\\Users\\Admin\\archivo.txt")).get(Integer.valueOf(id));
		        
		         if(posicion.equals(contraseña)) {  
		        	 Usuario auxNode= new Usuario(id);
		        	 int posi=this.Usuarios.search(auxNode);
		        	 auxNode = this.Usuarios.search(posi);
		        	 System.out.println("\tEntrando "+auxNode);
		        	 System.out.println("\t***USUARIO VALIDO, BIENVENIDO***");
	        		 state=true;
	        		 return auxNode;
	        	 }
			}
			System.out.println(" ------ USUARIO INVÁLIDO ------");
			return null;
	}
	
	public int agregarUsuario(Usuario User) throws FileNotFoundException  {
		int cont=0;
		archivo = new File ("C:\\Users\\Admin\\archivo.txt");
		fr = new FileReader (archivo);
        br = new BufferedReader(fr);
	    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {	
            fichero = new FileWriter("C:\\Users\\Admin\\archivo.txt",true);
            pw = new PrintWriter(fichero);
            String linea;
            while((linea=br.readLine())!=null) {
            	cont++;
            }
            pw.println(User.getpassword());
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
	
	@SuppressWarnings("unchecked")
	public void modiProducto(Agricultor vendedor) throws ItemNoFound, ParseException, FileNotFoundException, ItemDuplicated{
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
	/*
	 * IngresarCiudades
	 */
	public int ingresarRuta( ){
		Scanner cs = new Scanner(System.in);
		int opc=1;
		GraphLink <String> grafo = new GraphLink<String>();
		Grafo ciudades = new Grafo();
	
		
		grafo.insertVertex("Cayma");
		grafo.insertVertex("Sabandia");
		grafo.insertVertex("Tiabaya");
		grafo.insertVertex("Arequipa");
		grafo.insertVertex("Yanahuara");
		grafo.insertVertex("Miraflores");
		grafo.insertVertex("Yura");
		grafo.insertVertex("Vitor");
		
		grafo.insertEdge("Cayma", "Sabandia",4);
		grafo.insertEdge("Cayma", "Tiabaya",5);
		grafo.insertEdge("Cayma", "Arequipa",3);
		grafo.insertEdge("Sabandia", "Yanahuara",4);
		grafo.insertEdge("Sabandia", "Arequipa",5);
		grafo.insertEdge("Sabandia", "Tiabaya",4);
		grafo.insertEdge("Sabandia", "Miraflores",6);
		grafo.insertEdge("Arequipa", "Yanahuara",5);
		grafo.insertEdge("Arequipa", "Tiabaya",4);
		grafo.insertEdge("Miraflores", "Yura",5);
		grafo.insertEdge("Yura", "Vitor",3);
		grafo.insertEdge("Miraflores", "Vitor",4);
		grafo.insertEdge("Miraflores", "Yanahuara",2);
		grafo.insertEdge("Vitor", "Tiabaya",3);
		
		while (opc>0) {
		System.out.println("\t=========================================="+
							"\n\t                  RUTAS                  "+
							"\n\t==========================================\n");
		System.out.println("\t1. Visualizar las rutas almacenadas  \n" +
				"\t2. Visualizar las distancias entre distritos \n" +
                "\t3. Calcular la mejor ruta\n" +
                "\t4. Salir \n");
		System.out.print("\t* Ingrese su elección: ");
		opc = cs.nextInt();
			switch (opc) {
				case 1:
					System.out.println("\n\t  ----- ESTAS SON LOS DISTRITOS REGISTRADAS  -----  \n");
					System.out.println("\t 1. Cayma ");
					System.out.println("\t 2. Sabandia");
					System.out.println("\t 3. Tiabaya");
					System.out.println("\t 4. Arequipa");
					System.out.println("\t 5. Yanahuara");
					System.out.println("\t 6. Miraflores");
					System.out.println("\t 7. Yura");
					System.out.println("\t 8. Vitor");
					break;
				case 2: 
					System.out.println("\n\t  ----- ESTAS SON LAS DISTANCIAS REGISTRADAS  -----  \n");
					
					System.out.println (grafo);
					break;
				case 3:
					System.out.println ("\n\t Calcular la distancia entre dos distritos: ");
					System.out.println("\t Lista entre distritos:  \n" +
			                "\t - Cayma \n" +
			                "\t - Sabandia \n" +
			                "\t - Tiabaya \n" +
			                "\t - Arequipa \n" +
			                "\t - Yanahuara \n" +
			                "\t - Miraflores \n" +
			                "\t - Yura \n" +
			                "\t - Vitor \n" );
				
					System.out.print("\t* Escriba el nombre del distrito de origen: ");
		            String city1 = cs.next();
		            
		            System.out.print("\n\t* Escriba el nombre del distrito de destino: ");
		            String city2 = cs.next();
		      
		            grafo.Dijkstra(city1, city2);
		            System.out.println("\n\t La distancia mas corta es de " + city1 +  " "+ city2  + "   KM");
		            break;
				case 4:
					opc=-1;
					break;
				default:
					System.out.println("\t --------Opcion invalida--------");
			}
		}
		return 0;
		
	}
	
}
