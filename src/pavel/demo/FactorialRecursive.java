package pavel.demo;

public class FactorialRecursive {

	static int number = 4;

	public static void main(String args[]){
		System.out.println("Factorial of number " + number + " is: " + factorial(number));
	}

	private static int factorial(int number) {
		int sum = number * (number -1);
		if(number <= 0){
			return 1;
		}

		return  sum == 0 ? 1 : sum  * factorial(number-2);
	}
}
