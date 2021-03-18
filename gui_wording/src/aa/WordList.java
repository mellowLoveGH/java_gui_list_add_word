package aa;

import java.util.ArrayList;
import java.util.List;

//this class used for storing the words
//and processing queries
public class WordList {

	private List<String> list;

	public WordList() {
		list = new ArrayList<String>();
	}
	
	// Add a word to the list
	public void add(String word) {
		list.add(word);
	}

	// Display all the words from the list that end with a specified letter
	public String display(char ch) {
		// number
		if (ch >= '0' && ch <= '9') {

		}
		// change upper case into lower case
		if (ch >= 'A' && ch <= 'Z') {
			ch = (char) ((ch - 'A') + 'a');
		}

		String str = "";

		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i).toLowerCase();
			int len = word.length();

			if (word.charAt(len - 1) == ch) {
				str = str + list.get(i) + " ";
			}
		}
		return str;
	}

	// Remove from the list all occurrences of a word entered in the text field
	public void remove(String word) {
		List<String> update = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String w = list.get(i);
			if (!w.equals(word)) {
				update.add(w);
			}
		}

		this.list = update;
	}

	// Clear the list
	public void clear() {
		list.clear();
	}

	// print the all words in the list
	public String toString() {
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			String w = list.get(i);
			str = str + w + " ";
		}
		return str;
	}

}
