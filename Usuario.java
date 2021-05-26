import java.util.ArrayList;


public class Usuario {
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private ArrayList<Integer> calificacion=new ArrayList<Integer>();
	private String telefono;
	public Usuario(String dni, String nombre, String apellidos, String email, String contraseña, ArrayList<Integer> calificacion,
			String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.calificacion=null;
		this.telefono = telefono;
	}
	public Usuario(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
		java.util.Scanner input = new java.util.Scanner(System.in);
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
		return sumatoria/i;
	}
	
}
