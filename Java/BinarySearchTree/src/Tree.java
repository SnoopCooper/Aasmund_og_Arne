
public class Tree<T extends Comparable> {
	Node<T> head = null;
	
	Tree(T[] input){
		for(int i = 0; i < input.length; i++) {
			insert(input[i]);
		}
	}
	
	public void insert(T value) {
		if(head == null) {
			head.setValue(value);
		}
		else 
		{
			boolean arne_rocker = true;
			Node<T> current = head;
			while(arne_rocker) {
				if(current.value.compareTo(value) < 0) {
					if (current.lower == null) {
						current.lower.setValue(value);
						arne_rocker = false;
					} else {
						current = current.lower;
					}
				} else {
					if (current.upper == null) {
						current.upper.setValue(value);
						arne_rocker = false;
					} else {
						current = current.upper;
					}
				}
			}
		}
		
		
	}
	
	
	
}
