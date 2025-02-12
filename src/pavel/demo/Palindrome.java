package pavel.demo;

public class Palindrome {

    public static void main(String[] args) {
        int x = 1211121;

        System.out.println(isPalindrome(x));

    }

    public static boolean isPalindrome(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;
        int original = x;


        while (x != 0) {
            int last = x % 10;
            reverse = reverse * 10 + last;
            x /= 10;
        }


        return original == reverse;
    }

}
