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
public class RuutuTest {
    
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu = new Ruutu(1, 1);
    }
    
    @Test
    public void testaaOnkoTuhottuMetodi(){
        Laiva laiva = new Laiva(2);
        ruutu.asetaLaiva(laiva);
        assertTrue(!ruutu.onkoTuhottu());
        ruutu.ammu();
        assertTrue(ruutu.onkoTuhottu());
    }
}
