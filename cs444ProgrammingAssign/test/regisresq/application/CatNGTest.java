/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.application;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author cobyz
 */
public class CatNGTest {
    
    public CatNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testValidate() {
        // TODO review the generated test code and remove the default call to fail.
        Cat c = new Cat();
        boolean result = c.validate();
        assertFalse(result);
        
        c.setBreed("Persian");
        result = c.validate();
        assertFalse(result);
        
        c.setName("Pal");
        result = c.validate();
        assertFalse(result);
        
        c.setSterilized(false);
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2020-05-32");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived(null);
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2020-04-10");
        result = c.validate();
        assertTrue(result);
    }
    
}
