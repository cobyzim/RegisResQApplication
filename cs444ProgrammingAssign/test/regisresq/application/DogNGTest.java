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
public class DogNGTest {
    
    public DogNGTest() {
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
        Dog d = new Dog();
        boolean result = d.validate();
        assertFalse(result);
        
        d.setBreed("German Shephard");
        result = d.validate();
        assertFalse(result);
        
        d.setName("Buddy");
        result = d.validate();
        assertFalse(result);
        
        d.setSterilized(true);
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2020-05-32");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived(null);
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2020-04-10");
        result = d.validate();
        assertTrue(result);
    }
    
}
