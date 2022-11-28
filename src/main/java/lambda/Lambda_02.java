package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Lambda konusundaki map'in anlami, stream icindeki elemanlarin degerlerinde degisiklik yapilmasidir.

public class Lambda_02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println();
        ciftKarekokPrint(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        ciftElKarePrint(sayi);
        System.out.println();
        elTopla(sayi);
        System.out.println();
        elCiftCarp(sayi);
        System.out.println();
        elCiftCarpCiftParam(sayi);
        System.out.println();
        minBul(sayi);
        System.out.println();
        bestenBuyukMinBul(sayi);
        System.out.println();
        ciftleriSortYazdir(sayi);


    }

    // Task-1 : Functional Programming ile listnin cift elemanlarinin karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi) {
        sayi. // sayi List'ini elimize aliyoruz
                stream(). // stream ile akisa aliyoruz
                filter( // filter ile List icinden istedigimiz elemanlari filtreliyoruz
                Lambda_01::ciftBul). // Filtre icinde diger class'ta olusturdugumuz ciftBul methodunu yaziyoruz
                map(t -> t * t). // Bulunan cift sayilarin karelerini aliyoruz
                // map, stream mantiginda akisi degistiriyor.
                        forEach(Lambda_01::yazdir); // Lambda_01 Claas'indaki
        // yazdir methodu ile ekrana
        // yazdiriyoruz
    }

    // Task 2 : Functional Programming ile listin tek elemanlarinin kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void tekKupBirFazlaPrint(List<Integer> sayi) { // Method icine, kullanacagimiz list data tipini
        // tanimlamamiz gerekiyor
        sayi. // sayi List'ini elimize aliyoruz
                stream(). // stream ile akisa aliyoruz
                filter(t -> t % 2 != 0). // filter ile List icinden istedigimiz elemanlari filtreliyoruz
                map(t -> (t * t * t) + 1). // Bulunan tek sayilarin kuplerinin bir fazlasini aliyoruz
                // map, stream mantiginda akisi degistiriyor.
                        forEach(Lambda_01::yazdir);// Lambda_01 Claas'indaki
        // yazdir methodu ile ekrana
        // yazdiriyoruz
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda_01::ciftBul).
                map(Math::sqrt).
                forEach(t -> System.out.print(t + " "));
    }


    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // List icinden tek bir elemani yazdiracagimiz
        // durumlarda reduce() kullanilir.
        System.out.println(maxSayi);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElKarePrint(List<Integer> sayi) {
        Optional<Integer> enBuyukKare = sayi.
                stream().
                filter(Lambda_01::ciftBul).
                map(t -> t * t).
                reduce(Math::max);
        // Max elemani, Math Class'indan bulabildigimiz gibi
        // Integer Class'indan da bulabiliriz. Daha hizli
        System.out.println(enBuyukKare);
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);
       /*
            a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
            b degerini her zamana  stream()'dan akısdan alır
            a ilk degerinden sonraki her değeri action(işlem)'dan alır
*/
        System.out.println(toplam);
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void elCiftCarp(List<Integer> sayi) {
        Optional<Integer> sayi2 = sayi.
                                        stream().
                                                filter(Lambda_01::ciftBul).
                                                                           reduce(Math::multiplyExact);
       /*
            a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
            b degerini her zamana  stream()'dan akısdan alır
            a ilk degerinden sonraki her değeri action(işlem)'dan alır
*/
        System.out.println(sayi2);
    }

    public static void elCiftCarpCiftParam(List<Integer> sayi) {
        int sayi3 = sayi.
                        stream().
                                 filter(Lambda_01::ciftBul).reduce(1, (a, b) -> a * b);
       /*
            a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
            b degerini her zamana  stream()'dan akısdan alır
            a ilk degerinden sonraki her değeri action(işlem)'dan alır
*/
        System.out.println(sayi3);
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi){
        System.out.println(sayi.stream().reduce(Integer.MAX_VALUE,(a,b)-> a>b?b:a )); // Integer alabilmek icin
    }

    public static int minBulIcerik(int a, int b){
       return a>b? b:a;
    }

    public static int minBulInt(int a, int b){
        return a>b? b:a;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukMinBul(List<Integer> sayi){
        System.out.println(sayi.
                                stream().
                                        filter(t->t>5 && t%2==1).
                                                        reduce(Integer.MAX_VALUE,(a,b)-> a>b?b:a )); // Integer alabilmek icin
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftleriSortYazdir(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda_01::ciftBul).
                map(t -> t * t).
                sorted().forEach(Lambda_01::yazdir);

    }
}

