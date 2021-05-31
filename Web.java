import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Web {
	private ListLinked Usuarios;
	private BSTree CategoriaProductos;
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
	
	public ListLinked getUsuarios() {
		return Usuarios;
	}
	public void setUsuarios(ListLinked usuarios) {
		Usuarios = usuarios;
	}
	
	public BSTree getCategoriaProductos() {
		return CategoriaProductos;
	}
	public void setCategoriaProductos(BSTree categoriaProductos) {
		CategoriaProductos = categoriaProductos;
	}
	public Web() throws ItemDuplicated {
		super();
		boolean x=true;
		this.Usuarios=new ListLinked();
		this.CategoriaProductos= new BSTree();
		LinkedList productos = new LinkedList<Producto>();
		CategoriaProducto CatCereales= new CategoriaProducto(1, "Cereales");
		CategoriaProducto CatTallo= new CategoriaProducto(2, "Tallo");
		CategoriaProducto CatHortalizas= new CategoriaProducto(3, "Hortalizas");
		CategoriaProducto CatTuberculo= new CategoriaProducto(4, "Tuberculo");
		CategoriaProductos.insert(CatCereales);
		CategoriaProductos.insert(CatTallo);
		CategoriaProductos.insert(CatHortalizas);
		CategoriaProductos.insert(CatTuberculo );
	}
	
	public Usuario validarUsuario() throws NumberFormatException, IOException, ItemDuplicated  {
			boolean state=false;
		if(this.Usuarios.isEmptyList()) {
			System.out.println("¡No hay usuarios registrados!");
			SourceGricultor.inicio();
			return null;
		}
			while(state==false) {
		java.util.Scanner input = new java.util.Scanner(System.in);
			System.out.println("¡Que gusto volvernos a ver!");
			System.out.println("Ingrese su id");
			String id = input.next();
			System.out.println("Ingrese su contraseña");
			String contraseña = input.next();
	         String posicion = Files.readAllLines(Paths.get("E:\\LABORATORIOAED\\archivo.txt")).get(Integer.valueOf(id));
	     
	     	Usuario auxNode = new Usuario(id,contraseña);
	         if(posicion.equals(contraseña)) {        		 
	        		 System.out.println(" USUARIO VALIDO, BIENVENIDO ##########");
	        		 state=true;
	        		 return auxNode;
	        	 }
			}
			 System.out.println("USUARIO INVÁLIDO");
		        return null;
			
	}
	public int añadirUsuario(Usuario User) throws FileNotFoundException  {
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
}
