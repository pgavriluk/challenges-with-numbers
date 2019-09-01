package pavel.demo;

import java.util.Arrays;
import java.util.Scanner;

public class ResizeArray {

	private static Scanner scanner = new Scanner(System.in);

	private static int[] array;

	public static void main(String[] args) {

		array = new int[10];
		getTheInputFromTheUser(array.length);
		System.out.println("The original Array is : " + Arrays.toString(array));

		resizeArrayTo(12);

		array[10] = 33;
		array[11] = 44;
		System.out.println("Two elements were added");
		System.out.println("The new Array is : " + Arrays.toString(array));

	}


	private static void getTheInputFromTheUser(int amount) {

		System.out.println("Please enter " + amount + " integers: ");

		for (int i = 0; i < amount; i++) {
			array[i] = scanner.nextInt();
		}
	}

	private static void resizeArrayTo(int newSize) {

		int[] original = array;

		array = new int[newSize];
		if (array.length >= original.length) {
			for (int i = 0; i < original.length; i++) {
				array[i] = original[i];
			}
 		}else{
			for (int i = 0; i < array.length; i++) {
				array[i] = original[i];
			}
		}

	}
}
