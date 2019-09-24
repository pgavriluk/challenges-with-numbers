package pavel.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class FindMissingNumber {

	private static int missingNumber = 25;

	private static int newSum;

	public static void main(String args[]){
		findMissingNumberUsingList();
		findMissingNumberUsingSet();
	}

	private static void findMissingNumberUsingList() {
		newSum = 0;
		List<Integer> listOfNumbers = new ArrayList<>();

		for (int i= 1; i<=100; i++){
			listOfNumbers.add(i);
		}

		Integer sum = countSum(listOfNumbers.size());

		listOfNumbers.remove(listOfNumbers.indexOf(missingNumber));

		for (int i = 0; i < listOfNumbers.size(); i++) {
			newSum += listOfNumbers.get(i);
		}

		System.out.println(newSum);

		System.out.println("Missing number using List is: " + (sum - newSum));
	}

	private static void findMissingNumberUsingSet() {
		newSum = 0;
		Set<Integer> setOfNumbers = new HashSet<>();

		for (int i= 1; i<=100; i++){
			setOfNumbers.add(i);
		}

		Integer sum = countSum(setOfNumbers.size());

		setOfNumbers.remove(missingNumber);

		for (int number: setOfNumbers) {
			newSum += number;
		}
		System.out.println(newSum);

		System.out.println("Missing number using Set is: " + (sum - newSum));
	}

	private static  Integer countSum(int numberOfMembers){
		Function<Integer,Integer> sumFunction = n-> n*(n+1)/2;

		Integer sum = sumFunction.apply(numberOfMembers);

		System.out.println(sum);

		return sum;
	}
}
