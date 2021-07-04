package pl.lublin.wsei.java.cwiczenia.mylib;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class StringFun {

    public static String anarchize(String tekst) {
        String res = "";
        boolean lower = Character.isLowerCase(tekst.charAt(0));
        for (int i = 0; i < tekst.length(); i++) {
            if (lower)
                res += Character.toUpperCase(tekst.charAt(i));
            else
                res += Character.toLowerCase(tekst.charAt(i));
            lower = !lower;
        }
        return res;
    }

    public static String camelize(String tekst) {
        String[] tokens = StringUtils.split(StringUtils.normalizeSpace(tekst));
        if (tokens.length == 0) return "";
        String res = tokens[0].toLowerCase();
        for (int i = 1; i < tokens.length; i++) {
            res += StringUtils.capitalize(tokens[i].toLowerCase());
        }
        return res;
    }


    public static String deCamelize(String tekst) {
        String res = "";
        tekst = tekst.trim();
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == tekst.toUpperCase().charAt(i)) {
                res += " " + tekst.charAt(i);
                continue;
            }
            res += tekst.charAt(i);
        }
        return res.toLowerCase();
    }

    public static boolean isPalindrome(String tekst) {
        String tekst1 = "";
        String tekst2 = "";

        tekst = tekst.toLowerCase().trim();

        for (int i = 0; i < Math.floor(tekst.length() / 2); i++) {
            tekst1 += tekst.charAt(i);
            tekst2 += tekst.charAt(tekst.length() - i - 1);
        }
        return tekst1.equals(tekst2);
    }


    public static String shuffle(String tekst) {
        String losowe = "";
        tekst = tekst.trim();
        Random rand = new Random();
        int random;
        do {
            random = rand.nextInt((tekst.length()));
            losowe += tekst.charAt(random);
            tekst = tekst.substring(0, random) + tekst.substring(random + 1);
        } while (tekst.length() > 0);
        return losowe;
    }


}