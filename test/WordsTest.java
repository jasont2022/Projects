import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class WordsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNull() {
        new Words(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFilePathDoesNotExist() {
        new Words("files/Jason");
    }

    @Test
    public void testConstructorSimpleFile() {
        Words w = new Words("files/simple.txt");
        Map<String, Integer> m = w.getWordMap();
        assertFalse(m.isEmpty());
        assertEquals(2, m.size());
        assertTrue("ally", m.containsKey("ally"));
        assertTrue("beta", m.containsKey("beta"));
        int length1 = m.get("ally");
        assertEquals(4, length1);
        int length2 = m.get("beta");
        assertEquals(4, length2);
    }

    @Test
    public void testConstructorTestFile() {
        Words w = new Words("files/test.txt");
        Map<String, Integer> m = w.getWordMap();
        assertFalse(m.isEmpty());
        assertEquals(10, m.size());
        assertTrue("ally", m.containsKey("ally"));
        assertTrue("beer", m.containsKey("beer"));
        assertTrue("beta", m.containsKey("beta"));
        assertTrue("cool", m.containsKey("cool"));
        assertTrue("deal", m.containsKey("deal"));
        assertTrue("else", m.containsKey("else"));
        assertTrue("flew", m.containsKey("flew"));
        assertTrue("good", m.containsKey("good"));
        assertTrue("hope", m.containsKey("hope"));
        assertTrue("ibex", m.containsKey("ibex"));
        int length1 = m.get("ally");
        assertEquals(4, length1);
        int length2 = m.get("beer");
        assertEquals(4, length2);
        int length3 = m.get("beta");
        assertEquals(4, length3);
        int length4 = m.get("cool");
        assertEquals(4, length4);
        int length5 = m.get("deal");
        assertEquals(4, length5);
        int length6 = m.get("else");
        assertEquals(4, length6);
        int length7 = m.get("flew");
        assertEquals(4, length7);
        int length8 = m.get("good");
        assertEquals(4, length8);
        int length9 = m.get("hope");
        assertEquals(4, length9);
        int length10 = m.get("ibex");
        assertEquals(4, length10);
    }

    @Test
    public void testGetWordMapSimpleFile() {
        Words w = new Words("files/simple.txt");
        Map<String, Integer> m = w.getWordMap();
        assertFalse(m.isEmpty());
        assertEquals(2, m.size());
        assertTrue("ally", m.containsKey("ally"));
        assertTrue("beta", m.containsKey("beta"));
        int length1 = m.get("ally");
        assertEquals(4, length1);
        int length2 = m.get("beta");
        assertEquals(4, length2);
    }

    @Test
    public void testGetWordMapTestFile() {
        Words w = new Words("files/test.txt");
        Map<String, Integer> m = w.getWordMap();
        assertFalse(m.isEmpty());
        assertEquals(10, m.size());
        assertTrue("ally", m.containsKey("ally"));
        assertTrue("beer", m.containsKey("beer"));
        assertTrue("beta", m.containsKey("beta"));
        assertTrue("cool", m.containsKey("cool"));
        assertTrue("deal", m.containsKey("deal"));
        assertTrue("else", m.containsKey("else"));
        assertTrue("flew", m.containsKey("flew"));
        assertTrue("good", m.containsKey("good"));
        assertTrue("hope", m.containsKey("hope"));
        assertTrue("ibex", m.containsKey("ibex"));
        int length1 = m.get("ally");
        assertEquals(4, length1);
        int length2 = m.get("beer");
        assertEquals(4, length2);
        int length3 = m.get("beta");
        assertEquals(4, length3);
        int length4 = m.get("cool");
        assertEquals(4, length4);
        int length5 = m.get("deal");
        assertEquals(4, length5);
        int length6 = m.get("else");
        assertEquals(4, length6);
        int length7 = m.get("flew");
        assertEquals(4, length7);
        int length8 = m.get("good");
        assertEquals(4, length8);
        int length9 = m.get("hope");
        assertEquals(4, length9);
        int length10 = m.get("ibex");
        assertEquals(4, length10);
    }

    @Test
    public void testIsValidWordLengthSimpleFile() {
        Words w = new Words("files/simple.txt");
        assertTrue(w.isValidWordLength(4));
        assertFalse(w.isValidWordLength(-1));
        assertFalse(w.isValidWordLength(1000));
    }

    @Test
    public void testIsValidWordLengthTestFile() {
        Words w = new Words("files/test.txt");
        assertTrue(w.isValidWordLength(4));
        assertFalse(w.isValidWordLength(-1));
        assertFalse(w.isValidWordLength(1000));
    }

    @Test
    public void testWordsWithWordLengthEmptySet() {
        Words w = new Words("files/simple.txt");
        Set<String> words = w.wordsWithWordLength(1000);
        assertTrue(words.isEmpty());
        assertEquals(0, words.size());
    }

    @Test
    public void testWordsWithWordLengthSimpleFile() {
        Words w = new Words("files/simple.txt");
        Set<String> words = w.wordsWithWordLength(4);
        assertFalse(words.isEmpty());
        assertEquals(2, words.size());
        assertTrue(words.contains("ally"));
        assertTrue(words.contains("beta"));
    }

    @Test
    public void testWordsWithWordLengthTestFile() {
        Words w = new Words("files/test.txt");
        Set<String> words = w.wordsWithWordLength(4);
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
}
