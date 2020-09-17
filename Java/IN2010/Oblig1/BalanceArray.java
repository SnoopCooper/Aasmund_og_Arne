public class BalanceArray {
	
	static private int[] output;
	static private int i;
	
	public static void main(String[] args) {
		
		int[] test = new int[11];
		
		// fyller en array med sorterte tall
		for(int i = 0; i < test.length; i++) {
			test[i] = i;
		}
		
		// sorterer.
		int[] output = BalanceArray.balanceArray(test);
		
		// printer
		for (i = 0; i < output.length;i++) {
			System.out.println(output[i]);
		}
	}
	
	static private void balance(int[] input, int current, int left, int right) {
		// inserter verdien for indeksen vi er på i input.
		output[i++] = input[current];
		
		// tester om det er nok elementer på høyre og venstre side til å forsette den veien.
		if (right > 1) {
			// Beregner variabler for neste kall av balance.
			int next_cur_r = current + (right+2)/2;
			int next_left_r = next_cur_r - current - 1;
			int next_right_r = right - next_left_r - 1;
			
			balance(input, next_cur_r, next_left_r, next_right_r);
		} else if (right == 1) {
			output[i++] = input[current + 1];
		}
		
		if (left > 1) {
			// Beregner variabler for neste kall av balance.
			int next_cur_l = current - (left+1)/2;
			int next_right_l = current - next_cur_l - 1;
			int next_left_l = left - next_right_l - 1;
			
			balance(input, next_cur_l, next_left_l, next_right_l);
		} else if (left == 1) {
			output[i++] = input[current - 1];
		}
	}
	
	static private int[] balanceArray(int[] input) {
		// Kontrollerer at det er lovlig input.
		if (input.length <= 0)
			return new int[0];
		
		output = new int[input.length];
		i = 0;
		
		// Beregner verdier for første kall av balance.
		int middle = (input.length-1)/2;
		int left = middle;
		int right = input.length - middle -1;
		
		balance(input, middle, left, right);
		return output;
	}
}
