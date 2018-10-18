package uppgift2_oop;

import org.junit.Test;
import junit.framework.TestCase;

/**
 *
 * @author isami
 */
public class GymTest {
    

    Gym gym = new Gym();
    
    /**
     * Test of findCustomer method, of class Gym.
     */
    @Test
    public void testFindCustomer() {
        
        Customer cus1 = gym.findCustomer("Alhambra Aromes");
        Customer cus2 = gym.findCustomer("7603021234");
        Customer cus3 = gym.findCustomer("Liu Lingren");
        Customer cus4 = gym.findCustomer("9110261234");
        Customer cus5 = gym.findCustomer("Test");
        
        TestCase.assertTrue(cus1 == cus2);
        TestCase.assertEquals(cus3, cus4);
        TestCase.assertTrue(!cus1.equals(cus3));
        TestCase.assertTrue(cus5==null);
        
    }
    
}
