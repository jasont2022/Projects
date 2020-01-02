import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class uses a BufferedReader to read in lines
 * of words for the EvilHangman AI 
 * reads a line whenever the next() method is called
 * where the line is a word
 * @author jasontran
 */
public class WordScanner implements Iterator<String>{
	private BufferedReader r; // a BufferReader
	private String next; // next line of file
	
	/**
	 * Creates a WordScanner for the file located at filePath 
	 *
	 * If an IOException is thrown by the BufferedReader or FileReader, then set
	 * next to null.
	 *
	 * @param filePath - the path to the file to be turned to an Iterator
	 * @throws IllegalArgumentException if filePath is null or if the file doesn't
	 *         exist
	 */
	public WordScanner(String filePath) {
		if (filePath == null) {
			throw new IllegalArgumentException("File Path is null!");
		}
		try {
			r = new BufferedReader(new FileReader(filePath));
			next = r.readLine();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File is not found!");
		} catch (IOException e) {
			next = null;
		}
	}
	
	/**
	 * Returns true if there are lines left to read in the file, and false
	 * otherwise.
	 * 
	 * If there are no more lines left, this method should close the BuffereReader
	 *
	 * @return a boolean indicating whether the WordScanner can produce another
	 *         line from the file
	 */
	@Override 
	public boolean hasNext() {
		if (next == null) {
			try {
				r.close();
			} catch (IOException e) {
				return false;
			}
		}
		return next != null;
	}
	
	/**
	 * Returns the next line from the file, or throws a NoSuchElementException if
	 * there are no more strings left to return (i.e. hasNext() is false).
	 * 
	 * This method also advances the iterator in preparation for another invocation.
	 * If an IOException is thrown during this process, the subsequent call should
	 * return null.
	 *
	 * @return the next line in the file
	 * @throws NoSuchElementException if there is no more data in the file
	 */
	@Override
	public String next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		String answer = "";
		try {
			answer = next;
			next = r.readLine();
		} catch (IOException e) {
			next = null;
		}
		return answer;
	}
}