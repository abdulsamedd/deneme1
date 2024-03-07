package paket;
import paket.YorumSayacUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class YorumSayac {

	public static void main(String[] args) {
		
		//konsoldan dogru ifade girilmez ise uyari 
		if (args.length != 1) {
            System.out.println("Kullanım: java YorumSayac <dosya_adi.java>");
            System.out.println("Kullanım: java YorumSayac Motor.java");
            return;
        }
			
		 String dosyaAdi = args[0];//konsoldan girilen Motor.java
		 
		 
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(dosyaAdi));
	            String satir;
	            StringBuilder kod = new StringBuilder();

	            while ((satir = br.readLine()) != null) {
	                kod.append(satir).append("\n");
	            }

	            br.close();//dosya okuma islemi bitti.

	            String kodStr = kod.toString();

	            int tekSatirYorumSayisi = YorumSayacUtils.sayTekSatirYorumlar(kodStr);
	            int cokSatirYorumSayisi = YorumSayacUtils.sayCokSatirYorumlar(kodStr);
	            int javadocSayisi = YorumSayacUtils.sayJavadoclar(kodStr);

	            System.out.println("Tek Satır Yorum Sayısı: " + tekSatirYorumSayisi);
	            System.out.println("Çok Satırlı Yorum Sayısı: " + cokSatirYorumSayisi);
	            System.out.println("Javadoc Sayısı: " + javadocSayisi);
	            
	            //yorumlar
	            YorumSayacUtils.kaydetYorumlar(tekSatirYorumSayisi, cokSatirYorumSayisi, javadocSayisi);

	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        } 
		 

	}

}
