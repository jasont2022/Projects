import java.util.*;

/**
 * This class is responsible for takings words from a file and putting them 
 * into a map and also keeping track of the word lengths, this class
 * is basically an iterator to read from a file
 * @author jasontran
 */
public class Words {
	private Map<String, Integer> wordMap; //a map containing words and their length
	
	/**
	 * This Constructor takes in all of the words from a file, putting them into a
	 * map which the keys are words and values are the words' length
	 * @param filePath a file in the files path
	 * @throws IllegalArgumentException if the filePath is null or does not exist
	 */
	public Words(String filePath) {
		wordMap = new TreeMap<String, Integer>();
		WordScanner ws = new WordScanner(filePath);
		while(ws.hasNext()) {
			String word = ws.next();
			wordMap.put(word, word.length());
		}
	}
	
	/**
	 * This method returns a wordMap for testing purposes
	 * @return a wordMap
	 */
	public Map<String, Integer> getWordMap() {
		return wordMap;
	}
	
	/**
	 * This method determines if the words have the wordLength desired
	 * @param wordLength an integer denoting a word length
	 * @return true if there are words of a wordLength
	 * 		   false otherwise
	 */
	public Boolean isValidWordLength(int wordLength) {
		return wordMap.containsValue(wordLength);
	}
	
	/**
	 * This method generates a set of words of the wordLength desired
	 * @param wordLength  an integer denoting a word length
	 * @return a Set of words of that word length
	 */
	public Set<String> wordsWithWordLength(int wordLength) {
		Set<String> newWords = new TreeSet<String>();
		for (Map.Entry<String,Integer> entry : wordMap.entrySet()) {
			if (entry.getValue() == wordLength) {
				newWords.add(entry.getKey());
			}
		}
		return newWords;
 	}
}