import java.util.ArrayList;

public class HashC<T extends Comparable<T>> {
	protected class Element{
		int mark;
		Register<T> reg;
		public Element(int mark,Register<T> reg) {
			this.mark = mark;
			this.reg = reg;
		}
		public int getMark() {
			return mark;
		}
		public void setMark(int mark) {
			this.mark = mark;
		}
		
		
	}
	protected ArrayList<Element> table;
	protected int m;
	
	
	public HashC(int n) {
		this.m = n;
		this.table = new ArrayList<Element>(m);
		for(int i = 0;i<m;i++)
			this.table.add(new Element(0,null));
	}
	

	private int functionHash(int key) {
		return key % m;
	}
	
	public T search(int key) {
		int dressHash=functionHash(key);
		int posInit=dressHash;
		do {
			if(table.get(dressHash).mark==1 && table.get(dressHash).reg.getKey()==key) {
				//System.out.println("Elemento encontrado...");
				return table.get(dressHash).reg.value;
			}
			dressHash=(dressHash+1)%m;
		} while (dressHash != posInit);
		System.out.println("Elemento no encontrado...");
		return null;
	}

	
	public ArrayList<Element> getTable() {
		return table;
	}


	public void setTable(ArrayList<Element> table) {
		this.table = table;
	}


	public int Pliegues(int key) {
		int auxNum=key, sumaNumeros=0;
		while(auxNum>0) {
			sumaNumeros+=auxNum%1000;
			auxNum=auxNum/1000;
			
		}
		while (sumaNumeros>this.m) {
			sumaNumeros=sumaNumeros % m;
		}
		//System.out.println(sumaNumeros);
		return sumaNumeros;
		
	}
	private int linearProbing(int dressHash, int key) {
		int postInt = dressHash;
		do {
			if(table.get(dressHash).mark == 0)
				return dressHash;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.getKey() == key)
				return -2;
			dressHash = (dressHash + 1)% m;
		}while(dressHash != postInt);
		return -1;
	}
	
	public void insert(int key, T reg) {
		int dressHash = functionHash(key);
		dressHash = linearProbing(dressHash,key);
		if(dressHash == -1) {
			System.out.println("The key table is full");
			return;
		}
		else if(dressHash ==-2) {
			System.out.println("Key is duplicated");
			return;
		}
		else {
			Element aux = new Element(1, new Register<T>(key,reg));
			table.set(dressHash, aux);
		}
	}
	public void insertPliegues(int key, T reg) {
		int dressHash = Pliegues(key);
		dressHash = linearProbing(dressHash,key);
		if(dressHash == -1) {
			System.out.println("The key table is full");
			return;
		}
		else if(dressHash ==-2) {
			System.out.println("Key is duplicated");
			return;
		}
		else {
			Element aux = new Element(1, new Register<T>(key,reg));
			table.set(dressHash, aux);
		}
	}
	public void remove(int key) {
		int dressHash=functionHash(key);
		int posInit=dressHash;
		do {
			if(table.get(dressHash).mark==1 && table.get(dressHash).reg.getKey()==key) {
				System.out.println("Se encontró la clave");	
				System.out.println(table.get(dressHash).reg.getKey());
				table.get(dressHash).setMark(0);			
				return;}
			dressHash=(dressHash+1)%m;
		} while (dressHash != posInit);
		System.out.println("El elemento no se encuentra");
		return ;
	}
		
		

	
	@Override
	public String toString() {
		String s = "D.Real\tD.Hash\tRegister\n";
		int i = 0;
		for(Element item : table) {
			s += (i++) + "-->\t";
			if(item.mark == 1) 
				s += functionHash(item.reg.key)+"\t"+item.reg+"\n";
			else
				s += "empty\n";
		}
		return s;
	}
	
	
	
	
}