import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class WordScannerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNull() {
        new WordScanner(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFilePathDoesNotExist() {
        new WordScanner("files/Jason");
    }

    @Test
    public void testHasNextAndNextSimple() {
        WordScanner ws = new WordScanner("files/simple.txt");
        assertTrue(ws.hasNext());
        assertEquals("ally", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("beta", ws.next());
        assertFalse(ws.hasNext());
    }

    @Test
    public void testHasNextAndNextTest() {
        WordScanner ws = new WordScanner("files/test.txt");
        assertTrue(ws.hasNext());
        assertEquals("ally", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("beer", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("beta", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("cool", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("deal", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("else", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("flew", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("good", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("hope", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("ibex", ws.next());
        assertFalse(ws.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextNoSuchElement() {
        WordScanner ws = new WordScanner("files/simple.txt");
        assertTrue(ws.hasNext());
        assertEquals("ally", ws.next());
        assertTrue(ws.hasNext());
        assertEquals("beta", ws.next());
        assertFalse(ws.hasNext());
        ws.next();
    }

}
