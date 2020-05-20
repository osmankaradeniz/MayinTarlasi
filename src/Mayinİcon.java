/**
 *
 * @author Osman Karadeniz
 */
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class Mayinİcon {
 private static final Icon mayinIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\mayin.jpg");
 private static final Icon bayrakIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\bayrak.jpg");
 private static final Icon supheliIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\soruisareti.jpg");
 private static final Icon bosIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\bos.png");
 private static final Icon birIcon = new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\1.png");
 private static final Icon ikiIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\2.png");
 private static final Icon ucIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\3.png");
 private static final Icon dortIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\4.png");
 private static final Icon besIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\5.png");
 private static final Icon altiIcon = new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\6.png");
 private static final Icon yediIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\7.png");
 private static final Icon sekizIcon =  new ImageIcon("C:\\Users\\Osman Karadeniz\\Documents\\NetBeansProjects\\MayinTarlasi\\src\\icons\\8.png");
 
 static Icon getMayinIcon() {
 return mayinIcon;
 }
 
  static Icon getBayrakIcon() {
 return bayrakIcon;
 }
  
    static Icon getBosIcon() {
 return bosIcon;
 }
 
 static Icon getSupheliIcon() {
 return supheliIcon;
 }
 
 static Icon getSayiIcon(int mineCount) {
 if (mineCount == 1) return birIcon;
 if (mineCount == 2) return ikiIcon; 
 if (mineCount == 3) return ucIcon;
 if (mineCount == 4) return dortIcon;
 if (mineCount == 5) return besIcon;
 if (mineCount == 6) return altiIcon;
 if (mineCount == 7) return yediIcon;
 if (mineCount == 8) return sekizIcon;
 return null;
 }
} 