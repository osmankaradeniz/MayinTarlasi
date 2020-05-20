/**
 *
 * @author Osman Karadeniz
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color; 

public class TarlaGenel implements ActionListener {

    private MayinTarlasi mayinTarlasi;
    
    public TarlaGenel(MayinTarlasi mayinTarlasi) {
        this.mayinTarlasi = mayinTarlasi;
    }
    

    void MetinleriGuncelle() {
        mayinTarlasi.kalanMayinMetin.setText("Kalan Mayin: "+ mayinTarlasi.mayinAlani.getKalanMayinlar());
    }

    void buttonlariGuncelle() {
        
        for (int i = 0; i < mayinTarlasi.satirlar; i++) {
            for (int j = 0; j < mayinTarlasi.sutunlar; j++) {
                if (mayinTarlasi.mayinAlani.getTemizlenenMayin(i, j) == true) {
                    mayinTarlasi.mayinButtonlari[i][j].removeMouseListener(mayinTarlasi.fareDinle);
                    mayinTarlasi.mayinButtonlari[i][j].setIcon(Mayinİcon.getBosIcon());
                    int say = mayinTarlasi.mayinAlani.bitisikMayinSayisi(i, j);
                    if (say > 0) {
                        mayinTarlasi.mayinButtonlari[i][j].setIcon(Mayinİcon.getSayiIcon(say));
                    }

                } else {
                    if (mayinTarlasi.mayinAlani.getMayinBayrak(i, j) == Mayin.bayrakDurumu.MAYİN_BAYRAK) {
                        mayinTarlasi.mayinButtonlari[i][j].setIcon(Mayinİcon.getBayrakIcon());
                    } else if (mayinTarlasi.mayinAlani.getMayinBayrak(i, j) == Mayin.bayrakDurumu.SUPHELİ) {
                        mayinTarlasi.mayinButtonlari[i][j].setIcon(Mayinİcon.getSupheliIcon());

                    } else {
                        mayinTarlasi.mayinButtonlari[i][j].setIcon(null);
                    }
                }
            }
        }
    }
    

    void hepsiniGoster() {
        for (int i = 0; i < mayinTarlasi.satirlar; i++) {
            for (int j = 0; j < mayinTarlasi.sutunlar; j++) {
                boolean mayin = mayinTarlasi.mayinAlani.isMayin(i, j);
                if (mayin) {
                    mayinTarlasi.mayinButtonlari[i][j].setIcon(Mayinİcon.getMayinIcon());
                } else {
                    JButton secilenButton = mayinTarlasi.mayinButtonlari[i][j];
                    secilenButton.removeMouseListener(mayinTarlasi.fareDinle);
                    secilenButton.setBackground(Color.WHITE);
                    secilenButton.setIcon(null);
                    int say = mayinTarlasi.mayinAlani.bitisikMayinSayisi(i, j);

                    if (say > 0) {
                        secilenButton.setIcon(Mayinİcon.getSayiIcon(say));
                    }
                }
            }
        }
    }

    void oyunBitir(boolean kazandimi) {
        hepsiniGoster();
        String KazandimiKaybettimi;
        int option;
        if (kazandimi) {
            KazandimiKaybettimi = "Tebrikler Kazandınız !";
        } else {
            KazandimiKaybettimi = "Kaybettiniz.";
        }
        option = JOptionPane.showConfirmDialog(mayinTarlasi.frame, KazandimiKaybettimi
                + "Tekrar Oynamak İster misiniz ?", KazandimiKaybettimi,
                JOptionPane.YES_NO_OPTION);
        if (option == 1) {
            System.exit(0);
        } else {
            yeniOyun(mayinTarlasi.satirlar, mayinTarlasi.sutunlar);
        }
    }

    void yeniOyun(int oncekiSatirlar, int oncekiSutunlar) {
        for (int i = 0; i < oncekiSatirlar; i++) {
            for (int j = 0; j < oncekiSutunlar; j++) {
                mayinTarlasi.mayinPanel.remove(mayinTarlasi.mayinButtonlari[i][j]);
            }
        }
        mayinTarlasi.kur();
        mayinTarlasi.mayinPanel.validate();
        mayinTarlasi.frame.validate();
        mayinTarlasi.frame.pack();
        MetinleriGuncelle();
    }
    
    
    public static boolean int_sayimi(String deger)
    {
        try{
            Integer.parseInt(deger);
            return true;
        }catch (NumberFormatException e)
        {
        return false;
        }
    }
 
    
    // ÖZEL OYUN ALANI İÇİN NESNE TANIMLARI START
    public JFrame ozelFrame;
    public JButton olustur, iptal;
    public JPanel panel;
    public JTextField jt_yukseklik, jt_genislik, jt_mayinsayisi;
    public JLabel jl_yukseklik, jl_genislik, jl_mayinsayisi;
    // ÖZEL OYUN ALANI İÇİN NESNE TANIMLARI STOP
    
    
    public void ozelOyun()
    {
    
           

            ozelFrame = new JFrame("Özel Oyun Alanı");//tasarladigimiz ekranin yazisi
            ozelFrame.setBounds(300, 800, 275, 225);//pencere boyutlari
            //ozelFrame.setSize(300, 500);
            ozelFrame.setLocation(520, 230);// program çalistiginda ekran konumu
            ozelFrame.setVisible(true);

            panel = new JPanel();//paneli tanimliyoruz.
            panel.setLayout(null);//neseleri yerlestirmek için null olmali

            jl_yukseklik = new JLabel("Yükseklik :");
            jl_yukseklik.setForeground(Color.black);
            jl_yukseklik.setBounds(75, 20, 125, 25);
            jt_yukseklik = new JTextField();
            jt_yukseklik.setBackground(Color.white);
            jt_yukseklik.setBounds(140, 20, 60, 25);

            jl_genislik = new JLabel("Genişlik :");
            jl_genislik.setForeground(Color.black);
            jl_genislik.setBounds(85, 50, 125, 25);
            jt_genislik = new JTextField();
            jt_genislik.setBackground(Color.white);
            jt_genislik.setBounds(140, 50, 60, 25);

            jl_mayinsayisi = new JLabel("Mayın Sayısı :");
            jl_mayinsayisi.setForeground(Color.black);
            jl_mayinsayisi.setBounds(60, 80, 125, 25);
            jt_mayinsayisi = new JTextField();
            jt_mayinsayisi.setBackground(Color.white);
            jt_mayinsayisi.setBounds(140, 80, 60, 25);


            olustur = new JButton("Oluştur");// giris butonu
            olustur.setActionCommand("olustur");
            olustur.setBackground(Color.white);//renk
            olustur.setBounds(40, 120, 90, 30);//boyut
            olustur.addActionListener(this);
            
            iptal = new JButton("İptal");// giris butonu
            iptal.setActionCommand("iptal");
            iptal.setBackground(Color.white);//renk
            iptal.setBounds(140, 120, 80, 30);//boyut
            iptal.addActionListener(this);
            
            ozelFrame.setContentPane(panel);
            ozelFrame.setResizable(false);
            ozelFrame.setVisible(true);

            panel.add(jl_yukseklik);
            panel.add(jt_yukseklik);
            panel.add(jl_genislik);
            panel.add(jt_genislik);
            panel.add(jl_mayinsayisi);
            panel.add(jt_mayinsayisi);
            panel.add(olustur);
            panel.add(iptal);

    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        String komut = e.getActionCommand();
        
        if (komut.equals("olustur")) {
          String yukseklik,genislik,mayinsayisi;
          
          yukseklik= jt_yukseklik.getText();
          genislik= jt_genislik.getText();
          mayinsayisi= jt_mayinsayisi.getText();
          
          int kutu = Integer.parseInt(yukseklik)*Integer.parseInt(genislik);
          
          if( int_sayimi(yukseklik)==true && int_sayimi(genislik)==true && int_sayimi(mayinsayisi)==true)
          {
              if( kutu>=Integer.parseInt(mayinsayisi) && Integer.parseInt(mayinsayisi)>0 && Integer.parseInt(genislik)>1 && Integer.parseInt(yukseklik)>1)
              {
            int oncekiSatirlar = mayinTarlasi.satirlar;
            int oncekiSutunlar = mayinTarlasi.sutunlar;
            mayinTarlasi.satirlar = Integer.parseInt(yukseklik);
            mayinTarlasi.sutunlar = Integer.parseInt(genislik);
            mayinTarlasi.mayinSayisi = Integer.parseInt(mayinsayisi);
            yeniOyun(oncekiSatirlar, oncekiSutunlar);
            ozelFrame.setVisible(false);
              }
              else
              {           
                  JOptionPane.showMessageDialog(null, " SATIR , SÜTÜN , MAYIN DEĞERLERİ ORANTISIZ !");
              }
          }
          else
          {
           JOptionPane.showMessageDialog(null, " HATALI değer girişi veya BOŞ alan !");
          }
          
         
        } 
        
        if (komut.equals("iptal")) {
            ozelFrame.setVisible(false);
        }

    }
}


