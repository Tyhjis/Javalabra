package Mallit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class RuudukkoTest {
   
    Ruudukko ruudukko;
    @Before
    public void setUp(){
        ruudukko = new Ruudukko(10);
    }
    
    @Test
    public void tarkistaRuudukkoOlionLuonti(){
        assertTrue(ruudukko != null);
    }
    
    @Test
    public void tarkistaRuudukonKonstruktorinToimivuus(){
        int ruudukonkoko = ruudukko.getKoko();
        assertEquals(ruudukonkoko, 10);
        for (int i = 0; i < ruudukonkoko; i++) {
            for (int j = 0; j < ruudukonkoko; j++) {
                assertTrue(ruudukko.getRuutu(j, i) != null);
            }
        }
    }
}
