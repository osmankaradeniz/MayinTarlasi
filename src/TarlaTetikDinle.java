/**
 *
 * @author Osman Karadeniz
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarlaTetikDinle implements ActionListener{

    private  MayinTarlasi mayinTarlasi;
    private  TarlaGenel TarlaGenel;

    public TarlaTetikDinle(MayinTarlasi mayinTarlasi, TarlaGenel genel) {
        this.mayinTarlasi = mayinTarlasi;
        TarlaGenel = genel;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Çıkış")) {
            System.exit(0);
        }
        
        if (e.getActionCommand().equals("Yeni Oyun")) {
            TarlaGenel.yeniOyun(mayinTarlasi.satirlar, mayinTarlasi.sutunlar);
            return;
        }
        
        if (e.getActionCommand().equals("Başlangıç Seviyesi (9 x 9 , 10 mayın)")) {
            int oncekiSatirlar = mayinTarlasi.satirlar;
            int oncekiSutunlar = mayinTarlasi.sutunlar;
            mayinTarlasi.satirlar = 9;
            mayinTarlasi.sutunlar = 9;
            mayinTarlasi.mayinSayisi = 10;
            TarlaGenel.yeniOyun(oncekiSatirlar, oncekiSutunlar);
            return;
        }
        
        if (e.getActionCommand().equals("Normal Seviye (16 x 16, 40 mayın)")) {
            int previousRows = mayinTarlasi.satirlar;
            int previousColumns = mayinTarlasi.sutunlar;
            mayinTarlasi.satirlar = 16;
            mayinTarlasi.sutunlar = 16;
            mayinTarlasi.mayinSayisi = 40;
            TarlaGenel.yeniOyun(previousRows, previousColumns);
            return;
        }
        
        if (e.getActionCommand().equals("Uzman Seviye (16 x 30, 99 mayın)")) {
            int previousRows = mayinTarlasi.satirlar;
            int previousColumns = mayinTarlasi.sutunlar;
            mayinTarlasi.satirlar = 16;
            mayinTarlasi.sutunlar = 30;
            mayinTarlasi.mayinSayisi = 99;
            TarlaGenel.yeniOyun(previousRows, previousColumns);
            return;
        }
        
        if (e.getActionCommand().equals("Özel Oyun Alanı")) {
        
            new TarlaGenel(mayinTarlasi).ozelOyun();
            
        }

    }
    
    

}