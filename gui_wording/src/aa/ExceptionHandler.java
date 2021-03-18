package aa;

//ExceptionHandler should have been written as a class extending Exception
//while here, for simplicity and convenience
//just write this class providing a static method for error checking

public class ExceptionHandler {

	// Words may contain only letters, numbers, and hyphens (-)
	// and must begin with a letter.
	public static boolean wordCheck(String word) {
		char ch = word.charAt(0);
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

			for (int i = 1; i < word.length(); i++) {
				char c = word.charAt(i);
				if (c >= '0' && c <= '9') {

				} else if (c >= 'a' && c <= 'z') {

				} else if (c >= 'A' && c <= 'Z') {

				} else if (c == '-') {

				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean isValidChar(String str) {
		if(str.length() == 1) {
			char c = str.charAt(0);
			if (c >= '0' && c <= '9') {
				return true;
			} else if (c >= 'a' && c <= 'z') {
				return true;
			} else if (c >= 'A' && c <= 'Z') {
				return true;
			} else if (c == '-') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidColor(int r, int g, int b) {
		if(r < 0 || g < 0 || b < 0) {
			return false;
		}
		if(r > 200 || g > 200 || b > 200) {
			return false;
		}
		
		return true;
	}
	
}
