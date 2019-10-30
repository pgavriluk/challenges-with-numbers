package pavel.demo.string;

import java.util.Arrays;

public class InsertionSort {


	public static void main(String[] args) {
		int[] data = {9, 5, 1, 4, 3, 10};
		insertionSort(data);
		System.out.println("Sorted Array in Ascending Order: \n" + Arrays.toString(data));
	}


	private static void insertionSort(int[] array) {

		for (int step = 1; step < array.length; step++) {
			int x = step;
			int key = array[step];
			while (x > 0 && key < array[x-1]) {
				array[x] = array[x-1];
				x--;
			}
			array[x] = key;
		}
	}

}
