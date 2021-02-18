package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	T t[];
	public ArrayList() {
	t = (T[]) new Object[0];
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		
		return t[loc];
	}
	
	public void add(T val) {
		T t2[] = (T[]) new Object[t.length + 1];
		for (int i = 0; i < t.length; i++) {
			t2[i] = t[i];
		}
		t2[t.length] = val;
		t = t2;
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		if(loc < 0 || loc > t.length - 1) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		T t2[] = (T[]) new Object[t.length + 1];
		for (int i = 0; i < t2.length; i++) {
			if(i == loc) {
				t2[loc] = val;
				}else {
					t2[i] = t[counter++];
				}
	}
		t = t2;
		}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		
		t[loc] = val;
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		T t2[] = (T[]) new Object[t.length];
		T t3[] = (T[]) new Object[t.length - 1];
		for (int i = 0; i < t2.length; i++) {
			t2[i] = t[i];
		}
		for (int i = 0; i < t2.length; i++) {
			if(i > loc) {
				t2[i - 1] = t2[i];
				}
			}
		for (int i = 0; i < t3.length; i++) {
			t3[i] = t2[i];
		}
		t = t3;
	}
	
	public boolean contains(T val) {
		for (int i = 0; i < t.length; i++) {
			if(t[i] == val) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		
		return t.length;
	}
}