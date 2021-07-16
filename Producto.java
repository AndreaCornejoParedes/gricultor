import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Producto implements Comparable<Producto>{
	private int codPro;
	private String nomPro;
	private String desPro;
	private int cantPro;
	private float precio;
	private String ubiPro;
	private Date datePro;
	private String variedad;
	private Agricultor vendedor;
	
	public Agricultor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Agricultor vendedor) {
		this.vendedor = vendedor;
	}
	public Producto(Agricultor vendedor) throws ParseException, ItemDuplicated, FileNotFoundException {
		super();
		Web rutas= new Web();
		System.out.println("\t==========================================");
		System.out.println("\t             MENU DE PRODUCTOS            ");
		System.out.println("\t==========================================");
		System.out.println("\tIngrese los siguientes datos del producto: ");
		Scanner inputstring=new Scanner(System.in);
		System.out.print("\t* Nombre: "); String nom=inputstring.nextLine();
		System.out.print("\t* Descripcion: "); String des=inputstring.nextLine();
		Scanner inputint=new Scanner(System.in);
		System.out.print("\t* Cantidad (En hectareas): "); int can=inputint.nextInt();
		Scanner inputfloat=new Scanner(System.in);
		System.out.print("\t* Precio (En soles) : "); float prec=inputfloat.nextFloat();
		System.out.print("\t* Ubicacion: "); String ubi=inputstring.nextLine();
		System.out.print("\t* Fecha de Siembra (DD/MM/YYYY): "); String date=inputstring.nextLine();
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date dateP = format.parse(date);
		System.out.print("\t* Variedad: "); String var=inputstring.nextLine();
		System.out.println("  "); 
		this.vendedor=vendedor;
		System.out.println("\t\t     PRODUCTO AÑADIDO  "); 
		System.out.println("  "); 
		System.out.println("\t==========================================");
		this.nomPro=nom; this.desPro=des; this.cantPro=can;
		this.precio=prec; this.ubiPro=ubi; this.datePro=dateP; this.variedad=var;
	
		rutas.ingresarRuta();
	}
	public Producto(int codPro, String nomPro, String desPro, int cantPro, 
			float precio, String ubiPro, Date datePro, String variedad) {
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
	public Date getDatePro() {
		return datePro;
	}
	public void setDatePro(Date datePro) {
		this.datePro = datePro;
	}
	public String getVariedad() {
		return variedad;
	}
	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}
	public void aumentarStock(int x) {
		this.cantPro += x;
	}
	public Producto disminuirStock(int x) {
		Producto p;
		int valor;
		if(this.cantPro == 0) {
			System.out.println("\tEl stock de este producto actualmente es 0");
			return null;
		}else if(this.cantPro < x) {
			System.out.println("\tLa cantidad requerida supera el stock por" + (x - this.cantPro));
			System.out.println("\tSe agregara toda la existencia" + (this.cantPro));
			p = new Producto(this.getCodPro(),this.getNomPro(),this.getDesPro(),this.cantPro,this.getPrecio()
					,this.getUbiPro(),this.datePro,this.variedad);
			this.cantPro = 0;
			return p;
		}else {
			p = new Producto(this.getCodPro(),this.getNomPro(),this.getDesPro(),x,this.getPrecio()
					,this.getUbiPro(),this.datePro,this.variedad);
			
			this.cantPro -= x;
			return p;
		}
	}
	
	public void disminuirStockProducto(int x) {
		this.cantPro -= x;
	}
	
	@Override
	public String toString() {
		return 	"\t=========================================="+
				"\n\t                 PRODUCTO                 "+
				"\n\t=========================================="+
				"\n"+
				"\t- Nombre del Producto: \t"+this.getNomPro()+"\n"
				+ "\t- Cantidad: \t"+this.getCantPro()+"\n"
				+ "\t- Precio Unitario: \t"+this.getPrecio()+"\n";
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