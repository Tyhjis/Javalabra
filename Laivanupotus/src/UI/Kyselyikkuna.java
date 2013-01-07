
package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.PelinAloitus;

public class Kyselyikkuna extends JFrame {

    private PelinAloitus ohjain;
    private JPanel pohja, sisalto, kyselynsisalto;
    private ButtonGroup moodivalinnat, pelaajavalinnat;
    private JRadioButton klassinen, moderni, yksipelaaja, kaksipelaajaa;
    private JButton jatka;
    private String ruudukonkokostr, laivojenmaarastr;
    private int[] defkoot, kustomkoot;
    private int laivojenmaara, ruudukonkoko;
    private JTextField pelaaja1nimi;
    private String nimi1;
    private final Object[] valinnat;
    private JComboBox[] valitse;
    private JLabel[] indeksit;
    /**
     * Konstruktori. Kutsuu kutsuu muodostaKayttoliittyma-metodia.
     */
    public Kyselyikkuna(){
        valinnat = new Object[] {1, 2, 3, 4, 5};
        muodostaKayttoliittyma();
    }
    
    /**
     * Asettaa kontrollerin MVC-tyyppisessä ohjelmassa.
     * @param ohjain Viite PelinAloitus-tyyppiseen olioon.
     */
    public void asetaOhjain(PelinAloitus ohjain) {
        this.ohjain = ohjain;
    }

    /**
     * Luo graafisen käyttöliittymän komponentit.
     */
    public void muodostaKayttoliittyma() {
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        defkoot = new int [] {5, 4, 3, 3, 2};
        pohja = new JPanel();
        sisalto = new JPanel();
        kyselynsisalto = new JPanel();
        moodivalinnat = new ButtonGroup();
        klassinen = new JRadioButton("Klassinen peli");
        moderni = new JRadioButton("Kehittyneempi versio");
        jatka = new JButton("Jatka");
        pelaaja1nimi = new JTextField("Pelaaja1");
        jatka.addActionListener(new JatkaNapinToiminta());
        moderni.addActionListener(new PelityylinToiminta());
        moodivalinnat.add(klassinen);
        moodivalinnat.add(moderni);
        klassinen.setSelected(true);
        sisalto.add(klassinen);
        sisalto.add(moderni);
        sisalto.add(jatka);
        sisalto.add(pelaaja1nimi);
        pohja.add(sisalto);
        pohja.add(kyselynsisalto);
        setContentPane(pohja);
        setSize(500, 500);
        setVisible(true);
    }
    /**
     * Lisää komponentit, joista käyttäjä voi valita haluamansa syötteen.
     */
    private void lisaaKomponentitKayttoliittymaan() {
        valitse = new JComboBox[laivojenmaara];
        indeksit = new JLabel[laivojenmaara];
        kyselynsisalto.setLayout(new GridLayout(laivojenmaara, 2));
        Integer apu;
        for(int i = 0; i < laivojenmaara; i++){
            apu = new Integer(i+1);
            indeksit[i] = new JLabel(apu.toString());
            kyselynsisalto.add(indeksit[i]);
            valitse[i] = new JComboBox(valinnat);
            valitse[i].setSelectedIndex(0);
            valitse[i].setEditable(true);
            kyselynsisalto.add(valitse[i]);
            setContentPane(pohja);
        }
    }
    
    public void alustaKokoJaMaara(){
        while(!tarkistaSyote(ruudukonkokostr, true)){
            ruudukonkokostr = JOptionPane.showInputDialog("Syota haluamasi ruudukon koko valilta 10-20.");
        }
        while(!tarkistaSyote(laivojenmaarastr, false)){
            laivojenmaarastr = JOptionPane.showInputDialog("Syota haluamasi laivojen maara valilta 1-10.\nTai syota 0, jos haluat samat kuin klassisessa");
        }
        ruudukonkoko = Integer.parseInt(ruudukonkokostr);
        laivojenmaara = Integer.parseInt(laivojenmaarastr);
    }
    
    public void alustaLaivojenKoot(){
        Integer n;
        String s;
        kustomkoot = new int[laivojenmaara];
        for(int i = 0; i < laivojenmaara; i++){
            s = valitse[i].getSelectedItem().toString();
            n = new Integer(s);
            kustomkoot[i] = n.intValue();
        }
    }
    /**
     * Syötteen tarkistus.
     * @param s annettu syöte
     * @param ruudukko true, jos tarkistetaan ruudukkoa koskevat syötteet.
     * @return palauttaa true, jos syöte oli oikea. Muuten false.
     */
    private boolean tarkistaSyote(String s, boolean ruudukko){
        Integer n = new Integer("-1");
        try{
            if(s != null){
                n = new Integer(s);
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Tapahtui virhe! Et antanut kunnollista syotetta.", "Virhe", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ruudukko){
            if(n.intValue() > 9 && n.intValue() < 21){
                return true;
            }
        }
        else{
            if(n.intValue() > -1 && n.intValue() < 11){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Toiminta pelin aloittamiselle.
     */
    class JatkaNapinToiminta implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moderni.isSelected()){
                alustaLaivojenKoot();
                ohjain.luoPeli(pelaaja1nimi.getText(), ruudukonkoko, kustomkoot);
                dispose();
            }
            else{
                ohjain.luoPeli(pelaaja1nimi.getText(), 10, defkoot);
                dispose();
            }
        }
    }
    
    class PelityylinToiminta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            alustaKokoJaMaara();
            lisaaKomponentitKayttoliittymaan();
        }
        
    }
    
}
