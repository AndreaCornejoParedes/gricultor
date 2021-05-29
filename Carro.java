public class Carro extends Producto{ //Herencia_De_Producto
	//Atributos_de_la_clase_Producto 
	private int CantidadPro;
	private float CostoPed;
	
	public Carro(int codPro, String nomPro, String desPro, int cantPro, float precio, String ubiPro, int datePro,
			String variedad, String destino, int cantidadPro, float costoPed) {
		super(codPro, nomPro, desPro, cantPro, precio, ubiPro, datePro, variedad);
		this.setCantidadPro(cantidadPro);
		this.setCostoPed(CostoPed);
	}
	
	public int getCantidadPro() {return CantidadPro;}
	public void setCantidadPro(int cantidadPro) {
		if (CantidadPro>0)
			this.CantidadPro = cantidadPro;
		else 
			this.CantidadPro = 0;
			System.out.print("No hay productos introducidos"+this.CantidadPro);
	}
	public float CostoPed() {
		return CostoPed;
	}
	public void setCostoPed (float costoPed) {
		this.CostoPed= costoPed;
	}
	public void almacenar () {}
	public void Vaciar() {}
	@Override
	public String toString() {
		return " \t Detalles del pedido: \t"
				+ "Cantidad de productos" + this.CantidadPro + "\n";
	}
	
	
}
