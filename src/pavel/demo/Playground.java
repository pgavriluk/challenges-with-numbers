package pavel.demo;

import pavel.demo.bill.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Playground {


    private static final String OPEN_BRACKETS = "({[";
    private static final String CLOSE_BRACKETS = ")}]";

    public static void main(String[] args) throws IOException {

        MealOrder mainOrder = new MealOrder();

        Meal meal = new Meal(new Hamburger("Best burger", 12.49, false),
                new Drink("water", "large"), new Item("Fried Onions", 3.49));
        meal.getHamburger().addTopping("Lettuce").addTopping("Cucumber").addTopping("Tomato").addTopping("Tomato");
        mainOrder.add(meal);

        Meal deluxeMeal = new Meal(new Hamburger(true),
                new Drink("Vodka", "Medium"), new Item("Fries", 1.49));
        deluxeMeal.getHamburger().addTopping("Lettuce").addTopping("Cucumber").addTopping("Tomato").addTopping("Onion")
                .addTopping("Onion").addTopping("Onion");
        mainOrder.add(deluxeMeal);

        System.out.println(mainOrder);

        // printSquareStar(5);
        //System.out.println(validBrackets("{{}}()"));
        //fibonacci(100);
        //permute("xyz", "");
        //System.out.println(uniqueChar("qqwweerrtyty"));
    }


    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        double wallArea = width * height;
        int bucketsNeeded = (int) Math.ceil(wallArea / areaPerBucket);
        int bucketsToBuy = bucketsNeeded - extraBuckets;

        return Math.max(bucketsToBuy, 0); // Ensure no negative values
    }


    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        return (int) Math.ceil(area / areaPerBucket);
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        long avg = 0;  // Store the final rounded average

        while (scanner.hasNextInt()) { // Only read valid integers
            int number = scanner.nextInt();
            sum += number;
            count++;
        }

        if (count > 0) {
            avg = Math.round((double) sum / count); // Ensure correct rounding
        }

        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close(); // Close scanner to prevent resource leak
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i <= number; i++) { // print rows
            for (int j = 1; j <= number; j++) { //print column
                if (i == 1 || i == number || j == 1 || j == number || i == j || j == number - i + 1) { // print first and last row and column
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int getLargestPrime(int number) {
        if (number <= 1) {
            return -1; // handle invalid input
        }

        int largestPrime = -1;

        // Remove all factors of 2 first (handle even numbers separately)
        while (number % 2 == 0) {
            largestPrime = 2;
            number /= 2;
        }

        // Check odd factors from 3 onwards (skip even numbers)
        for (int i = 3; i * i <= number; i += 2) {
            while (number % i == 0) {
                largestPrime = i; // Store the prime factor
                number /= i;      // Reduce number
            }
        }

        // If there's a remaining prime factor greater than sqrt(N), it's the largest
        if (number > 2) {
            largestPrime = number;
        }

        return largestPrime;
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false; // Handle invalid negative values
        }
        int bigBag = 5;

        // Use as many big bags as possible without exceeding the goal
        int maxBigBagsUsed = Math.min(bigCount, goal / bigBag);
        int remainingWeight = goal - (maxBigBagsUsed * bigBag);

        // If the remaining weight can be covered by small bags, return true
        return smallCount >= remainingWeight;
    }

    public static void numberToWords(int number) {
        int originalDigitCount = getDigitCount(number);
        int digitCount = 0;
        int reversedNumber = reverse(number);
        StringBuilder words = new StringBuilder();
        while (reversedNumber != 0) {
            int lastDigit = reversedNumber % 10;
            digitCount++;
            switch (lastDigit) {
                case 0 -> words.append("Zero ");
                case 1 -> words.append("One ");
                case 2 -> words.append("Two ");
                case 3 -> words.append("Three ");
                case 4 -> words.append("Four ");
                case 5 -> words.append("Five ");
                case 6 -> words.append("Six ");
                case 7 -> words.append("Seven ");
                case 8 -> words.append("Eight ");
                case 9 -> words.append("Nine ");
                default -> words.append("Negative ");
            }
            reversedNumber /= 10;
        }

        while (originalDigitCount > digitCount) {
            words.append("Zero ");
            digitCount++;
        }
        System.out.println(words);
    }

    public static int reverse(int number) {
        int reverse = 0;
        boolean isNegative = number < 0;
        number = Math.abs(number); // Convert to positive
        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }

        return isNegative ? -reverse : reverse;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static int getGreatestCommonDivisoRecursion(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        return gcd(second, first % second);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a; // Base case: GCD found
        }
        return gcd(b, a % b); // Recursive call
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;

                // Add the corresponding divisor (excluding 'number' itself)
                int correspondingDivisor = number / i;
                if (number != correspondingDivisor && i != correspondingDivisor) {
                    sum += correspondingDivisor;
                }
            }
        }

        return sum == number;
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }

        return first;
    }

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i * i <= number; i++) { // Loop until sqrt(number)
            if (number % i == 0) { // If 'i' is a factor
                System.out.println(i); // Print 'i'

                if (i != number / i) { // Avoid duplicate when 'i' is sqrt(number)
                    System.out.println(number / i); // Print the corresponding factor
                }
            }
        }
    }


    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int lastDigit = number % 10;

        while (number >= 10) {
            number /= 10;
        }

        return number + lastDigit;
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }

        return original == reversed;
    }


    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }
        if (year < 1 || year > 9999) {
            return -1;
        }

        return switch (month) {
            case 1, 3, 5, 7, 8, 9, 11, 12 -> 31;
            case 4, 6, 10 -> 30;
            case 2 -> {
                int d;
                if (isLeapYear(year)) {
                    d = 29;
                } else {
                    d = 28;
                }
                ;
                yield d;
            }
            default -> -1;
        };

    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        long hours = minutes / 60;
        long days;
        long years = 0;
        long remainingDays = 0;
        if (hours >= 24) {
            days = hours / 24;
            if (days >= 365) {
                years = days / 365;
                remainingDays = days % 365;
            } else {
                remainingDays = days;
            }
        }

        System.out.println("" + minutes + " min = " + years + " y and " + remainingDays + " d");


    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Received negative number for seconds:" + seconds;
        }
        int minutes = seconds / 60;
        int remainderSeconds = seconds % 60;
        return getDurationString(minutes, remainderSeconds);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Received negative number for minutes:" + minutes;
        }
        if (seconds < 0 || seconds > 59) {
            return "Wrong number of seconds: " + seconds;
        }
        int hours = minutes / 60;
        int remainderMinutes = minutes % 60;
        return "" + hours + "h " + remainderMinutes + "m " + seconds + "s";
    }

    public static boolean hasTeen(int num1, int num2, int num3) {
        return isTeen(num1) || isTeen(num2) || isTeen(num3);
    }

    public static boolean isTeen(int num) {
        System.out.println(num >= 13 && num <= 19);
        return num >= 13 && num <= 19;
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        long milesPerHour = -1;
        if (kilometersPerHour < 0.0) {
            return milesPerHour;
        } else {
            milesPerHour = Math.round(kilometersPerHour / 1.609);
        }

        return milesPerHour;
    }

    public static void printConversion(double kilometersPerHour) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour == -1) {
            System.out.println("Invalid Value");
        }
        System.out.println("" + kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
    }

    private static char uniqueChar(String str) {
        int[] index = new int[26];

        for (char c : str.toCharArray()) {
            index[c - 'a']++;
        }

        for (int i = 0; i < index.length; i++) {
            if (index[i] == 1) {
                return (char) (i + 97);
            }
        }


        return (char) -1;
    }


    private static void permute(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            String rest = str.substring(0, i) + str.substring(i + 1);
            permute(rest, ans + c);
        }
    }


    public static boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int partSum = sum / 3;
        int counter = 0;
        sum = 0;

        for (int i : arr) {
            sum += i;
            if (sum == partSum) {
                sum = 0;
                counter++;
            }
        }

        return counter >= 3;
    }


    private static void fibonacci(int n) {
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("1");
        int counter = 0;

        while (counter < n) {
            System.out.print(num1 + " ");
            BigInteger next = num1.add(num2);
            num1 = num2;
            num2 = next;
            counter++;
        }
    }

    private static boolean validBrackets(String str) {
        if (str.length() == 0 || str.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return OPEN_BRACKETS.indexOf(c) != -1;
    }

    private static boolean isMatching(char open, char close) {
        return OPEN_BRACKETS.indexOf(open) == CLOSE_BRACKETS.indexOf(close);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }

        return false;
    }


    public static char findTheDifference(String s, String t) {
        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        char ch = 0;

        // XOR all the characters of both s and t.
        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ch ^= t.charAt(i);
        }

        // What is left after XORing everything is the difference.
        return ch;
    }

    public static char findTheDifference2(String s, String t) {
        int sum = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
            sum += t.charAt(i);
        }

        return (char) sum;
    }

    public static boolean backspaceCompare(String s, String t) {
        String cleanedS = cleanString(s);
        String cleanedT = cleanString(t);

        return cleanedS.equals(cleanedT);
    }


    private static String cleanString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int backspaces = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            while (i >= 0 && str.charAt(i) == '#') {
                backspaces++;
                i--;
            }

            while (backspaces > 0 && str.charAt(i) != '#') {
                i--;
                backspaces--;
            }

            if (i >= 0 && str.charAt(i) != '#') {
                stringBuilder.append(str.charAt(i));
            } else if (i >= 0 && str.charAt(i) == '#') {
                i++;
            }

        }

        return stringBuilder.reverse().toString();
    }

    public static String pigIt(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    public static String pigIt2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                stringBuilder.append(c + "ay ");
                c = chars[++i];
            } else {
                stringBuilder.append(chars[i]);
            }

        }
        if (!"[.!?\\-]".contains(c + "")) {
            stringBuilder.append(c + "ay");
        } else {
            stringBuilder.append(c + "");
        }

        return stringBuilder.toString();
    }


    public static String reverseWords2(String s) {
        String str[] = s.split("\\s+");
        String ss1 = "";
        for (int i = str.length - 1; i >= 0; i--)
            ss1 += str[i] + " ";
        return ss1.trim();
    }

    public static int sortDesc2(final int num) {
        String[] array = String.valueOf(num).split("");
        Arrays.sort(array, Collections.reverseOrder());
        return Integer.valueOf(String.join("", array));
    }

    public static boolean check2(String sentence) {
        String loweredInput = sentence.toLowerCase();
        return IntStream.range('a', 'z' + 1).allMatch(a -> loweredInput.indexOf(a) >= 0);
    }

    public static boolean isPalindrome3(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome2(String s) {
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }

        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();

        return filteredString.equals(reversedString);
    }

    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        s.chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(builder::append);

        return builder.toString().equals(builder.reverse().toString());
    }

    private static int[] getSmallestAndSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            }
            if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }


        int[] result = {smallest, secondSmallest};
        System.out.println(smallest);
        System.out.println(secondSmallest);

        return result;
    }


    private static List<String> validate(String sentence) {
        List<String> result = new ArrayList<>();

        if (sentence.length() == 0) {
            return result;
        }

        String[] words = sentence.split(" ");


        for (String word : words) {
            char c = word.charAt(0);
            if (!Character.isUpperCase(c)) {
                result.add(word.replaceAll("\\W+", ""));
            }
        }

        return result;
    }

}
