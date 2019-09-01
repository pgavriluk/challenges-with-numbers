package pavel.demo;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    private static Scanner scanner = new Scanner(System.in);

    private static int[] array;
    private static int[] reverseArray;

    public static void main(String[] args) {

        System.out.println("Please enter the size of Array:");
        int amount = scanner.nextInt();
        array = new int[amount];
        getTheInputFromTheUser(amount);
        System.out.println("The original Array is : " + Arrays.toString(array));

        reverse(array);

        System.out.println("The reverse Array is : " + Arrays.toString(reverseArray));

    }


    private static void getTheInputFromTheUser(int amount){

        System.out.println("Please enter the list of numbers you would like to reverse:");

        for(int i = 0; i< amount; i++){
            array[i] = scanner.nextInt();
        }
    }

    private static void reverse(int[] array){

        // first option
        reverseArray = new int[array.length];

        for(int i = array.length-1; i>= 0; i--){
            reverseArray[reverseArray.length-1-i] = array[i];
        }

        // second option without using second Array
        int maxIndex = array.length -1;
        int halfLength = array.length/2;
        for (int i=0; i< halfLength; i++){
            int temp = array[i];
            array[i] = array[maxIndex-i];
            array[maxIndex-i] = temp;
        }

    }
}
