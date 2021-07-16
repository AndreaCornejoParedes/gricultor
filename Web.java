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
		int opc=1 ;
		//archivo = new File ("rutas.txt");
		GraphLink <String> grafo = new GraphLink<String>();
		Grafo ciudades = new Grafo();
		//fr = new FileReader (archivo);
        //br = new BufferedReader(fr);
	    //FileWriter fichero = null;
        //PrintWriter pw = null;
		try {
			BufferedReader bf =new  BufferedReader(new FileReader ("C:\\Users\\Admin\\Rutas.txt"));
	    	String line ;
	    	while (( line = bf.readLine()) != null) {
	    		grafo.insertEdge(line, line);
	    		
	    	}
		} catch (Exception e){
			System.err.println("\t¡¡ERROR!! - El archivo que se busca no se puede encontrar ");
		}
		
		grafo.insertVertex("Apurimac");
		grafo.insertVertex("Ayacucho");
		grafo.insertVertex("Cusco");
		grafo.insertVertex("Arequipa");
		grafo.insertVertex("Ica");
		grafo.insertVertex("Huancavelica");
		grafo.insertVertex("Lima");
		grafo.insertVertex("Junin");
		
		grafo.insertEdge("Apurimac", "Ayacucho",157);
		grafo.insertEdge("Apurimac", "Cusco",134);
		grafo.insertEdge("Apurimac", "Arequipa",581);
		grafo.insertEdge("Ayacucho", "Ica",410);
		grafo.insertEdge("Ayacucho", "Arequipa",948);
		grafo.insertEdge("Ayacucho", "Cusco",571);
		grafo.insertEdge("Ayacucho", "Huancavelica",203);
		grafo.insertEdge("Arequipa", "Ica",711);
		grafo.insertEdge("Arequipa", "Cusco",323);
		grafo.insertEdge("Huancavelica", "Lima",387);
		grafo.insertEdge("Lima", "Junin",236);
		grafo.insertEdge("Huancavelica", "Junin",319);
		grafo.insertEdge("Huancavelica", "Ica",337);
		grafo.insertEdge("Junin", "Cusco",1009);
		
		while (opc>0) {
		System.out.println("\t=========================================="+
							"\n\t                  RUTAS                  "+
							"\n\t==========================================\n");
		System.out.println("\t1. Visualizar las rutas almacenadas  \n" +
				"\t2. Visualizar las distancias entre ciudades \n" +
                "\t3. Calcular la mejor ruta\n" +
                "\t4. Salir \n");
		System.out.print("\t* Ingrese su elección: ");
		opc = cs.nextInt();
			switch (opc) {
				case 1:
					System.out.println("\n\t  ----- ESTAS SON LAS CIUDADES REGISTRADAS  -----  \n");
					System.out.println("\t 1. Apurimac ");
					System.out.println("\t 2. Ayacucho");
					System.out.println("\t 3. Cusco");
					System.out.println("\t 4. Arequipa");
					System.out.println("\t 5. Ica");
					System.out.println("\t 6. Huancavelica");
					System.out.println("\t 7. Lima");
					System.out.println("\t 8. Junin");
					break;
				case 2: 
					System.out.println("\n\t  ----- ESTAS SON LAS DISTANCIAS REGISTRADAS  -----  \n");
					
					System.out.println (grafo);
					break;
				case 3:
					System.out.println ("\n\t Calcular la distancia entre dos ciudades: ");
					System.out.println("\t Lista entre ciudades:  \n" +
			                "\t - Apurimac \n" +
			                "\t - Ayacucho \n" +
			                "\t - Cusco \n" +
			                "\t - Arequipa \n" +
			                "\t - Ica \n" +
			                "\t - Huancavelica \n" +
			                "\t - Lima \n" +
			                "\t - Junin \n" );
				
					System.out.print("\t* Escriba el nombre de la ciudad de origen: ");
		            String city1 = cs.next();
		            //String city2 = cs.next();
		            /*while (!ciudades.contains(city1)) {
		            	 System.out.println ("\t Lo sentimos... La ciudad que busca no se encuentra registrada. ");
		            	 city1 = cs.next();
		            	 break;
		            }*/
		            System.out.print("\n\t* Escriba el nombre de la ciudad de destino: ");
		            String city2 = cs.next();
		            //String city2 = cs.next();
		           /* while (!ciudades.contains(city1)) {
		            	 System.out.println ("\t Lo sentimos... La ciudad que busca no se encuentra registrada. ");
		            	 city2 = cs.next();
		            	 break;
		            }*/
		            //city1 = city1.toLowerCase();
		            //city2 = city2.toLowerCase();
		            grafo.Dijkstra("Apurimac", "Cusco");
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
