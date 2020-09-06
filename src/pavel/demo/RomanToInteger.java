package pavel.demo;


import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> romanTable = new HashMap<>();
        romanTable.put("I", 1);
        romanTable.put("V", 5);
        romanTable.put("X", 10);
        romanTable.put("L", 50);
        romanTable.put("C", 100);
        romanTable.put("D", 500);
        romanTable.put("M", 1000);

        String[] romanNumber = s.toUpperCase().split("");

        String previous = romanNumber[0];
        for (String value : romanNumber) {
            if ((value.equals("V") || value.equals("X")) && previous.equals("I")) {
                result += romanTable.get(value);
                result -= romanTable.get(previous) * 2;
            } else if ((value.equals("L") || value.equals("C")) && previous.equals("X")) {
                result += romanTable.get(value);
                result -= romanTable.get(previous) * 2;
            } else if ((value.equals("D") || value.equals("M")) && previous.equals("C")) {
                result += romanTable.get(value);
                result -= romanTable.get(previous) * 2;
            } else {
                result += romanTable.get(value);
            }

            previous = value;
        }

        return result;
    }

}
