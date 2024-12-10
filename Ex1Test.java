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
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // implement this test
    }
    @Test
    void maxIndexTest() {
        // implement this test
    }
    @Test
    void isnumber()
    {
        String num = "12567b9";
        System.out.println(num.length());
        System.out.println(num.indexOf("b")+2);
        String num2 = "A3bG";
        System.out.println(Ex1.isNumber(num));
    }
    @Test
    void number2int()
    {
        String num =  "1010b2";
        String num1 = "1000b2";
        System.out.println(Ex1.number2Int(num1));

    }
    @Test
    void int2number()
    {
        int x = 14;
        System.out.println(Ex1.int2Number(x,2));
    }
    @Test
    void maxIndex()
    {
        String [] arr = {"101b2","1000b2","12323","99"};
        System.out.println(Ex1.maxIndex(arr));
    }

    // Add additional test functions - test as much as you can.
}
