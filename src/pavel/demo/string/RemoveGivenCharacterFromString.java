package pavel.demo.string;

public class RemoveGivenCharacterFromString {

	static String originalString = "Thisssss is an original String";

	public static void main(String[] args) {
		System.out.println(removeGivenCharacterFromString(originalString, "s"));
		System.out.println(removeGivenCharacterFromStringRecursively(originalString, "s"));
	}

	private static String removeGivenCharacterFromString(String str, String charToRemove) {
		StringBuilder result = new StringBuilder();

		char[] chars = str.toLowerCase().toCharArray();

		for (char c: chars) {
			if(c != charToRemove.charAt(0)){
				result.append(c);
			}
		}

		return result.toString();
	}

	private static String removeGivenCharacterFromStringRecursively(String str, String charToRemove){
		return removeCharRecursively(str.toLowerCase(), charToRemove);
	}

	private static String removeCharRecursively(String str, String charToRemove) {
		int index = str.indexOf(charToRemove.charAt(0));
		if(index == -1){
			return str;
		} else {
			return removeCharRecursively(str.substring(0, index) + str.substring(index+1), charToRemove);
		}
	}

}
