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
	
	public int agregarUsuario(Usuario User) throws FileNotFoundException  {
		int cont=0;
		archivo = new File ("E:\\LABORATORIOAED\\archivo.txt");
		fr = new FileReader (archivo);
        br = new BufferedReader(fr);
	    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {	
            fichero = new FileWriter("E:\\LABORATORIOAED\\archivo.txt",true);
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
	/*
	 * IngresarCiudades
	 */
	public int ingresarRuta(GraphLink graph ) throws FileNotFoundException{
		Scanner cs = new Scanner(System.in);
		int opc=0 ;
		archivo = new File ("rutas.txt");
		GraphLink <String> grafo = new GraphLink<String>();
		Grafo ciudades = new Grafo();
		//fr = new FileReader (archivo);
        //br = new BufferedReader(fr);
	    //FileWriter fichero = null;
        //PrintWriter pw = null;
		try {
			BufferedReader bf =new  BufferedReader(new FileReader ("C:\\Users\\user\\Downloads\\LabAED Practicas\\Rutas.txt"));
	    	String line ;
	    	while (( line = bf.readLine()) != null) {
	    		grafo.insertEdge(line, line);
	    		
	    	}
		} catch (Exception e){
			System.err.println("¡¡ERROR!! - El archivo que se busca no se puede encontrar ");
		}
		opc = cs.nextInt();
		System.out.println("1. Visualizar las rutas almacenadas  \n" +
				"2. Visualizar las distancias entre ciudades \n" +
                "3. Calcular la mejor ruta\n" +
                "4. Salir \n");
		switch (opc) {
			case 1:
				System.out.println("\t  ----- ESTAS SON LAS CIUDADES ALMACENADAS  -----  \n");
				grafo.insertVertex("Apurimac");
				System.out.println("\t 1.  "+grafo);
				grafo.insertVertex("Ayacucho");
				System.out.println("\t 2.  "+grafo);
				grafo.insertVertex("Cusco");
				System.out.println("\t 3.  "+grafo);
				grafo.insertVertex("Arequipa");
				System.out.println("\t 4.  "+grafo);
				grafo.insertVertex("Ica");
				System.out.println("\t 5.  "+grafo);
				grafo.insertVertex("Huancavelica");
				System.out.println("\t 6.  "+grafo);
				grafo.insertVertex("Lima");
				System.out.println("\t 7.  "+grafo);
				grafo.insertVertex("Junin");
				System.out.println("\t 8.  "+grafo);
				break;
			case 2: 
				System.out.println("\t  ----- ESTAS SON LAS DISTANCIAS ALMACENADAS  -----  \n");
			case 3:
				System.out.println (" Calcular la distancia entre dos ciudades: ");
				System.out.println("Lista entre ciudades:  \n" +
		                " - Apurimac \n" +
		                " - Ayacucho \n" +
		                " - Cusco \n" +
		                " - Arequipa \n" +
		                " - Ica \n" +
		                " - Huancavelica \n" +
		                " - Lima \n" +
		                " - Junin \n" );
				System.out.println ("Escriba el nombre de la ciudad de origen: ");
	            String city1 = cs.next();
	            //String city2 = cs.next();
	            while (!ciudades.contains(city1)) {
	            	 System.out.println ("Lo sentimos... La ciudad que busca no se encuentra registrada. ");
	            	 city1 = cs.next();
	            	 break;
	            	
	            }
	            System.out.println ("Escriba el nombre de la ciudad de destino: ");
	            String city2 = cs.next();
	            //String city2 = cs.next();
	            while (!ciudades.contains(city1)) {
	            	 System.out.println ("Lo sentimos... La ciudad que busca no se encuentra registrada. ");
	            	 city2 = cs.next();
	            	 break;
	            }
	            city1 = city1.toLowerCase();
	            city2 = city2.toLowerCase();
	            grafo.Dijkstra(city1, city2);
	            System.out.println("La distancia mas corta es de " + city1 +  " "+ city2  + "   KM");
	            /*
	            System.out.println ("Ingrese la distancia ");
	            Integer peso = cs.nextInt();
				grafo.insertEdge(city1, city2, peso);*/
			case 4:
				break;
			default:
				System.out.println("\t--------Opcion invalida--------");
		}
		return 0;
		
	}
	
}
