/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Krisu
 */
public class KyselyDialogi extends JDialog implements ActionListener{
    
    JComboBox[] valitse;
    Object[] valinnat;
    JLabel[] indeksit;
    JPanel tausta;
    JPanel pohja, napinpohja;
    JButton seur;
    
    public KyselyDialogi(int laivojenmaara){
        
    }
    
    public void laivojenKokojenKysely(int maara){
        valinnat = new Object[] {1, 2, 3, 4, 5};
        Integer indeksi;
        valitse = new JComboBox[maara];
        indeksit = new JLabel[maara];
        seur = new JButton("Seuraava");
        tausta = new JPanel();
        pohja = new JPanel();
        napinpohja = new JPanel();
        pohja.setLayout(new GridLayout(maara, 2));
        for(int i = 0; i < maara; i++){
            indeksi = new Integer(i+1);
            indeksit[i] = new JLabel(indeksi.toString());
            pohja.add(indeksit[i]);
            valitse[i] = new JComboBox(valinnat);
            valitse[i].setSelectedIndex(0);
            pohja.add(valitse[i]);
        }
        seur.addActionListener(this);
        napinpohja.add(seur);
        tausta.add(pohja);
        tausta.add(napinpohja);
        setContentPane(tausta);
        setSize(100, 210);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
