package pavel.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {


		List<Integer> arrayList = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 100; i++){
			arrayList.add(random.nextInt());
		}

		int[] nums = arrayList.stream().mapToInt(Integer::intValue).toArray();

		int[] result = mergeSort(nums);

		for (int i: result) {
			System.out.println(i);
		}

	}


	private static int[] mergeSort(int[] arrayToSort) {

		if (arrayToSort.length < 2) {
			return arrayToSort;
		}

		int midIndex = arrayToSort.length / 2;

		int[] left  = Arrays.copyOfRange(arrayToSort, 0, midIndex);
		int[] right = Arrays.copyOfRange(arrayToSort, midIndex, arrayToSort.length);

		int[] sortedLeft  = mergeSort(left);
		int[] sortedRight = mergeSort(right);

		int[] sortedArray = new int[arrayToSort.length];

		int currentLeftIndex  = 0;
		int currentRightIndex = 0;

		for (int currentSortedIndex = 0; currentSortedIndex < arrayToSort.length; currentSortedIndex++) {

			if (currentLeftIndex < sortedLeft.length && (currentRightIndex >= sortedRight.length
					|| sortedLeft[currentLeftIndex] < sortedRight[currentRightIndex])) {
				sortedArray[currentSortedIndex] = sortedLeft[currentLeftIndex];
				currentLeftIndex++;
			} else {
				sortedArray[currentSortedIndex] = sortedRight[currentRightIndex];
				currentRightIndex++;
			}
		}

		return sortedArray;
	}
}
