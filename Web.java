import java.util.Scanner;
public class Web {
	private ListLinked Usuario;
	private BSTree CategoriaProductos;
	
	public Web() {
		super();
		boolean x=true;
		this.Usuario=new ListLinked();
		this.CategoriaProductos= new BSTree();
	}
	public void ingresarCategoria() throws ItemDuplicated {
		boolean x=true;
		while (x==true) {
			System.out.println("INGRESANDO CATEGOR�A\n");
			CategoriaProducto cat=new CategoriaProducto();
			this.CategoriaProductos.insert(cat);
			System.out.println("Desea seguir ingresando categor�as? 1.S� 2.No");
			Scanner opc=new Scanner(System.in);
			int op=opc.nextInt();
			switch (op) {
			case 1:
				break;
			case 2:
				x=false;
				break;
			default:
				System.out.println("Opci�n inv�lida...");
				break;
			}
		}		
	}

}
