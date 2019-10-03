package pavel.demo;

public class FibonacciRecursive {

	private static int counter = 2;
	private static int position = 8;

	public static void main(String args[]){
		printFibonacciSeriesToNumber(50); // 1,1,2,3,5,8,13,21,34

		System.out.println("The Fibonacci number in the Fibonacci series in position " + position + " is " + fibonacci(position));
	}

	private static void printFibonacciSeriesToNumber(int number) {
		System.out.println("Fibonacci Series To Number " + number + " is:");
		System.out.print(1 + "\t");
		System.out.print(1 + "\t");

		fibonacci(1, 1, number);
	}

	private static int fibonacci(int previousNumber, int currentNumber, int maxNumber) {
		int nextNumber = previousNumber + currentNumber;
		if(nextNumber > maxNumber){
			System.out.println();
			return currentNumber;
		}

		System.out.print(nextNumber);
		System.out.print(++counter % 9 == 0 ? "\n" : "\t");

		return fibonacci(currentNumber, nextNumber, maxNumber);
	}

	private static int fibonacci(int number){
		if(number < 1){
			throw new IllegalArgumentException("Invalid argument for Fibonacci series: " + number);
		}

		if(number == 1 || number == 2){
			return 1;
		}

		return fibonacci(number-2) + fibonacci(number -1);
	}

}
