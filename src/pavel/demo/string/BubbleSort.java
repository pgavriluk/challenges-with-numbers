package pavel.demo.string;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] data = {9, 5, 1, 4, 3, 10};
		bubbleSort(data);
		System.out.println("Sorted Array in Ascending Order: \n" + Arrays.toString(data));
	}

	private static void bubbleSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			boolean swapped = true;
			for (int j = 0; j < array.length - i - 1; j++)
				// To sort in descending order, change > to < in this line.
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = false;
				}
			if(swapped){
				break;
			}
		}
	}
}
