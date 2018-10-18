package uppgift2_oop;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import junit.framework.TestCase;

/**
 *
 * @author isami
 */
public class UtilitiesTest {
   
    /**
     * Test of checkInput method, of class Utilities.
     */
    @Test
    public void testCheckInput() {
        TestCase.assertTrue(Utilities.checkInput("0"));
        TestCase.assertTrue(Utilities.checkInput("1"));
        TestCase.assertTrue(Utilities.checkInput("2"));
        TestCase.assertTrue(Utilities.checkInput("3"));
        TestCase.assertFalse(Utilities.checkInput("A"));
        TestCase.assertFalse(Utilities.checkInput("+"));
        TestCase.assertFalse(Utilities.checkInput("12"));
        TestCase.assertFalse(Utilities.checkInput(null));
        TestCase.assertFalse(Utilities.checkInput(""));
    }

    /**
     * Test of stringToLocalDate method, of class Utilities.
     */
    @Test
    public void testStringToLocalDate() {
        LocalDate day1 = LocalDate.of(2017,2,4);
        LocalDate day2 = LocalDate.of(2017, Month.JULY, 22);
        LocalDate day3 = LocalDate.parse("2015-12-24");
                
        TestCase.assertEquals(day1, Utilities.stringToLocalDate("2017-02-04"));
        TestCase.assertEquals(day2, Utilities.stringToLocalDate("2017-07-22"));
        TestCase.assertEquals(day3, Utilities.stringToLocalDate("2015-12-24"));
    }
    
}
