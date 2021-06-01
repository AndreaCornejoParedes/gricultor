import java.util.Scanner;
public class Producto implements Comparable<Producto>{
	private int codPro;
	private String nomPro;
	private String desPro;
	private int cantPro;
	private float precio;
	private String ubiPro;
	private int datePro;
	private String variedad;
	
	public Producto() {
		super();
	
		System.out.println("\t----MENÚ PRODUCTO----\nINGRESE LOS SIGUIENTES DATOS");
		Scanner inputstring=new Scanner(System.in);
		System.out.println("NOMBRE: "); String nom=inputstring.nextLine();
		System.out.println("DESCRIPCIÓN: "); String des=inputstring.nextLine();
		Scanner inputint=new Scanner(System.in);
		System.out.println("CANTIDAD: "); int can=inputint.nextInt();
		Scanner inputfloat=new Scanner(System.in);
		System.out.println("PRECIO: "); float prec=inputfloat.nextFloat();
		System.out.println("UBICACIÓN: "); String ubi=inputstring.nextLine();
		System.out.println("FECHA COSECHA: ");int date=inputint.nextInt();
		System.out.println("VARIEDAD: "); String var=inputstring.nextLine();
		this.nomPro=nom; this.desPro=des; this.cantPro=can;
		this.precio=prec; this.ubiPro=ubi; this.datePro=date; this.variedad=var;
	}
	public Producto(int codPro, String nomPro, String desPro, int cantPro, 
			float precio, String ubiPro, int datePro, String variedad) {
		super();
		this.codPro = codPro;
		this.nomPro = nomPro;
		this.desPro = desPro;
		this.cantPro = cantPro;
		this.precio = precio;
		this.ubiPro = ubiPro;
		this.datePro = datePro;
		this.variedad = variedad;
	}
	public int getCodPro() {
		return codPro;
	}
	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}
	public String getNomPro() {
		return nomPro;
	}
	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}
	public String getDesPro() {
		return desPro;
	}
	public void setDesPro(String desPro) {
		this.desPro = desPro;
	}
	public int getCantPro() {
		return cantPro;
	}
	public void setCantPro(int cantPro) {
		this.cantPro = cantPro;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getUbiPro() {
		return ubiPro;
	}
	public void setUbiPro(String ubiPro) {
		this.ubiPro = ubiPro;
	}
	public int getDatePro() {
		return datePro;
	}
	public void setDatePro(int datePro) {
		this.datePro = datePro;
	}
	public String getVariedad() {
		return variedad;
	}
	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}
	
	
	@Override
	public String toString() {
		return 	  "\n"
				+ "Producto: "+this.getNomPro()+"\n"
				+ "Cantidad: "+this.getCantPro()+"\n"
				+ "Precio Unitario: "+this.getPrecio()+"\n";
	}
	public int compareTo(Producto o) {
		if (this.codPro>o.codPro) return 1;
		if (this.codPro<o.codPro) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if(o instanceof Producto) {
			Producto p = (Producto) o;
			return this.nomPro == p.getNomPro();
		}
		return false;
	}
	
}
