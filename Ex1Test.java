//package assignments.ex1;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        assertEquals("12bB", Ex1.int2Number(13, 11));
        assertEquals("", Ex1.int2Number(1234, 1));
        assertEquals("1100b2", Ex1.int2Number(12, 2));
        assertEquals("", Ex1.int2Number(101000, 0));
        assertEquals("", Ex1.int2Number(-8, 4));
        assertEquals("99bG", Ex1.int2Number(153, 16));
        assertEquals("C0bF",Ex1.int2Number(180,15));// REVERS 1 AND 2
        assertEquals("489bD", Ex1.int2Number(789, 13));


    }

    @Test
    void maxIndexTest() {
        String[] str = {"12b3", "6BbG", "12345", "12b4"};
        assertEquals(2, Ex1.maxIndex(str));
        String[] str1 = {"8", "20b3", "876", "6b7", "4b5"};
        assertEquals(2, Ex1.maxIndex(str1));
    }

    @Test
    void isNumber() {
        assertTrue(Ex1.isNumber("1234b5"));
        assertTrue(Ex1.isNumber("456"));
        assertFalse(Ex1.isNumber("#67"));
        assertFalse(Ex1.isNumber("  45"));
        assertFalse(Ex1.isNumber("FbB"));
        assertFalse(Ex1.isNumber("DbbG"));
        assertFalse(Ex1.isNumber("1b34"));
        assertFalse(Ex1.isNumber("13b"));
        assertFalse(Ex1.isNumber("b5"));
        assertFalse(Ex1.isNumber("BG"));
        assertFalse(Ex1.isNumber("-23"));


    }

    @Test
    void number2Int() {
        String num = "1010b2";
        String num1 = "10799";
        String num2 = "2345b";
        String num3 = "45b3";
        String num4 = "1234b78";
        assertEquals(10,Ex1.number2Int(num));
        assertEquals(10799,Ex1.number2Int(num1));
        assertEquals(-1,Ex1.number2Int(num2));
        assertEquals(-1,Ex1.number2Int(num3));
        assertEquals(-1,Ex1.number2Int(num4));



    }

    @Test
    void char2Int() {
        assertEquals(10, Ex1.char2Int('A'));
        assertEquals(11, Ex1.char2Int('B'));
        assertEquals(12, Ex1.char2Int('C'));
        assertEquals(13, Ex1.char2Int('D'));
        assertEquals(14, Ex1.char2Int('E'));
        assertEquals(15, Ex1.char2Int('F'));
        assertEquals(16, Ex1.char2Int('G'));
        assertEquals(-1, Ex1.char2Int('h'));
    }

    @Test
    void equals()
    {
        String str = "1000b2";
        String str1 = "8b9";
        String str2 = "3456";
        String str3 = "34 56";
        assertTrue(Ex1.equals(str,str1));
        assertFalse(Ex1.equals(str1,str2));
        assertFalse(Ex1.equals(str2,str3));
    }
    @Test
    void is_digits()
    {
        String str = "1234567";
        String str1 = "12345G";
        String str2 = "1234 4567";
        String str3 = "DGY2";
        assertTrue(Ex1.is_digits(str));
        assertFalse(Ex1.is_digits(str1));
        assertFalse(Ex1.is_digits(str2));
        assertFalse(Ex1.is_digits(str3));
    }
    @Test
    void po()
    {
        assertEquals(8,Ex1.po(2,3));
        assertEquals(1,Ex1.po(2,0));
        assertEquals(1,Ex1.po(0,0));
        assertEquals(4,Ex1.po(4,1));
        assertEquals(1,Ex1.po(2,-4));
    }
    @Test
    void test()
    {
        System.out.println(Ex1.int2Number(12,2));
        System.out.println(Ex1.int2char(12));
    }
}
