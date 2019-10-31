package pavel.demo;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {


		List<Integer> arrayList = new ArrayList<>();
		for(int i = 0; i < 100; i++){
			arrayList.add(i);
		}

		int[] nums = arrayList.stream().mapToInt(Integer::intValue).toArray();

		binarySearch(21, nums);

	}


	private static boolean binarySearch(int target, int[] nums) {

		int floorIndex = -1;
		int ceilingIndex = nums.length;

		while (floorIndex + 1 < ceilingIndex) {

			int distance = ceilingIndex - floorIndex;
			int halfDistance = distance / 2;
			int guessIndex = floorIndex + halfDistance;

			int guessValue = nums[guessIndex];

			if (target == guessValue) {
				return true;
			}

			if (target < guessValue) {
				ceilingIndex = guessIndex;

			} else {
				floorIndex = guessIndex;
			}
		}

		return false;
	}
}
