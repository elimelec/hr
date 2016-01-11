/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Password;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author keepCalling
 */
public class PasswordTest {
    
    public PasswordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Hash method, of class Password.
     */
    @Test
    public void testHash() throws Exception {
        System.out.println("Hash");
        String password = "1234";
        String expResult = "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";
        String result = Password.Hash(password);
        assertEquals(expResult, result);
        
        password = "jnkgnfdkjgnlkfdjngfndgflkjngsfdhbgljdfnghfbgkajdfgphafdohgbu37485 g3478§fFTFTF±F F^";
        expResult = "1ffe5b68f490817fbedcf8e3ad0805489175d92d6e8222002b449fcda1b59934";
        result = Password.Hash(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
