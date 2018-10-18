package uppgift2_oop;

import org.junit.Test;
import junit.framework.TestCase;

/**
 *
 * @author isami
 */
public class CustomerTest {
    
    Customer cus1 = new Customer("Sven Svensson", "200006171234");
    Customer cus2 = new Customer("Erika Johansson", "200006171234");
    Customer cus3 = new Customer("Sven Svensson", "200006171234");
    
    /**
     * Test of equals method, of class Customer.
     */
    @Test
    public void testEquals() {
        TestCase.assertTrue(cus1.equals(cus3));
        TestCase.assertFalse(cus1.equals(cus2));      
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetName() {
        cus1.setName("Sven Svensson1");
    }

    /**
     * Test of setPersonalnumber method, of class Customer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPersonalnumber() {
        cus1.setName("Sven1Svensso");       
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetPersonalnumber2() {
        cus1.setName("12345678111");
        
    }
    
}
