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
	
	public Usuario() {
		Scanner input = new Scanner(System.in);
		System.out.println("\t==========================================");
		System.out.print("\tIngrese su nombre: ");
		this.nombre = input.next();
		System.out.print("\tIngrese su apellido: ");
		this.apellidos = input.next();
		System.out.print("\tIngrese su e-mail: ");
		this.email = input.next();
		System.out.print("\tIngrese la contraseña que va a utilizar: ");
		this.contraseña = input.next();
		System.out.print("\tIngrese su celular: ");
		this.telefono = input.next();;
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
	
	/////////
	public void calificar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese la calificacion del 0 al 5");
		int calf=input.nextInt();
		if (calf<=5&&calf>=0)
			this.calificacion.add(calf);
		else {						
			this.calificar();
		}
	}
	
	public void setCalificacion(ArrayList<Integer> calificacion) {
		this.calificacion = calificacion;
	}
	public int promcalif() {
		int sumatoria=0;
		int i=0;
		while(i<this.calificacion.size()) {
			sumatoria+=this.calificacion.get(i);
			i++;
		}
		if(calificacion.size()>0) {
			return sumatoria/i;}
		else {
			return 0;
		}
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
				+ "\tNombre: "+this.nombre + " "+this.apellidos+"\n"
				+ "\te-mail: "+this.email + "\n"
				+ "\tTelefono: "+this.telefono + "\n"
				+ "\tAcualmente tiene una calificion de "+this.promcalif()+"\n";
				
				/*"¡Gusto en conocernos! El usuario es: " + nombre + " " + apellidos + ", Si deseas contactarlo: \n Su email es: " +
	email +" y su telefono es : "+ telefono + 
				" Por su ventas pasadas tiene una calificacion de : "+this.promcalif();*/
	}

	public void menuopciones(Usuario newUser, Web gricultor) throws ItemNoFound, ParseException {
		// TODO Auto-generated method stub
		
	}


	
	
}
