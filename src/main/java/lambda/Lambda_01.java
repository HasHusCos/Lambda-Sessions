package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda_01 {

    public static void main(String[] args) {

        List <Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));
        //TASK  :   "Structured Programming" kullanarak list elemanlarını aynı satirda
        //          aralarında bosluk olacak sekilde print ediniz.
        printElStructured(sayi);
        System.out.println();
        printElFunctional(sayi);
        System.out.println();
        printElFunctional1(sayi); // Method Referance kullanirken hazir methodlaradokunamadigimiz icin burada
                                  // araya bosluk koyamadik. Bunu asmanin yollari mevcut.
        System.out.println();
        printElFunctional2(sayi);

        //TASK  :   "functional Programming" kullanarak list elemanlarını aynı satirda
        //          aralarında bosluk olacak sekilde print ediniz.

        //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda
        // aralarina bosluk birakarak print ediniz.
        System.out.println();
        printCiftElFunctional(sayi);
        System.out.println();



        // TASK  : functional Programming ile list elemanlarinin 34den küçük cift olanlarini
        // ayni satirda aralarina bosluk birakarak print ediniz
        printCiftOtcKckFunctional(sayi);
        System.out.println();
        printCiftOtcBykFunctional(sayi);



    }

    // Yukaridaki taski filter() kismini method referance ile yapalim
    public static boolean ciftBul(int a){
        return a%2 ==0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda_01::ciftBul).//method referance
                forEach(Lambda_01::yazdir);
    }

    public static void printCiftOtcBykFunctional(List <Integer> sayi){
        sayi.stream().filter(t-> t>30 || t%2==0).forEach(Lambda_01::yazdir);
    }

    public static void printCiftOtcKckFunctional(List <Integer> sayi){
        sayi.stream().filter(t->t<34 && t%2==0).forEach(Lambda_01::yazdir);
    }


    public static void printElStructured(List <Integer> sayi){
        for(Integer w : sayi){
            System.out.print(w+" ");
        }
    }

    public static void printElFunctional(List <Integer> sayi){
        sayi.
                stream().
                            forEach((t -> System.out.print(t+" ") )); // lambda expression
    }

    public static void printElFunctional1(List <Integer> sayi){
        sayi.
                stream().
                forEach(System.out::print); // Method referance
    }
    // Kendimiz bir method olusturalim
    public static void yazdir(int x){
        System.out.print(x+" ");
    }

    public static void printElFunctional2(List <Integer> sayi){
        sayi.
                stream().
                forEach(Lambda_01::yazdir);


    }

    public static void printCiftElFunctional(List <Integer> sayi){
        sayi.
                stream().filter(t->t%2 ==0).forEach(Lambda_01::yazdir);
    }



}



/*
    Programlama dilleri 2 grupta ayrilmaktadir.
        a) Functional
            - Ne yaparim sorusuna odaklanmaktadir.
            - Daha onceden tanimlanmis methodlar mevcuttur. Ve biz problemi bu methodlari cagirarak cozeriz.
            - Clojure, Scala gibi programlar bu gruptadir.
            - Bu grupta yapi olarak bagimlilik soz konusudur. Bu, bu grubun olumsuz ozelligidir.
        b) Structured
            - Java, c sharp, python bu turden dillerdir.
            - "Ne yaparim" sorusundan ziyade "nasil yaparim" sorusuna odaklanmaktadir.
            - Bu grupta yapi olarak bagimlilik soz konusu degildir. Bu, bu grubun olumlu ozelligidir.

        Functional ve Structured yapilari birlikte kullanarak calismamizi gelistirip kullanabiliriz

        LAMBDA

            - Java 8 ile gelmistir. Lambda ifadeleri bu guncelleme ile hayatimiza girmistir.
            - Herhangi bir Class'a ait olmadan is yapabilen fonksiyonlardir.
            - Lambda ve Stream.API;
                a) hiz,
                b) kod kisaligi,
                c) kod okunabilirligi ve
                d) hatasiz kod yazma acilarindan cok faydalidir.
            *** Mumkun oldugu kadar hazir methodlar kullanilmasi, kodumuzun hatasizligi acisindan onemlidir.
            - Olumsuz yonu : Collections ve Arraler ile uyumlu calisan bir yapidir; fakat Map ile calismaz.

            - Stream.API mantiginda Non-Terminal Operasyonlar, Terminal Operasyona'a kadar calisir ve Terminal
              operasyona gelince tamamlanir.
            - Stream Operation
                a) Intermediate Operation
                b) Terminal Operation

                (Hocanin Derste Attigi Not)
            1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
                Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
            2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
               "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
            3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
                ve hatasiz code yazma acilarindan cok faydalidir.
            4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir
                ancak map'lerde kullanılmaz.

 */
