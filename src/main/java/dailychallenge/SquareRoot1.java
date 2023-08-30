package dailychallenge;

public class SquareRoot1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 6;
		int i = 2;
		int result = 0;
		while (i <= x / 2) {
				//System.out.println(x/i);
			if (x / i == i) {//perfect square
				
				result = i;
				break;
				
			} else if (i * i < x && (i + 1) * (i + 1) > x) {
				
				result = i;
				break;
				
			}
			
			//result = i;
			i++;

		}

		System.out.println("Square root of the given number  " + x + " is " + result);

	}

}
