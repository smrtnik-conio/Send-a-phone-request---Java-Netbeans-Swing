/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author SMRTNIK
 */
public class Stampac {

    private Queue<Zahtev> hp;

    public Stampac() {
        this.hp = new LinkedList<>();
    }

    public void dodaj(Zahtev d) {
        this.hp.add(d);
    }

    public String brojDokumenata() {
        return String.valueOf(this.hp.size());
    }

    public void dokumentiReda(JComboBox jcb) {
        jcb.removeAllItems();
        Iterator<Zahtev> it = this.hp.iterator();
        while (it.hasNext()) {
            jcb.addItem(it.next());
        }
    }

    public void obrisi(Zahtev x) {
        this.hp.remove(x);
    }

    public void stampaj() {
        while (this.hp.size() > 0) {
            Zahtev x = this.hp.poll();
            try {
                Files.write(Paths.get(x.nazivZahteva), x.sadrzajZahteva.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(Stampac.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Queue<Zahtev> getHp() {
        return hp;
    }       

    

    //metod za stampanje preko programske niti sa proverom na 15 sekundi
    //metod za cuvanje podataka u memoriji - serijalizacija 
}
