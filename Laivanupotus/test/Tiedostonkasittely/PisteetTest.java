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
        lisaaPelaajiaTiedostoon();
        assertTrue(pisteet.haeListaTiedostosta() == 0);
    }
    
    public void lisaaPelaajiaTiedostoon(){
        Pelaaja pelaaja1 = new Pelaaja("pelaaja1");
        Pelaaja pelaaja2 = new Pelaaja("pelaaja2");
        pisteet.kirjoitaTiedostolle(pelaaja1);
        pisteet.kirjoitaTiedostolle(pelaaja2);
    }
    
    @After
    public void tiedostonPoisto(){
        pisteet.poistaTiedosto();
    }
}
