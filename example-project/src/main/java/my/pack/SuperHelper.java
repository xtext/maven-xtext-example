package my.pack;

public class SuperHelper {

	private SuperHelper() {
		// Only static methods
	}

	public static String process(String s) {
		return s.toUpperCase();
	}

}
