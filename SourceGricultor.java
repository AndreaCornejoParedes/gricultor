import java.util.LinkedList;

public class SourceGricultor {
	public static void main(String[] args) {
		Usuario Andrea = new Usuario("Andrea ", "Cornejo");
		System.out.println("Califique su compra...");
		Andrea.calificar();
		Andrea.calificar();
		Andrea.calificar();
		System.out.println(Andrea.promcalif());
		
		OrderListLinked<Producto> listaP = new OrderListLinked<Producto>();
		listaP.insertNode(new Producto(1, "Laptop", "Laptop samsung", 4, (float)1200.5, "NN", 1 ,"Tecnologia", "Rosa"));
		listaP.insertNode(new Producto(1, "Laptop", "Laptop samsung", 2, (float)1200.5, "NN", 1 ,"Tecnologia", "Rosa"));
		listaP.insertNode(new Producto(1, "Laptop", "Laptop samsung", 3, (float)1200.5, "NN", 1 ,"Tecnologia", "Rosa"));
		listaP.insertNode(new Producto(1, "Laptop", "Laptop samsung", 1, (float)1200.5, "NN", 1 ,"Tecnologia", "Rosa"));
		
		
		
		Factura f1 = new Factura(listaP);
		
		f1.agregarComprobante();
		System.out.println(f1);
	}
}
