/**
 *
 * @author Osman Karadeniz
 */
public class MayinAlani {

    private final Mayin[][] mayinAlani;
    private final int satirlar;
        private final int sutunlar;
    private final int mayinlar;
    private int kalanMayinlar;
    private int acilmamisTemizKutular;
    
    enum oyunDurumu {
        KAZANDİ, KAYBETTİ, DEVAMEDİYOR
    };

    MayinAlani(int satirlar, int sutunlar, int mayinlar) {
        this.satirlar = satirlar;
        this.sutunlar = sutunlar;
        this.mayinlar = mayinlar;
        kalanMayinlar = mayinlar;
        acilmamisTemizKutular = satirlar * sutunlar - mayinlar;
        mayinAlani = new Mayin[satirlar][sutunlar];
        kur();
        doldur();
    }

    private void kur() {
        for (int i = 0; i < satirlar; i++) {
            for (int j = 0; j < sutunlar; j++) {
                mayinAlani[i][j] = new Mayin();
            }
        }
    }

    oyunDurumu TiklaKutuAc(int x, int y, boolean acildimi) {
        
        for (int i = 0; i < satirlar; i++) {
            for (int j = 0; j < sutunlar; j++) {
                if (i == x && j == y) {
                    
                    Mayin secilenMayin = mayinAlani[i][j];
                    
                    if (acildimi) {
                        if (secilenMayin.getBayrakDurumu() == Mayin.bayrakDurumu.MAYİN_BAYRAK) {
                            return oyunDurumu.DEVAMEDİYOR;
                        }
                        if (secilenMayin.kutuTemizmi()) {
                            return oyunDurumu.DEVAMEDİYOR;
                        }
                        if (secilenMayin.kutuMayinmi()) {
                            return oyunDurumu.KAYBETTİ;
                        } else {
                            return temizleriAc(i, j);
                        }
                    } else {
                        Mayin.bayrakDurumu state = secilenMayin.setBayrakDurum();
                        
                        if (state == Mayin.bayrakDurumu.MAYİN_BAYRAK) {
                            kalanMayinlar--;
                        } else if (state == Mayin.bayrakDurumu.SUPHELİ) {
                            kalanMayinlar++;
                        }
                    }
                }
            }
        }
        
        return oyunDurumu.DEVAMEDİYOR;
    }

    private void doldur() {
        doldur(0);
    }

    private void doldur(int mayinSayisi) {
        int suankiSayi = mayinSayisi;
        double mayinSansi = (double) mayinlar / (double) (satirlar * sutunlar);
        for (int i = 0; i < satirlar; i++) {
            for (int j = 0; j < sutunlar; j++) {
                Mayin secilenMayin = mayinAlani[i][j];
                if (!secilenMayin.kutuMayinmi()) {
                    if (Math.random() < mayinSansi) {
                        secilenMayin.setMayin();
                        suankiSayi++;
                        if (suankiSayi == mayinlar) {
                            return;
                        }
                    }
                }
            }
        }
        if (suankiSayi < mayinlar) {
            doldur(suankiSayi);
        }
    }
    
  
    void setKalanMayinlar(int kalanMayinlar)
    {
    this.kalanMayinlar=kalanMayinlar;
    }
    
    int getKalanMayinlar() {
        return kalanMayinlar;
    }

    private oyunDurumu temizleriAc(int x, int y) {
        if (x < 0 || y < 0 || x >= satirlar || y >= sutunlar) {
            return oyunDurumu.DEVAMEDİYOR;
        }
        Mayin secilenMayin = mayinAlani[x][y];
        
        if (secilenMayin.kutuMayinmi()) {
            return oyunDurumu.DEVAMEDİYOR;
        }
        if (!secilenMayin.kutuTemizmi()) {
            secilenMayin.Temizle();
            acilmamisTemizKutular--;
            if (acilmamisTemizKutular == 0) {
                return oyunDurumu.KAZANDİ;
            }
        }
        if (bitisikMayinSayisi(x, y) > 0) {
            return oyunDurumu.DEVAMEDİYOR;
        } else {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i < 0 || j < 0 || i >= satirlar || j >= sutunlar) {
                        continue;
                    } else if (!mayinAlani[i][j].kutuTemizmi()) {
                        temizleriAc(i, j);
                    }
                }
            }
        }
        return oyunDurumu.DEVAMEDİYOR;
    }

    int bitisikMayinSayisi(int x, int y) {
        int say = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                } else if (i < 0 || j < 0 || i >= satirlar || j >= sutunlar) {
                    continue;
                } else if (mayinAlani[i][j].kutuMayinmi()) {
                    say++;
                }
            }
        }

        return say;
    }

    boolean getTemizlenenMayin(int x, int y) {
        return mayinAlani[x][y].kutuTemizmi();
    }

    Mayin.bayrakDurumu getMayinBayrak(int x, int y) {
        return mayinAlani[x][y].getBayrakDurumu();
    }

    boolean isMayin(int x, int y) {
        return mayinAlani[x][y].kutuMayinmi();
    }
    
}
