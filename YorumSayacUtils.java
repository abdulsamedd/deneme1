package paket;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class YorumSayacUtils {

	
	public static int sayTekSatirYorumlar(String kod) {
        int sayac = 0;
        String[] satirlar = kod.split("\n");

        for (String satir : satirlar) {
            if (satir.contains("//")) {
                sayac++;
            }
        }

        return sayac;
    }
	
	
	 public static int sayCokSatirYorumlar(String kod) {
	        int sayac = 0;
	        boolean yorumModu = false;

	        for (int i = 0; i < kod.length() - 1; i++) {
	            if (kod.charAt(i) == '/' && kod.charAt(i + 1) == '*') {
	                yorumModu = true;
	                sayac++;
	            } else if (kod.charAt(i) == '*' && kod.charAt(i + 1) == '/') {
	                yorumModu = false;
	            } else if (yorumModu && kod.charAt(i) == '\n') {
	                sayac++;
	            }
	        }

	        return sayac;
	    }

	    public static int sayJavadoclar(String kod) {
	        int sayac = 0;
	        boolean javadocModu = false;

	        for (int i = 0; i < kod.length() - 2; i++) {
	            if (kod.charAt(i) == '/' && kod.charAt(i + 1) == '*' && kod.charAt(i + 2) == '*') {
	                javadocModu = true;
	                sayac++;
	            } else if (kod.charAt(i) == '*' && kod.charAt(i + 1) == '/') {
	                javadocModu = false;
	            } else if (javadocModu && kod.charAt(i) == '\n') {
	                sayac++;
	            }
	        }

	        return sayac;
	    }
	    
	    public static void kaydetYorumlar(int tekSatir, int cokSatir, int javadoc) {
	        try {
	        	//txt dosyalari olusturuyor
	            BufferedWriter teksatirYorumDosya = new BufferedWriter(new FileWriter("teksatir.txt"));
	            BufferedWriter coksatirYorumDosya = new BufferedWriter(new FileWriter("coksatir.txt"));
	            BufferedWriter javadocDosya = new BufferedWriter(new FileWriter("javadoc.txt"));

	            String format = "Tek Satır Yorum Sayısı: %d\nÇok Satırlı Yorum Sayısı: %d\nJavadoc Sayısı: %d";

	            teksatirYorumDosya.write(String.format(format, tekSatir, 0, 0));
	            coksatirYorumDosya.write(String.format(format, 0, cokSatir, 0));
	            javadocDosya.write(String.format(format, 0, 0, javadoc));

	            teksatirYorumDosya.close();
	            coksatirYorumDosya.close();
	            javadocDosya.close();
	        } catch (IOException e) {
	            System.out.println("Dosya yazma hatası: " + e.getMessage());
	        }
	    }
	
}
