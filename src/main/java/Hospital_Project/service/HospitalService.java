package Hospital_Project.service;

import Hospital_Project.repository.HospitalRepository;
import Hospital_Project.repository.PatientRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HospitalService {
    static Scanner scan = new Scanner(System.in);

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public void start(){

        int secim = -1;

     do {
         System.out.println("""
                 Lütfen giriş yapmak istediğiniz menü kodunu giriniz..

                 1-HASTANE YÖNETİCİSİ GİRİŞİ
                 2-DOKTOR GİRİŞİ
                 3-HASTA GİRİŞİ
                 4-HASTANE KADROMUZ
                 0-ÇIKIŞ""");

        try {
            secim = scan.nextInt();
        } catch (Exception e) {
            scan.nextLine();
            System.out.println("LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!");
        }
        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("HATALI GIRIS, TEKRAR DENEYINIZ!");
        }
     } while (secim!=0);

    }


    private void hospitalServiceMenu() throws IllegalStateException, IOException, InterruptedException, SQLException {
        int secim = -1;
        scan.nextLine();
        do {
            System.out.println("=========================================");
            System.out.println("""
                    LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:
                    \t=> 1-DOKTOR EKLE
                    \t=> 2-DOKTORLARI LISTELE
                    \t=> 3-UNVANDAN DOKTOR BULMA
                    \t=> 4-DOKTOR SIL
                    \t=> 5-HASTA EKLE
                    \t=> 6-HASTA BUL
                    \t=> 7-HASTA LISTELE
                    \t=> 8-HASTA SIL
                    \t=> 0-ANAMENU""");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (IllegalStateException e) {
                break;
            } catch (Exception e) {
                scan.nextLine();//dummy
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }

    public void contactUs() throws IOException, InterruptedException, IllegalStateException, SQLException {
        Files.lines(Paths.get("src/Hospital_Project/Yonetim.txt")).forEach(System.out::println);
        start();
    }

    public static void exit() {
        slowPrint("\033[32m================== BIZI TERCIH ETTIGINIZ ICIN TESEKKUR EDER SAGLIKLI GUNLER DILERIZ =================\033[0m\n", 20);
        System.out.println();
        slowPrint("\033[32m======================================= DEV TEAM 02 HASTANESI =======================================\033[0m\n", 20);
        System.out.println("Programdan çıkılıyor...");
        System.exit(0);
    }

    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
