import java.util.LinkedList;

public class SourceGricultor {
	public static void main(String[] args) {
		Usuario Andrea = new Usuario("Andrea ", "Cornejo");
		System.out.println("Califique su compra...");
		Andrea.calificar();
		Andrea.calificar();
		Andrea.calificar();
		System.out.println(Andrea.promcalif());
	}
}
