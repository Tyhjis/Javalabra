/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class PeliTest {
    
    Peli peli;
    
    public PeliTest() {
    }
    
    
    @Before
    public void setUp() {
        peli = new Peli("nimi", 10, new int[] {1, 2, 3});
    }
    
    @Test
    public void testaaKoonAsetus(){
        
    }
}
