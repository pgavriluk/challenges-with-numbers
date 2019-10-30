package pavel.demo.string;

public class StringPermutations {

	public static void main(String[] args) {
		permutation("123");
	}

	private static void permutation(String input) {
		permutation("", input);
	}

	private static void permutation(String perm, String str) {
		if (str.isEmpty()) {
			System.out.println(perm);
		} else {
			for (int i = 0; i < str.length(); i++){
				permutation(perm + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			}
		}
	}
}


