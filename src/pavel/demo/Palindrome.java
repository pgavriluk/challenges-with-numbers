package pavel.demo;

public class Palindrome {

    private static String str = "alla";

    public static void main(String args[]){
        System.out.println("Is '" + str + "' palindrome? " + isPalindromeString(str));
    }

    private static boolean isPalindromeString(String str) {
        String reverse = reverse(str);
        if(str.equals(reverse)){
            return true;
        }
        return false;
    }

    private static String reverse(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }

        return str.charAt(str.length() - 1) + reverse(str.substring(0,str.length()-1));
    }

}
