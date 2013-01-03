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
    
    @Test
    public void tarkistaLaivanAsetus(){
        Laiva laiva = new Laiva(3);
        assertTrue(ruudukko.lisaaLaiva(laiva, 3, 2, true));
        assertTrue(!ruudukko.lisaaLaiva(laiva, 3, 2, false));
    }
    
    @Test
    public void testaaTuhoutuukoLaiva(){
        Laiva laiva = new Laiva(3);
        ruudukko.lisaaLaiva(laiva, 3, 2, true);
        assertTrue(ruudukko.getLaivojenMaara() == 1);
        for(int i = 3; i <= 3+3-1; i++){
            ruudukko.ammuRuutuun(i, 2);
        }
        assertTrue(ruudukko.getLaivojenMaara() == 0);
    }
}
