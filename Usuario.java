import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String id;
	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private ArrayList<Integer> calificacion=new ArrayList<Integer>();
	private String telefono;
	public Usuario(String nombre, String apellidos) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		
	}	
	public Usuario() {
		Scanner input = new Scanner(System.in);
		System.out.println("\t==========================================");
		System.out.print("\t* Ingrese su nombre: ");
		this.nombre = input.next();
		System.out.print("\t* Ingrese su apellido: ");
		this.apellidos = input.next();
		System.out.print("\t* Ingrese su e-mail: ");
		this.email = input.next();
		System.out.print("\t* Ingrese la contraseña que va a utilizar: ");
		this.contraseña = input.next();
		System.out.print("\t* Ingrese su celular: ");
		this.telefono = input.next();
	}
	
	public Usuario(String id) {
		this.id = id;
	}
	public Usuario(int x) {
		super();
		this.id =" ";
		this.contraseña = " ";
	}
	
	
 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Integer> getCalificacion() {
		return calificacion;
	}
	

	public void setCalificacion(ArrayList<Integer> calificacion) {
		this.calificacion = calificacion;
	}
	public boolean equals (Object o) {
		if (o instanceof Usuario) {
			Usuario p = (Usuario) o;
			
			return (this.getId().equals(p.getId()));
		}
		return false;
	}
	@Override
	public String toString() {
		return 	  "\t==========================================\n"
				+ "\t                  USUARIO                 \n"
				+ "\t==========================================\n"
				+ "\tNombre: \t"+this.nombre + " "+this.apellidos+"\n"
				+ "\te-mail: \t"+this.email + "\n"
				+ "\tTelefono: \t"+this.telefono + "\n";
	}

	public void menuopciones(Usuario newUser, Web gricultor) throws ItemNoFound, ParseException {
		// TODO Auto-generated method stub
		
	}
}
