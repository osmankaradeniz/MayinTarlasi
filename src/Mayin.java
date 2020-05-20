/**
 *
 * @author Osman Karadeniz
 */
public class Mayin {
    
 enum bayrakDurumu {BİLİNMEYEN, MAYİN_BAYRAK, SUPHELİ};
 
 private boolean kutuTemizmi = false;
 private boolean kutuMayinmi = false;
 
 private bayrakDurumu bayrak = bayrakDurumu.BİLİNMEYEN;
 
 boolean kutuMayinmi() {
 return kutuMayinmi;
 } 
 
 void setMayin() {
 kutuMayinmi = true;
 }
 
 boolean kutuTemizmi() {
 return kutuTemizmi;
 }
 
 void Temizle() {
 kutuTemizmi = true;
 }
 
 bayrakDurumu getBayrakDurumu() {
 return bayrak;
 }
 
 bayrakDurumu setBayrakDurum() {
     
 if (bayrak == bayrakDurumu.BİLİNMEYEN) {
 bayrak = bayrakDurumu.MAYİN_BAYRAK;
 return bayrakDurumu.MAYİN_BAYRAK;
 }
 
 if (bayrak == bayrakDurumu.MAYİN_BAYRAK) {
 bayrak = bayrakDurumu.SUPHELİ;
 return bayrakDurumu.SUPHELİ;
 }
 
 if (bayrak == bayrakDurumu.SUPHELİ) {
 bayrak = bayrakDurumu.BİLİNMEYEN;
 return bayrakDurumu.BİLİNMEYEN;
 }
 
 return bayrakDurumu.BİLİNMEYEN;
 
 }
 
} 