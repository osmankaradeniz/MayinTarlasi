/**
 *
 * @author Osman Karadeniz
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MayinTarlasi {

    //BAŞLANGIÇ DEĞERLERİ START
    int sutunlar = 9;
    int satirlar = 9;
    int mayinSayisi = 10;
    //BAŞLANGIÇ DEĞERLERİ STOP

    JFrame frame = new JFrame("Mayın Tarlası");
    JPanel mayinPanel = new JPanel();
    JLabel kalanMayinMetin = new JLabel("Kalan Mayın :");
    JLabel bulunanMayinMetin = new JLabel("Bulunan: 0");
    JButton[][] mayinButtonlari;
    Dimension buttonBoyut = new Dimension(20, 20);

    MayinAlani mayinAlani;
    TarlaFareDinle fareDinle;
    TarlaTetikDinle tetikDinle;
    TarlaGenel genel;

    public MayinTarlasi() {

        genel = new TarlaGenel(this);
        tetikDinle = new TarlaTetikDinle(this, genel);
        fareDinle = new TarlaFareDinle(this, genel);

        kur();
    }

    void kur() {

        mayinButtonlari = new JButton[satirlar][sutunlar];

        for (int i = 0; i < satirlar; i++) {
            for (int j = 0; j < sutunlar; j++) {
                JButton varsayılanButtonlar = new JButton();
                mayinButtonlari[i][j] = varsayılanButtonlar;
                varsayılanButtonlar.setPreferredSize(buttonBoyut);
                varsayılanButtonlar.setMaximumSize(buttonBoyut);
                varsayılanButtonlar.setMinimumSize(buttonBoyut);
                varsayılanButtonlar.addMouseListener(fareDinle);
                varsayılanButtonlar.setEnabled(true);
                varsayılanButtonlar.setText("");
                varsayılanButtonlar.setIcon(null);
            }
        }

        mayinPanel.setLayout(new GridLayout(satirlar, sutunlar));
        for (int i = 0; i < satirlar; i++) {
            for (int j = 0; j < sutunlar; j++) {
                mayinPanel.add(mayinButtonlari[i][j]);
            }
        }

        mayinAlani = new MayinAlani(satirlar, sutunlar, mayinSayisi);

    }

    private void Panelİslemleri(JFrame pencere) {

        Border pencereSinir = BorderFactory.createEmptyBorder(2, 2, 2, 2);

        JPanel kontrolPanel = new JPanel();
        
        bulunanMayinMetin.setBorder(pencereSinir);
        bulunanMayinMetin.setAlignmentX(Component.LEFT_ALIGNMENT);

        kalanMayinMetin.setAlignmentX(Component.RIGHT_ALIGNMENT);
        kalanMayinMetin.setBorder(pencereSinir);
        kalanMayinMetin.setText("Kalan Mayın : " + mayinAlani.getKalanMayinlar());

        kontrolPanel.add(bulunanMayinMetin);
        kontrolPanel.add(kalanMayinMetin);

        GridLayout gridLayout = new GridLayout(1, 1);

        kontrolPanel.setLayout(gridLayout);
        pencere.getContentPane().add(kontrolPanel);
        pencere.getContentPane().add(mayinPanel);

    }

    private void ustMenuEkle(JFrame frame) {

        JMenu oyun_ayarlari = new JMenu("Oyun Ayarları");

        JMenuItem yeniOyun = new JMenuItem("Yeni Oyun");
        yeniOyun.addActionListener(tetikDinle);
        oyun_ayarlari.add(yeniOyun);

        JMenuItem baslangicSeviye = new JMenuItem("Başlangıç Seviyesi (9 x 9 , 10 mayın)");
        baslangicSeviye.addActionListener(tetikDinle);
        oyun_ayarlari.add(baslangicSeviye);

        JMenuItem normalSeviye = new JMenuItem("Normal Seviye (16 x 16, 40 mayın)");
        normalSeviye.addActionListener(tetikDinle);
        oyun_ayarlari.add(normalSeviye);

        JMenuItem uzmanSeviye = new JMenuItem("Uzman Seviye (16 x 30, 99 mayın)");
        uzmanSeviye.addActionListener(tetikDinle);
        oyun_ayarlari.add(uzmanSeviye);

        JMenuItem ozelSeviye = new JMenuItem("Özel Oyun Alanı");
        ozelSeviye.addActionListener(tetikDinle);
        oyun_ayarlari.add(ozelSeviye);

        JMenuItem cikisNesne = new JMenuItem("Çıkış");
        cikisNesne.addActionListener(tetikDinle);
        oyun_ayarlari.add(cikisNesne);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(oyun_ayarlari);
        frame.setJMenuBar(menuBar);
    }

    private void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        Panelİslemleri(frame);
        ustMenuEkle(frame);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MayinTarlasi mayintarlasi = new MayinTarlasi();
        mayintarlasi.createAndShowGUI();
    }

}
