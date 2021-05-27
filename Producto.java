
public class Producto {
	private int codPro;
	private String nomPro;
	private String desPro;
	private int cantPro;
	private float precio;
	private String ubiPro;
	private int datePro;
	private String tipo;
	private String variedad;
	public Producto(int codPro, String nomPro, String desPro, int cantPro, float precio, String ubiPro, int datePro,
			String tipo, String variedad) {
		super();
		this.codPro = codPro;
		this.nomPro = nomPro;
		this.desPro = desPro;
		this.cantPro = cantPro;
		this.precio = precio;
		this.ubiPro = ubiPro;
		this.datePro = datePro;
		this.tipo = tipo;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getVariedad() {
		return variedad;
	}
	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}
	
	
	@Override
	public String toString() {
		return "Producto [codPro=" + codPro + ", nomPro=" + nomPro + ", desPro=" + desPro + ", cantPro=" + cantPro
				+ ", precio=" + precio + ", ubiPro=" + ubiPro + ", datePro=" + datePro + ", tipo=" + tipo
				+ ", variedad=" + variedad + "]";
	}
	public int compareTo(Producto o) {
		if (this.codPro>o.codPro) return 1;
		if (this.codPro<o.codPro) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if(o instanceof Producto) {
			Producto p = (Producto) o;
			return this.codPro == p.getCodPro();
		}
		return false;
	}
	
}
