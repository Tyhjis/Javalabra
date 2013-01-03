/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class LaivaTest {
    
    Laiva laiva;
    final int pit = 2;
    
    public LaivaTest() {
    }
    
    @Before
    public void setUp() {
        laiva = new Laiva(pit);       
    }
    
    @Test
    public void testaaLaivanTuhoutuminen(){
        int pit2;
        laiva.ammuLaivaan();
        pit2 = laiva.getPituus();
        assertTrue(pit2 == pit-1);
        laiva.ammuLaivaan();
        laiva.ammuLaivaan();
        pit2 = laiva.getPituus();
        assertTrue(pit2 == 0);
    }
}
