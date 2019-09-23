package pavel.demo;

public class MyTest {

    public static void main(String[] args) {

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
