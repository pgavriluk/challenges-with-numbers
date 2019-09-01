package pavel.demo;

import java.util.Scanner;

public class MaxNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter the amount of numbers you would like to find maximum number in:");
        int amount = scanner.nextInt();

        int[] array = getTheInputFromTheUser(amount);

        System.out.println("Maximum number is: " + findMaximum(array));

    }


    private static int[] getTheInputFromTheUser(int amount){

        int[] array = new int[amount];

        System.out.println("Enter your numbers");

        for(int i = 0; i< amount; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMaximum(int[] numbers){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return  max;
    }
}
