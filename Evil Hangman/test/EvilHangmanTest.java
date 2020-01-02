import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * This test class, test all the methods in the Evilhangman Class
 * @author jasontran
 */
public class EvilHangmanTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorNullFilePath() {
		new EvilHangman(null, 4);
	}
	
	@Test
	public void testConstructorSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		Collection<String> words = hm.getWords();
		//assertEquals(4, hm.getWordLength());
		assertEquals(8, hm.getNumGuessesLeft());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		assertEquals("____", hm.getCurrentBoard());
	}
	
	@Test
	public void testConstructorTestFile() {
		Words w = new Words("files/test.txt");
		EvilHangman hm = new EvilHangman(w, 4);
		Collection<String> words = hm.getWords();
		//assertEquals(4, hm.getWordLength());
		assertEquals(8, hm.getNumGuessesLeft());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beer"));
		assertTrue(words.contains("beta"));
		assertTrue(words.contains("cool"));
		assertTrue(words.contains("deal"));
		assertTrue(words.contains("else"));
		assertTrue(words.contains("flew"));
		assertTrue(words.contains("good"));
		assertTrue(words.contains("hope"));
		assertTrue(words.contains("ibex"));
		assertEquals("____", hm.getCurrentBoard());
	}
	
	@Test
	public void testGetWordLengthSimpleFile() {
		//EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		//assertEquals(4, hm.getWordLength());
	}
	
	@Test
	public void testGetWordLengthTestFile() {
		//EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		//assertEquals(4, hm.getWordLength());
	}
	
	@Test
	public void testGetNumGuessesLeftSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		assertEquals(8, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testGetNumGuessesLeftTestFile() {
		EvilHangman hm = new EvilHangman(new Words ("files/test.txt"), 4);
		assertEquals(8, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testGetWordsSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
	}
	
	@Test
	public void testGetWordsTestFile() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beer"));
		assertTrue(words.contains("beta"));
		assertTrue(words.contains("cool"));
		assertTrue(words.contains("deal"));
		assertTrue(words.contains("else"));
		assertTrue(words.contains("flew"));
		assertTrue(words.contains("good"));
		assertTrue(words.contains("hope"));
		assertTrue(words.contains("ibex"));
	}
	

	@Test
	public void testGetCurrentBoardSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
	}
	
	@Test
	public void testGetCurrentBoardTestFile() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
	}
	
	@Test
	public void testGetCandidateBoardWeridCharacters() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		String candidateBoard = hm.getCandidateBoard(' ', "ally");
		assertEquals("____", candidateBoard);
		assertEquals(4, candidateBoard.length());
		
		String candidateBoard1 = hm.getCandidateBoard('!', "ally");
		assertEquals("____", candidateBoard1);
		assertEquals(4, candidateBoard1.length());
		
		String candidateBoard2 = hm.getCandidateBoard('?', "ally");
		assertEquals("____", candidateBoard2);
		assertEquals(4, candidateBoard2.length());
		
		String candidateBoard3 = hm.getCandidateBoard('1', "ally");
		assertEquals("____", candidateBoard3);
		assertEquals(4, candidateBoard3.length());
		
		String candidateBoard4 = hm.getCandidateBoard('{', "beta");
		assertEquals("____", candidateBoard4);
		assertEquals(4, candidateBoard4.length());
		
		String candidateBoard5 = hm.getCandidateBoard('#', "beta");
		assertEquals("____", candidateBoard5);
		assertEquals(4, candidateBoard5.length());
		
		String candidateBoard6 = hm.getCandidateBoard('.', "beta");
		assertEquals("____", candidateBoard6);
		assertEquals(4, candidateBoard6.length());
		
		String candidateBoard7 = hm.getCandidateBoard('+', "beta");
		assertEquals("____", candidateBoard7);
		assertEquals(4, candidateBoard7.length());
	}
	
	@Test
	public void testGetCandidateBoardSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		String candidateBoard = hm.getCandidateBoard('a', "ally");
		assertEquals("a___", candidateBoard);
		assertEquals(4, candidateBoard.length());
		
		String candidateBoard1 = hm.getCandidateBoard('l', "ally");
		assertEquals("_ll_", candidateBoard1);
		assertEquals(4, candidateBoard1.length());
		
		String candidateBoard2 = hm.getCandidateBoard('y', "ally");
		assertEquals("___y", candidateBoard2);
		assertEquals(4, candidateBoard2.length());
		
		String candidateBoard3 = hm.getCandidateBoard(' ', "ally");
		assertEquals("____", candidateBoard3);
		assertEquals(4, candidateBoard3.length());
		
		String candidateBoard4 = hm.getCandidateBoard('b', "beta");
		assertEquals("b___", candidateBoard4);
		assertEquals(4, candidateBoard4.length());
		
		String candidateBoard5 = hm.getCandidateBoard('e', "beta");
		assertEquals("_e__", candidateBoard5);
		assertEquals(4, candidateBoard5.length());
		
		String candidateBoard6 = hm.getCandidateBoard('t', "beta");
		assertEquals("__t_", candidateBoard6);
		assertEquals(4, candidateBoard6.length());
		
		String candidateBoard7 = hm.getCandidateBoard('a', "beta");
		assertEquals("___a", candidateBoard7);
		assertEquals(4, candidateBoard7.length());
	}
	
	@Test
	public void testGetCandidateBoardTestFile() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		String candidateBoard = hm.getCandidateBoard('a', "ally");
		assertEquals("a___", candidateBoard);
		assertEquals(4, candidateBoard.length());
		
		String candidateBoard1 = hm.getCandidateBoard('l', "ally");
		assertEquals("_ll_", candidateBoard1);
		assertEquals(4, candidateBoard1.length());
		
		String candidateBoard2 = hm.getCandidateBoard('y', "ally");
		assertEquals("___y", candidateBoard2);
		assertEquals(4, candidateBoard2.length());
		
		String candidateBoard3 = hm.getCandidateBoard(' ', "ally");
		assertEquals("____", candidateBoard3);
		assertEquals(4, candidateBoard3.length());
		
		String candidateBoard4 = hm.getCandidateBoard('b', "beer");
		assertEquals("b___", candidateBoard4);
		assertEquals(4, candidateBoard4.length());
		
		String candidateBoard5 = hm.getCandidateBoard('e', "beer");
		assertEquals("_ee_", candidateBoard5);
		assertEquals(4, candidateBoard5.length());
		
		String candidateBoard6 = hm.getCandidateBoard('r', "beer");
		assertEquals("___r", candidateBoard6);
		assertEquals(4, candidateBoard6.length());
		
		String candidateBoard7 = hm.getCandidateBoard('b', "beta");
		assertEquals("b___", candidateBoard7);
		assertEquals(4, candidateBoard7.length());
		
		String candidateBoard8 = hm.getCandidateBoard('e', "beta");
		assertEquals("_e__", candidateBoard8);
		assertEquals(4, candidateBoard8.length());
		
		String candidateBoard9 = hm.getCandidateBoard('t', "beta");
		assertEquals("__t_", candidateBoard9);
		assertEquals(4, candidateBoard9.length());
		
		String candidateBoard10 = hm.getCandidateBoard('a', "beta");
		assertEquals("___a", candidateBoard10);
		assertEquals(4, candidateBoard10.length());
		
		String candidateBoard11 = hm.getCandidateBoard('c', "cool");
		assertEquals("c___", candidateBoard11);
		assertEquals(4, candidateBoard11.length());
		
		String candidateBoard12 = hm.getCandidateBoard('o', "cool");
		assertEquals("_oo_", candidateBoard12);
		assertEquals(4, candidateBoard12.length());
		
		String candidateBoard13 = hm.getCandidateBoard('l', "cool");
		assertEquals("___l", candidateBoard13);
		assertEquals(4, candidateBoard13.length());
		
		String candidateBoard14 = hm.getCandidateBoard('d', "deal");
		assertEquals("d___", candidateBoard14);
		assertEquals(4, candidateBoard14.length());
		
		String candidateBoard15 = hm.getCandidateBoard('e', "deal");
		assertEquals("_e__", candidateBoard15);
		assertEquals(4, candidateBoard15.length());
		
		String candidateBoard16 = hm.getCandidateBoard('a', "deal");
		assertEquals("__a_", candidateBoard16);
		assertEquals(4, candidateBoard16.length());
		
		String candidateBoard17 = hm.getCandidateBoard('l', "deal");
		assertEquals("___l", candidateBoard17);
		assertEquals(4, candidateBoard17.length());
		
		String candidateBoard18 = hm.getCandidateBoard('e', "else");
		assertEquals("e__e", candidateBoard18);
		assertEquals(4, candidateBoard18.length());
		
		String candidateBoard19 = hm.getCandidateBoard('l', "else");
		assertEquals("_l__", candidateBoard19);
		assertEquals(4, candidateBoard19.length());
		
		String candidateBoard20 = hm.getCandidateBoard('s', "else");
		assertEquals("__s_", candidateBoard20);
		assertEquals(4, candidateBoard20.length());
		
		String candidateBoard21 = hm.getCandidateBoard('f', "flew");
		assertEquals("f___", candidateBoard21);
		assertEquals(4, candidateBoard21.length());
		
		String candidateBoard22 = hm.getCandidateBoard('l', "flew");
		assertEquals("_l__", candidateBoard22);
		assertEquals(4, candidateBoard22.length());
		
		String candidateBoard23 = hm.getCandidateBoard('e', "flew");
		assertEquals("__e_", candidateBoard23);
		assertEquals(4, candidateBoard23.length());
		
		String candidateBoard24 = hm.getCandidateBoard('w', "flew");
		assertEquals("___w", candidateBoard24);
		assertEquals(4, candidateBoard24.length());
		
		String candidateBoard25 = hm.getCandidateBoard('g', "good");
		assertEquals("g___", candidateBoard25);
		assertEquals(4, candidateBoard25.length());
		
		String candidateBoard26 = hm.getCandidateBoard('o', "good");
		assertEquals("_oo_", candidateBoard26);
		assertEquals(4, candidateBoard26.length());
		
		String candidateBoard27 = hm.getCandidateBoard('d', "good");
		assertEquals("___d", candidateBoard27);
		assertEquals(4, candidateBoard27.length());
		
		String candidateBoard28 = hm.getCandidateBoard('h', "hope");
		assertEquals("h___", candidateBoard28);
		assertEquals(4, candidateBoard28.length());
		
		String candidateBoard29 = hm.getCandidateBoard('o', "hope");
		assertEquals("_o__", candidateBoard29);
		assertEquals(4, candidateBoard29.length());
		
		String candidateBoard30 = hm.getCandidateBoard('p', "hope");
		assertEquals("__p_", candidateBoard30);
		assertEquals(4, candidateBoard30.length());
		
		String candidateBoard31 = hm.getCandidateBoard('e', "hope");
		assertEquals("___e", candidateBoard31);
		assertEquals(4, candidateBoard31.length());
		
		String candidateBoard32 = hm.getCandidateBoard('i', "ibex");
		assertEquals("i___", candidateBoard32);
		assertEquals(4, candidateBoard32.length());
		
		String candidateBoard33 = hm.getCandidateBoard('b', "ibex");
		assertEquals("_b__", candidateBoard33);
		assertEquals(4, candidateBoard33.length());
		
		String candidateBoard34 = hm.getCandidateBoard('e', "ibex");
		assertEquals("__e_", candidateBoard34);
		assertEquals(4, candidateBoard34.length());
		
		String candidateBoard35 = hm.getCandidateBoard('x', "ibex");
		assertEquals("___x", candidateBoard35);
		assertEquals(4, candidateBoard35.length());
	}
	
	@Test
	public void testGetCurrentPossibilitiesWeridCharacters() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		Map<String, Set<String>> possbility1 = hm.getCurrentPossibilities('!');
		assertFalse(possbility1.isEmpty());
		assertEquals(1, possbility1.size());
		assertTrue("____", possbility1.containsKey("____"));
		
		Set<String> wordFamily1 = possbility1.get("____");
		assertFalse(wordFamily1.isEmpty());
		assertEquals(2, wordFamily1.size());
		assertTrue("ally", wordFamily1.contains("ally"));
		assertTrue("beta", wordFamily1.contains("beta"));
		
		Map<String, Set<String>> possbility2 = hm.getCurrentPossibilities('@');
		assertFalse(possbility2.isEmpty());
		assertEquals(1, possbility2.size());
		assertTrue("____", possbility2.containsKey("____"));
	
		
		Set<String> wordFamily2 = possbility2.get("____");
		assertFalse(wordFamily2.isEmpty());
		assertEquals(2, wordFamily2.size());
		assertTrue("ally", wordFamily2.contains("ally"));
		assertTrue("beta", wordFamily2.contains("beta"));
		
		Map<String, Set<String>> possbility3 = hm.getCurrentPossibilities('1');
		assertFalse(possbility3.isEmpty());
		assertEquals(1, possbility3.size());
		assertTrue("____", possbility3.containsKey("____"));
	
		
		Set<String> wordFamily3 = possbility3.get("____");
		assertFalse(wordFamily3.isEmpty());
		assertEquals(2, wordFamily3.size());
		assertTrue("ally", wordFamily3.contains("ally"));
		assertTrue("beta", wordFamily3.contains("beta"));
	}
	
	@Test
	public void testGetCurrentPossibilitiesSimpleFile() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		Map<String, Set<String>> possbility1 = hm.getCurrentPossibilities('a');
		assertFalse(possbility1.isEmpty());
		assertEquals(2, possbility1.size());
		assertTrue("a___", possbility1.containsKey("a___"));
		assertTrue("___a", possbility1.containsKey("___a"));
		
		Set<String> wordFamily1 = possbility1.get("a___");
		assertFalse(wordFamily1.isEmpty());
		assertEquals(1, wordFamily1.size());
		assertTrue("ally", wordFamily1.contains("ally"));
		
		Set<String> wordFamily2 = possbility1.get("___a");
		assertFalse(wordFamily2.isEmpty());
		assertEquals(1, wordFamily2.size());
		assertTrue("beta", wordFamily2.contains("beta"));
		
		Map<String, Set<String>> possbility2 = hm.getCurrentPossibilities('b');
		assertFalse(possbility2.isEmpty());
		assertEquals(2, possbility2.size());
		assertTrue("____", possbility2.containsKey("____"));
		assertTrue("b___", possbility2.containsKey("b___"));
		
		Set<String> wordFamily3 = possbility2.get("____");
		assertFalse(wordFamily3.isEmpty());
		assertEquals(1, wordFamily3.size());
		assertTrue("ally", wordFamily3.contains("ally"));
		
		Set<String> wordFamily4 = possbility2.get("b___");
		assertFalse(wordFamily4.isEmpty());
		assertEquals(1, wordFamily4.size());
		assertTrue("beta", wordFamily4.contains("beta"));
		
		Map<String, Set<String>> possbility3 = hm.getCurrentPossibilities('l');
		assertFalse(possbility3.isEmpty());
		assertEquals(2, possbility3.size());
		assertTrue("_ll_", possbility3.containsKey("_ll_"));
		assertTrue("____", possbility3.containsKey("____"));
		
		Set<String> wordFamily5 = possbility3.get("____");
		assertFalse(wordFamily5.isEmpty());
		assertEquals(1, wordFamily5.size());
		assertTrue("beta", wordFamily5.contains("beta"));
		
		Set<String> wordFamily6 = possbility3.get("_ll_");
		assertFalse(wordFamily6.isEmpty());
		assertEquals(1, wordFamily6.size());
		assertTrue("ally", wordFamily6.contains("ally"));
	}
	
	@Test
	public void testGetCurrentPossibilitiesTestFileCharacterE() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		Map<String, Set<String>> possbility1 = hm.getCurrentPossibilities('e');
		assertFalse(possbility1.isEmpty());
		assertEquals(6, possbility1.size());
		assertTrue("____", possbility1.containsKey("____"));
		assertTrue("_e__", possbility1.containsKey("_e__"));
		assertTrue("__e_", possbility1.containsKey("__e_"));
		assertTrue("_ee_", possbility1.containsKey("_ee_"));
		assertTrue("e__e", possbility1.containsKey("e__e"));
		assertTrue("___e", possbility1.containsKey("___e"));
		
		Set<String> wordFamily1 = possbility1.get("____");
		assertFalse(wordFamily1.isEmpty());
		assertEquals(3, wordFamily1.size());
		assertTrue("ally", wordFamily1.contains("ally"));
		assertTrue("cool", wordFamily1.contains("cool"));
		assertTrue("good", wordFamily1.contains("good"));
		
		Set<String> wordFamily2 = possbility1.get("_e__");
		assertFalse(wordFamily2.isEmpty());
		assertEquals(2, wordFamily2.size());
		assertTrue("beta", wordFamily2.contains("beta"));
		assertTrue("deal", wordFamily2.contains("deal"));
		
		Set<String> wordFamily3 = possbility1.get("__e_");
		assertFalse(wordFamily3.isEmpty());
		assertEquals(2, wordFamily3.size());
		assertTrue("flew", wordFamily3.contains("flew"));
		assertTrue("ibex", wordFamily3.contains("ibex"));
		
		Set<String> wordFamily4 = possbility1.get("_ee_");
		assertFalse(wordFamily4.isEmpty());
		assertEquals(1, wordFamily4.size());
		assertTrue("beer", wordFamily4.contains("beer"));
		
		Set<String> wordFamily5 = possbility1.get("e__e");
		assertFalse(wordFamily5.isEmpty());
		assertEquals(1, wordFamily5.size());
		assertTrue("else", wordFamily5.contains("else"));
		
		Set<String> wordFamily6 = possbility1.get("___e");
		assertFalse(wordFamily6.isEmpty());
		assertEquals(1, wordFamily6.size());
		assertTrue("hope", wordFamily6.contains("hope"));
	}
	
	@Test
	public void testGetCurrentPossibilitiesTestFileCharacterO() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		Map<String, Set<String>> possbility1 = hm.getCurrentPossibilities('o');
		assertFalse(possbility1.isEmpty());
		assertEquals(3, possbility1.size());
		assertTrue("____", possbility1.containsKey("____"));
		assertTrue("_oo_", possbility1.containsKey("_oo_"));
		assertTrue("_o__", possbility1.containsKey("_o__"));
		
		Set<String> wordFamily1 = possbility1.get("____");
		assertFalse(wordFamily1.isEmpty());
		assertEquals(7, wordFamily1.size());
		assertTrue("ally", wordFamily1.contains("ally"));
		assertTrue("beer", wordFamily1.contains("beer"));
		assertTrue("beta", wordFamily1.contains("beta"));
		assertTrue("deal", wordFamily1.contains("deal"));
		assertTrue("else", wordFamily1.contains("else"));
		assertTrue("flew", wordFamily1.contains("flew"));
		assertTrue("ibex", wordFamily1.contains("ibex"));

		Set<String> wordFamily2 = possbility1.get("_oo_");
		assertFalse(wordFamily2.isEmpty());
		assertEquals(2, wordFamily2.size());
		assertTrue("cool", wordFamily2.contains("cool"));
		assertTrue("good", wordFamily2.contains("good"));
		
		Set<String> wordFamily3 = possbility1.get("_o__");
		assertFalse(wordFamily3.isEmpty());
		assertEquals(1, wordFamily3.size());
		assertTrue("hope", wordFamily3.contains("hope"));
	}
	
	@Test
	public void testGetCurrentPossibilitiesTestFileCharacterZ() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		Map<String, Set<String>> possbility1 = hm.getCurrentPossibilities('z');
		assertFalse(possbility1.isEmpty());
		assertEquals(1, possbility1.size());
		assertTrue("____", possbility1.containsKey("____"));
		
		Set<String> wordFamily1 = possbility1.get("____");
		assertFalse(wordFamily1.isEmpty());
		assertEquals(10, wordFamily1.size());
		assertTrue("ally", wordFamily1.contains("ally"));
		assertTrue("beer", wordFamily1.contains("beer"));
		assertTrue("beta", wordFamily1.contains("beta"));
		assertTrue("cool", wordFamily1.contains("cool"));
		assertTrue("deal", wordFamily1.contains("deal"));
		assertTrue("else", wordFamily1.contains("else"));
		assertTrue("flew", wordFamily1.contains("flew"));
		assertTrue("good", wordFamily1.contains("good"));
		assertTrue("hope", wordFamily1.contains("hope"));
		assertTrue("ibex", wordFamily1.contains("ibex"));
	}
	
	@Test
	public void testAcceptGuessSimpleFileWeirdCharacter() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('!');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(2, newWords.size());
		assertTrue(newWords.contains("ally"));
		assertTrue(newWords.contains("beta"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	
	@Test
	public void testAcceptGuessSimpleFileCharacterA() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('a');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("___a", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(1, newWords.size());
		assertFalse(newWords.contains("ally"));
		assertTrue(newWords.contains("beta"));
		
		assertEquals(8, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testAcceptGuessSimpleFileCharacterL() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('l');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(1, newWords.size());
		assertFalse(newWords.contains("ally"));
		assertTrue(newWords.contains("beta"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testAcceptGuessSimpleFileCharacterZ() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('z');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(2, newWords.size());
		assertTrue(newWords.contains("ally"));
		assertTrue(newWords.contains("beta"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testAcceptGuessTestFileCharacterE() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('e');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(3, newWords.size());
		assertTrue(newWords.contains("ally"));
		assertTrue(newWords.contains("cool"));
		assertTrue(newWords.contains("good"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	
	@Test
	public void testAcceptGuessTestFileCharacterZ() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('z');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(10, newWords.size());
		assertTrue(newWords.contains("ally"));
		assertTrue(newWords.contains("beer"));
		assertTrue(newWords.contains("beta"));
		assertTrue(newWords.contains("cool"));
		assertTrue(newWords.contains("deal"));
		assertTrue(newWords.contains("else"));
		assertTrue(newWords.contains("flew"));
		assertTrue(newWords.contains("good"));
		assertTrue(newWords.contains("hope"));
		assertTrue(newWords.contains("ibex"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testAcceptGuessTestFileCharacterTwoCalls() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('e');
		String nextBoard = hm.getCurrentBoard();
		assertEquals("____", nextBoard);
		assertEquals(4, nextBoard.length());
		Collection<String> newWords = hm.getWords();
		assertFalse(newWords.isEmpty());
		assertEquals(3, newWords.size());
		assertTrue(newWords.contains("ally"));
		assertTrue(newWords.contains("cool"));
		assertTrue(newWords.contains("good"));
		
		assertEquals(7, hm.getNumGuessesLeft());
		
		hm.acceptGuess('o');
		String nextBoard1 = hm.getCurrentBoard();
		assertEquals("_oo_", nextBoard1);
		assertEquals(4, nextBoard1.length());
		Collection<String> newWords1 = hm.getWords();
		assertFalse(newWords1.isEmpty());
		assertEquals(2, newWords1.size());
		assertFalse(newWords1.contains("ally"));
		assertTrue(newWords1.contains("cool"));
		assertTrue(newWords1.contains("good"));
		
		assertEquals(7, hm.getNumGuessesLeft());
	}
	
	@Test
	public void testRevealWordSimpleFileAllWeirdCharacters() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		assertEquals(8, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(7, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(6, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(5, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(4, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(3, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(2, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(1, hm.getNumGuessesLeft());
		hm.acceptGuess('!');
		assertEquals(0, hm.getNumGuessesLeft());
	
		String reveal = hm.revealWord();
		assertEquals("ally", reveal);
	}
	
	@Test
	public void testRevealWordSimpleFileGuessCorrectly() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(2, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beta"));
		
		hm.acceptGuess('a');
		assertEquals(8, hm.getNumGuessesLeft());
		hm.acceptGuess('e');
		assertEquals(8, hm.getNumGuessesLeft());
		hm.acceptGuess('t');
		assertEquals(8, hm.getNumGuessesLeft());
		hm.acceptGuess('b');
		assertEquals(8, hm.getNumGuessesLeft());
		
		String reveal = hm.revealWord();
		assertEquals("beta", reveal);
	}
	
	@Test
	public void testRevealWordTestFileGuessIncorrectly() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beer"));
		assertTrue(words.contains("beta"));
		assertTrue(words.contains("cool"));
		assertTrue(words.contains("deal"));
		assertTrue(words.contains("else"));
		assertTrue(words.contains("flew"));
		assertTrue(words.contains("good"));
		assertTrue(words.contains("hope"));
		assertTrue(words.contains("ibex"));
		
		hm.acceptGuess('e');
		assertEquals(7, hm.getNumGuessesLeft());
		
		hm.acceptGuess('o');
		assertEquals(7, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(6, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(5, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(4, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(3, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(2, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(1, hm.getNumGuessesLeft());
		hm.acceptGuess('z');
		assertEquals(0, hm.getNumGuessesLeft());
		
		String reveal = hm.revealWord();
		assertEquals("cool", reveal);
	}

	@Test
	public void testRevealWordTestFileGuessCorrectly() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		Collection<String> words = hm.getWords();
		assertFalse(words.isEmpty());
		assertEquals(10, words.size());
		assertTrue(words.contains("ally"));
		assertTrue(words.contains("beer"));
		assertTrue(words.contains("beta"));
		assertTrue(words.contains("cool"));
		assertTrue(words.contains("deal"));
		assertTrue(words.contains("else"));
		assertTrue(words.contains("flew"));
		assertTrue(words.contains("good"));
		assertTrue(words.contains("hope"));
		assertTrue(words.contains("ibex"));
		
		hm.acceptGuess('e');
		assertEquals(7, hm.getNumGuessesLeft());
		
		hm.acceptGuess('o');
		assertEquals(7, hm.getNumGuessesLeft());
		
		hm.acceptGuess('c');
		assertEquals(6, hm.getNumGuessesLeft());

		hm.acceptGuess('d');
		assertEquals(6, hm.getNumGuessesLeft());
		
		hm.acceptGuess('g');
		assertEquals(6, hm.getNumGuessesLeft());
		
		String reveal = hm.revealWord();
		assertEquals("good", reveal);
	}
	
	@Test
	public void testSetNumGuessesLeftWithInBounds() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		assertEquals(8, hm.getNumGuessesLeft());
		
		hm.setNumGuessesLeft(4);
		assertEquals(4, hm.getNumGuessesLeft());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNumGuessesLeftWithInOutOfBoundsNegative() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		hm.setNumGuessesLeft(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNumGuessesLeftWithInOutOfBoundsTooHigh() {
		EvilHangman hm = new EvilHangman(new Words("files/simple.txt"), 4);
		hm.setNumGuessesLeft(10000);
	}
	
	@Test
	public void testSetCurrentBoardValidInputAllDashes() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		hm.setCurrentBoard("__");
		assertEquals("__", hm.getCurrentBoard());
		assertEquals(2, hm.getCurrentBoard().length());
	}
	
	@Test
	public void testSetCurrentBoardValidInputCharactesAndDashes() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		hm.setCurrentBoard("_a__");
		assertEquals("_a__", hm.getCurrentBoard());
		assertEquals(4, hm.getCurrentBoard().length());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCurrentBoardInvalidInputCharacters() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		hm.setCurrentBoard("_!__");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCurrentBoardAllInvalidInputCharacters() {
		EvilHangman hm = new EvilHangman(new Words("files/test.txt"), 4);
		String currentBoard = hm.getCurrentBoard();
		assertEquals("____", currentBoard);
		assertEquals(4, currentBoard.length());
		
		hm.setCurrentBoard("$!#!");
	}
	
}