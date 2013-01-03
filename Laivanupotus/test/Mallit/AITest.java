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
public class AITest {
    
    AI tekoaly;
    Ruudukko r;
    int[] koot;
    
    public AITest() {
    }
    
    @Before
    public void setUp() {
        r = new Ruudukko(10);
        koot = new int[] {5, 4, 3, 3, 2};
        tekoaly = new AI(r, koot);
    }
    
    @Test
    public void testaaLaivojenAsetus(){
        tekoaly.asetaLaivatRuudukkoon();
        assertEquals(r.getLaivojenMaara(), koot.length);
    }
    
    @Test
    public void testaaKoordinaattienPalautus(){
        int[] koord = tekoaly.haeAmmuttavatKoordinaatit();
        assertTrue(koord != null);
        assertTrue(koord[0] >= 0);
        assertTrue(koord[0] < r.getKoko());
        assertTrue(koord[1] >= 0);
        assertTrue(koord[1] < r.getKoko());
    }
    
    @Test
    public void testaaHaeAsetettavaLaiva(){
        int laiva = tekoaly.haeAsetettavaLaiva();
        assertTrue(laiva == 2);
        laiva = tekoaly.haeAsetettavaLaiva();
        assertTrue(laiva == 3);
    }
}
