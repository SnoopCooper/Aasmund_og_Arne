
public class Node<T extends Comparable> {
	T value = null;
	Node<T> upper;
	Node<T> lower;
	Node<T> mother;
	
	Node (T val){
		value = val;
	}
	
	public void setValue(T val) {
		value = val;
	}
	
}
