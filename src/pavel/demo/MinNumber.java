package pavel.demo;

import java.util.Scanner;

public class MinNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter the amount of numbers you would like to find minimum number in:");
        int amount = scanner.nextInt();

        int[] array = getTheInputFromTheUser(amount);

        System.out.println("Minimum number is: " + findMinimum(array));

    }


    private static int[] getTheInputFromTheUser(int amount){

        int[] array = new int[amount];

        System.out.println("Enter your numbers");

        for(int i = 0; i< amount; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMinimum(int[] numbers){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i< numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return  min;
    }
}
