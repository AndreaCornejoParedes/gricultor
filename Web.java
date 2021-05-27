
public class Web {
	private ListLinked Usuario;
	private ListLinked Productos;
	
	public Web() {
		super();
		Usuario=new ListLinked();
		Productos=new ListLinked();
	}
	
	public ListLinked<Integer> ocurrencias(String x){
		int con=0;
		int arr[] = new int[Productos.length()];
		TDAList <Integer> list=new ListLinked<Integer>();
		Node<Producto> aux=Productos.getFirst();
		for (int i=0;aux!=null;aux=aux.getNext(),i++) {
			if (aux.getData().equals(x)) {
				arr[con]=i;
				con++;
			}
		}
		for(int j=0;j<con;j++) {
			list.insertFirst(arr[j]);
		}
		return (ListLinked<Integer>) list;
	}
	
//	public ListArray<OrderListLinked<Producto>> clasififcar(float x) {
//		ListArray<OrderListLinked<T>> clasificacion = new ListArray<OrderListLinked<T>>(2);
//		OrderListLinked<T> menores = new OrderListLinked<T>();
//		OrderListLinked<T> mayores = new OrderListLinked<T>();
//		Node<T> aux = this.getFirst();
//		while(aux.getNext() != null) {
//			if(aux.getData().compareTo(x) > 0 || aux.getData().compareTo(x) == 0) {
//				mayores.insert(aux.getData());
//			}
//			else {
//				menores.insert(aux.getData());
//			}
//			aux = aux.getNext();
//		}
//		clasificacion.insertFirst(menores);
//		clasificacion.insertLast(mayores);
//		return clasificacion;
//	}
}
