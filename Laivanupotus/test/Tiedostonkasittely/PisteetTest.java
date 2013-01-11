/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiedostonkasittely;

import Mallit.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krha
 */
public class PisteetTest {
    
    Pisteet pisteet;
    
    public PisteetTest() {
    }    
    
    @Before
    public void setUp() {
        pisteet = new Pisteet();
        pisteet.setTiedostonninimi("testTied");
    }
    
    @After
    public void tiedostonPoisto(){
        pisteet.poistaTiedosto();
    }
    
    @Test
    public void testaaTiedostonOlemattomuus(){
        int testaus = pisteet.lataaTiedosto();
        assertTrue(testaus != 0);
    }
    
    @Test
    public void testaaTiedostonLuonti(){
        assertTrue(pisteet.luoUusiTiedosto());
    }
    
    @Test
    public void testaaTiedostonPoisto(){
        pisteet.luoUusiTiedosto();
        assertTrue(pisteet.poistaTiedosto());
    }
    
    @Test
    public void testaaTiedostonLataus1(){
        pisteet.luoUusiTiedosto();
        int testaus = pisteet.lataaTiedosto();
        assertTrue(testaus == 2);
    }
    
    @Test
    public void testaaTiedostonKirjoitus(){
        pisteet.luoUusiTiedosto();
        Pelaaja pelaaja = new Pelaaja("pelaaja");
        assertTrue(pisteet.kirjoitaTiedostolle(pelaaja));        
    }
    
    @Test
    public void testaaListanHakuTiedostosta1(){
        pisteet.luoUusiTiedosto();
        pisteet.kirjoitaTiedostolle(new Pelaaja("pelaaja"));
        assertTrue(pisteet.haeListaTiedostosta() == 0);
    }
    
    @Test
    public void testaaListanHakuTiedostosta2(){
        pisteet.luoUusiTiedosto();
        assertTrue(pisteet.getLista() == null);
    }
    
    @Test
    public void testaaListanHakuTiedostosta3(){
        pisteet.luoUusiTiedosto();
        pisteet.kirjoitaTiedostolle(new Pelaaja("pelaaja"));
        assertTrue(pisteet.getLista() != null);
    }
    
    
    
}
