/**
 *
 * @author Osman Karadeniz
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class TarlaFareDinle implements MouseListener {

    private  MayinTarlasi mayinTarlasi;
    private  TarlaGenel TarlaGenel;

    public TarlaFareDinle(MayinTarlasi mayinTarlasi, TarlaGenel genel) {
        this.mayinTarlasi = mayinTarlasi;
        TarlaGenel = genel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton tiklananButton = (JButton) e.getSource();
        
        for (int i = 0; i < mayinTarlasi.satirlar; i++) {
            for (int j = 0; j < mayinTarlasi.sutunlar; j++) {
                
                if (tiklananButton == mayinTarlasi.mayinButtonlari[i][j]) {
                    
                    MayinAlani.oyunDurumu durum;
                    
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        
                        durum = mayinTarlasi.mayinAlani.TiklaKutuAc(i, j, true);
                        
                        if (durum == MayinAlani.oyunDurumu.DEVAMEDİYOR) {
                            if (mayinTarlasi.mayinAlani.getMayinBayrak(i, j) == Mayin.bayrakDurumu.BİLİNMEYEN) {
                                tiklananButton.removeMouseListener(this);
                            }
                        }
                    } else {
                        durum = mayinTarlasi.mayinAlani.TiklaKutuAc(i, j, false);
                    }
                    
                    if (durum == MayinAlani.oyunDurumu.KAZANDİ) {
                        TarlaGenel.oyunBitir(true);
                    } else if (durum == MayinAlani.oyunDurumu.KAYBETTİ) {
                        TarlaGenel.oyunBitir(false);
                    } else {
                        TarlaGenel.buttonlariGuncelle();
                    }
                    
                }
            }
        }
        TarlaGenel.MetinleriGuncelle();
    }
}
