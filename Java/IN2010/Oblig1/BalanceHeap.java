import java.util.PriorityQueue;


public class BalanceHeap {
	
	public static void main(String[] args) {
		
		// fyller et array med n sorterte tall
		int n = 11;
		int[] test = new int[n];
		for (int i = 0; i < n; i++)
			test[i] = i;
		
		// Lager et PriorityQueue av de sorterte tallene
		PriorityQueue<Integer> input = new PriorityQueue<>();
		for (int i = 0; i < test.length; i++) {
			input.offer(test[i]);
		}
		
		printSorted(input);
	}

	private static void printMiddle(PriorityQueue<Integer> A) {
		
		// kopierer en av Heapene for å slippe å ødelegge de gamle.
		PriorityQueue<Integer> B = new PriorityQueue<>();
		PriorityQueue<Integer> next_A = new PriorityQueue<>(A);
		
		// Overfører fra den ene til den andre s.a. forskjellen i lengde er mindre enn 1.
		while (next_A.size() - B.size() > 1) {
			B.offer(next_A.poll());
		}
		
		
		// Printer det midterste elementet av inputtet A.
		if(next_A.size() > 0)
			System.out.println(next_A.poll());
		
		if(A.size() > 1)
			printMiddle(next_A);
		
		
		if(B.size() > 1)
			printMiddle(B);
		else if(B.size() == 1)
			System.out.println(B.poll());
	}
	
	public static void printSorted(PriorityQueue<Integer> input) {
		printMiddle(input);
		
	}
}
