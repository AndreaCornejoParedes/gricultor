import java.util.Arrays;

public class ListArray <T> implements TDAList<T>{
	private T[] list;
	private int count;
	
	@SuppressWarnings("unchecked")
	public ListArray(int n) {
		this.count = 0;
		this.list = (T[]) new Object[n];
	}
	public boolean isEmptyList() {
		return (this.count==0);
	}
	public boolean isFull() {
		return (this.count==this.list.length);
	}
	public int length() {
		return this.count;
	}
	public void destroyList() {
		this.count=0;
	}
	public int search(T x) {
		for (int i=0;i<this.length();i++) 
			if (this.list[i].equals(x))
				return i;
		return -1;
	}
	public void insertFirst(T x) {
		if(this.isFull())
			System.out.println("List is full...");
		else {
			for (int i=this.length()-1;i>=0;i--)
				this.list[i+1]=this.list[i];
			this.list[0]=x;
			this.count++;
		}
	}
	public void insertLast(T x) {
		if(this.isFull())
			System.out.println("List is full...");
		else
			this.list[this.count++]=x;
	}
	public void remove(T x) {
		int pos=this.search(x);
		if (pos!=-1) {
			for(int i=pos;i<this.length();i++)
				this.list[i]=this.list[i+1];
			this.count--;
		}
		else {
			System.out.println("No se encuentra el elemento...");
		}
	}
	@Override
	public String toString() {
		String str="";
		for(int i=0;i<this.length();i++)
			str+="["+i+"] = "+this.list[i]+"\n";
		return str;
	}
	
}
