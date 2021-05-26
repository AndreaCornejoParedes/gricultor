
public class Carro// extends <LinkedList>
{
	private int codigoPedido;
	private String destino;
	private int Cantidad;
	public Carro(int codigoPedido, String destino, int cantidad) {
		super();
		this.codigoPedido = codigoPedido;
		this.destino = destino;
		Cantidad = cantidad;
	}
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "El carrito tiene:"
				+ "Codigo del pedido =" + codigoPedido
				+ "El pedido esta dirigido hacia: " + destino 
				+ "Cantidad de productos" + Cantidad + "]";
	}
	
	
}
