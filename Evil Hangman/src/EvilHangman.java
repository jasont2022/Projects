import java.util.*;

/**
 * This class is responsible for the logic of Hangman and the AI EvilHangman 
 * For more info please read: http://nifty.stanford.edu/2011/schwarz-evil-hangman/
 * 
 * @author jasontran
 */
public class EvilHangman {
	private int numGuessesLeft; // the number of guesses left
	private Set<String> words; // a set of words for AI
	private String currentBoard; // the current board of Hangman

	/**
	 * This constructor sets up the initial state of the game First, keep track of
	 * the desired word length Then set the number of guesses to 8 Construct a set
	 * of words based on the word length, so the AI can cheat Also, set up the
	 * current board with underscores of length of WordLength
	 * 
	 * @param wordsSet   - a Words Class that have a map of words and their lengths
	 * @param wordLength - the length of the words
	 * @throws IllegalArgumentException if wordsSet is null
	 */
	public EvilHangman(Words wordsSet, int wordLength) {
		if (wordsSet == null) {
			throw new IllegalArgumentException("Words is null!");
		}
		numGuessesLeft = 8;
		words = wordsSet.wordsWithWordLength(wordLength);
		currentBoard = "";
		for (int i = 0; i < wordLength; i++) {
			currentBoard += "_";
		}
	}

	/**
	 * This method returns the number of guesses remaining
	 * 
	 * @return an integer for the number of guesses left
	 */
	public int getNumGuessesLeft() {
		return numGuessesLeft;
	}

	/**
	 * This method gets a collections of words for the AI based on the wordLength
	 * This method is used for testing purposes
	 * 
	 * @return a collection of words
	 */
	public Collection<String> getWords() {
		Collection<String> allWords = new TreeSet<String>();
		for (String i : words) {
			allWords.add(i);
		}
		return allWords;
	}

	/**
	 * This method returns the current board
	 * 
	 * @return current board of Hangman
	 */
	public String getCurrentBoard() {
		return currentBoard;
	}

	/**
	 * This method set's the number of guesses left if the number of guesses left is
	 * between 0 and 8 Do Nothing if the guesses is not in bounds This method is
	 * important for reading in a file
	 * 
	 * @param guessesLeft the number of guesses left to read in
	 * @throw IllegalArgumentException if the guesses is out of bounds
	 */
	public void setNumGuessesLeft(int guessesLeft) {
		if (guessesLeft < 0 || guessesLeft > 8) {
			throw new IllegalArgumentException("Invalid Number for Guesses Left!");
		}
		numGuessesLeft = guessesLeft;
	}

	/**
	 * This method set's the current board to that string This method is important
	 * for reading in a file
	 * 
	 * @param currentBoard a current board to read in
	 * @throw IllegalArgumentException if the board is not characters between a to z
	 *        and _
	 */
	public void setCurrentBoard(String board) {
		for (int i = 0; i < board.length(); i++) {
			int c = board.charAt(i);
			if (c < 95 || c == 96 || c > 122) {
				throw new IllegalArgumentException("Invalid Characters for Board!");
			}
		}
		currentBoard = board;
	}

	/**
	 * This method generates a single candidate board, when a user types in a
	 * character, we get a word and character and see if that word contains that
	 * character, if the word contains that character, we will return an updated
	 * board, if not we will return the original board
	 * 
	 * @param c    a letter character to be passed into the function
	 * @param word a word from the set of words
	 * @return a candidate board
	 */
	public String getCandidateBoard(char c, String word) {
		String board = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				board += c;
			} else {
				board += currentBoard.charAt(i);
			}
		}
		return board;
	}

	/**
	 * This method generates all possible word families based on a given character
	 * Basically, this method partitions the words in the dictionary into groups by
	 * word family The keys are each candidate board and values are word groups/word
	 * families that match that board character and position exactly
	 * 
	 * @param c a letter character to be passed into the function
	 * @return all the current possibilities the word set can be
	 */
	public Map<String, Set<String>> getCurrentPossibilities(char c) {
		Map<String, Set<String>> currentPossibilities = new TreeMap<String, Set<String>>();
		for (String i : words) {
			String candidateBoard = getCandidateBoard(c, i);
			if (!currentPossibilities.containsKey(candidateBoard)) {
				Set<String> values = new TreeSet<String>();
				values.add(i);
				currentPossibilities.put(candidateBoard, values);
			} else {
				currentPossibilities.get(candidateBoard).add(i);
			}
		}
		return currentPossibilities;
	}

	/**
	 * This method updates the words set and the current board. First, find the
	 * maximum size of the sets in the map If the set has a maximum size in the map,
	 * update words to reflect the set The possible board with the most words
	 * (largest word family) Then update the current board Lastly, if the updated
	 * current board has all underscores, then decrement the number of guesses
	 * 
	 * @param c a letter character to be passed into the function
	 */
	public void acceptGuess(char c) {
		Map<String, Set<String>> currentPossibilities = getCurrentPossibilities(c);
		int maxSize = Integer.MIN_VALUE;
		for (Map.Entry<String, Set<String>> entry : currentPossibilities.entrySet()) {
			if (entry.getValue().size() > maxSize) {
				maxSize = entry.getValue().size();
				words.clear();
				words.addAll(entry.getValue());
				currentBoard = entry.getKey();
			}
		}
		if (!currentBoard.contains(c + "")) {
			numGuessesLeft = numGuessesLeft - 1; // keep decreasing the guess
			if (numGuessesLeft < 0) {
				numGuessesLeft = 0; // clip the guesses left if its below 0
			}
		}
	}

	/**
	 * This method reveals a single word at the end of the game
	 * 
	 * @return a word to reveal to the player null if words is empty
	 */
	public String revealWord() {
		for (String i : words) {
			return i;
		}
		return null;
	}
}
