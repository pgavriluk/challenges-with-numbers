package pavel.demo;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateElementsInArray {

	private static int [] originalArray = new int[]{1, 2, 3, 4, 6, 6, 7, 9, 8, 3, 10, 11, 12, 13, 14, 1};

	public static void main(String args[]){
		long start = System.nanoTime();
		System.out.println(findDuplicateValues(originalArray));
		long end = System.nanoTime();
		System.out.println("Running time: " + ((end-start)/1e+6) + " milliseconds");

		start = System.nanoTime();
		System.out.println(findDuplicateValuesUsingReturnValueOfSet(originalArray));
		end = System.nanoTime();
		System.out.println("Running time: " + ((end-start)/1e+6)+ " milliseconds");

		start = System.nanoTime();
		System.out.println(bruteForce(originalArray));
		end = System.nanoTime();
		System.out.println("Running time: " + ((end-start)/1e+6)+ " milliseconds");
	}

	private static Set<Integer> findDuplicateValues(int [] input) {
		Set<Integer> values = new HashSet<>();
		Set<Integer> duplicateValues = new HashSet<>();

		values.add(input[0]);

		for (int i = 1; i < input.length; i++) {
			if(values.contains(input[i])){
				duplicateValues.add(input[i]);
			}

			values.add(input[i]);
		}

		return duplicateValues;
	}

	private static Set<Integer> findDuplicateValuesUsingReturnValueOfSet(int [] input) {
		Set<Integer> values = new HashSet<>();
		Set<Integer> duplicateValues = new HashSet<>();

		for (int value: input) {
			if(!values.add(value)){
				duplicateValues.add(value);
			}
		}

		return duplicateValues;
	}

	private static Set<Integer> bruteForce(int[] input) {
		Set<Integer> duplicateValues = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i] == input[j] && i != j) {
					duplicateValues.add(input[j]);
					break;
				}
			}
		}
		return duplicateValues;
	}

}
