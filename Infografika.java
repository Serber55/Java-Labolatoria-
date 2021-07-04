package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytul;
    
    public String adresMiniaturki;
    public String adresStrony;
    public String adresGrafiki;
    public int wysokosc;
    public int szerokosc;

    public Infografika(String tekst){

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find()) tytul = m.group(1);
        else tytul ="";

        pat = Pattern.compile("<link>(.*)/link");
        m = pat.matcher(tekst);
        if (m.find()) adresStrony = m.group(1);
        else adresStrony ="";

        pat = Pattern.compile("media:content url=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find()) adresGrafiki = m.group(1);
        else adresGrafiki ="";

        pat = Pattern.compile("media:thumbnail url=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find()) adresMiniaturki = m.group(1);
        else adresMiniaturki ="";

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find()) wysokosc = Integer.parseInt( m.group(1));
        else wysokosc = 0;

        pat = Pattern.compile("width=\"(.*)\" ");
        m = pat.matcher(tekst);
        if (m.find()) szerokosc = Integer.parseInt( m.group(1));
        else szerokosc = 0;

    }

    public void print() {
        System.out.println("Infografika: ");
        System.out.println("tytul: " + this.tytul);
        System.out.println("adresStrony: " + this.adresStrony);
        System.out.println("adresGrafiki: " + this.adresGrafiki);
        System.out.println("adresMiniaturki: " + this.adresMiniaturki);
        System.out.println("wysokosc: " + this.wysokosc);
        System.out.println("szerokosc: " + this.szerokosc);
    }
}