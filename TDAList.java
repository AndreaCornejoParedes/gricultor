
public interface TDAList<T> {
	boolean isEmptyList();
	int length();
	void destroyList();
	int search(T x);
	void insertLast(T x);
	void insertFirst(T x);
	void remove(T x);
	public String toString();
	

}
