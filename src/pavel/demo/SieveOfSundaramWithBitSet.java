package pavel.demo;

import java.util.BitSet;
import java.util.Scanner;

public class SieveOfSundaramWithBitSet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the range. Any number greater than 2: ");
		int input = scanner.nextInt();
		if (input < 2){
			System.out.println("Invalid number. Program will exit");
		}else{
			generatePrime(input);
		}

		scanner.close();
	}

	private static void generatePrime(int max) {

		int counter = 1;
		// Because the number can be 2n+2 for a given n
		// and we want a prime number less than n,
		// we reduce it to half
		int bSize = (max - 2) / 2;

		// BitSet created with a specific size
		// with default value initialized as false
		BitSet bitSet = new BitSet(bSize);

		// set the index number of the form
		// (i + j + 2ij) as true such that 1<=i<=j
		// this is the main logic of the Sieve of Sundaram
		for (int i = 1; i <= bSize; i++)
			for (int j = i; (i + j + 2 * i * j) <= bSize; j++){
				bitSet.set(i + j + 2 * i * j);
			}

		// explicitly 2 is printed because
		// odd prime numbers below 2n+2 excludes 2
		if (max > 2){
			System.out.print("2\t");
		}


		// Now print the odd prime list, with a little
		// formatting for eye-candy.
		for (int i = 1; i <= bSize; i++) {
			if (!bitSet.get(i)) {
				System.out.print((2 * i + 1));
				System.out.print(++counter % 9 == 0 ? "\n" : "\t");
			}
		}
		System.out.print("\n");
	}
}
