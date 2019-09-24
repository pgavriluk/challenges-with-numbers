package pavel.demo;

import java.util.HashMap;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);

        System.out.println(value);

        verifyNotNull("aaaa");
    }

    static void verifyNotNull(Object input){
        boolean enabled = false;
        assert enabled = true;
        assert enabled;
        System.out.println(input.toString());
        assert input !=null;
    }
}
