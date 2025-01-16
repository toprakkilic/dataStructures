import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>(); // orijinal liste
        LinkedList<Integer> myList2 = new LinkedList<>(); // 2. yöntem için olan liste
        LinkedList<Integer> myList3 = new LinkedList<>(); // 3. yöntem için kullanacağımız liste

        HashSet<Integer> mySet = new HashSet<>();

        //Bu yazdığım metod listeye source.txt'den aldığı integer değerleri listeye hashSet kullanarak ekler
        //bunu yazmak için hashset kullanmamın nedeni ise linkedlist sınıfındaki search metodunu kullanıp da yapabilirdim fakat çok fazla bellek erişimi olurdu
        //hashset kullanarak hem her defasında bütün listeyi gezmesini engelleyip programı hızlandırdım hem de bellekte daha kolaylık sağladım.


        //Ödevin a kısmı
        try (BufferedReader listeyeEkleme = new BufferedReader(new FileReader("source.txt"))){
            String line;
            String[] degerler ;
            while ((line = listeyeEkleme.readLine()) != null) {
                degerler = line.split(",");
                System.out.println("Dosyada " + degerler.length + " adet değer bulunmuştur. \n\n\n");
                for(String str : degerler) {
                    try {
                        if (!mySet.contains(Integer.parseInt(str))) { //bunun yerine direkt !(mylist.search(val)) yapabilirdim.
                            mySet.add(Integer.parseInt(str));
                            myList.addToEnd(Integer.parseInt(str));
                            myList2.addToEnd(Integer.parseInt(str));
                            myList3.addToEnd(Integer.parseInt(str));
                        }
                    }catch (Exception e) {
                        System.out.println("Verdiginiz değerlerden en az biri integer değil");
                    }
                }
            }


        }catch (Exception e){
            System.out.println("bir hata olustu");
        }


        //ödevin b kısmı
        try(BufferedReader yontem1 = new BufferedReader(new FileReader("search.txt"))){
            String line;
            String[] degerler ;
            double toplamBellekErisimi = 0;
            long startTime = System.currentTimeMillis(); // Ne kadar sürede çalıştığını ölçebilmek için
            while ((line = yontem1.readLine()) != null) { //
                degerler = line.split(","); // değerleri bir array içine koymak için
                for (String str : degerler) {
                    toplamBellekErisimi = toplamBellekErisimi + myList.searchWithMemoryAcsess(Integer.parseInt(str));
                }
                long endTime = System.currentTimeMillis(); // bitiş zamanı
                long elapsedTime = endTime - startTime;
                System.out.println("Birinci metodun çalışma süresi :" + elapsedTime + " milisaniyedir");
                System.out.println("Birinci metotta " + toplamBellekErisimi + " adet bellek erişimi olmuştur." );
                System.out.println("Birinci metotta " + toplamBellekErisimi / degerler.length + " adet ortalama bellek erişimi olmuştur.\n\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //ödevin c kısmı

        try(BufferedReader yontem2 = new BufferedReader(new FileReader("search.txt"))){
            String line;
            String[] degerler ;
            double toplamBellekErisimi = 0;
            long startTime = System.currentTimeMillis(); // zaman ölçmek için
            while ((line = yontem2.readLine()) != null) {
                degerler = line.split(",");
                for (String str : degerler) {
                    toplamBellekErisimi = toplamBellekErisimi + myList2.searchWithMemoryAcsessAddesToHead(Integer.parseInt(str));
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("İkinci metodun çalışma süresi :" + elapsedTime + " milisaniyedir");
                System.out.println("İkinci metotta " + toplamBellekErisimi + " adet bellek erişimi olmuştur." );
                System.out.println("İkinci metotta " + toplamBellekErisimi / degerler.length + " adet ortalama bellek erişimi olmuştur.\n\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        //Ödevin d kısmı
        //2. yöntem daha az memory acsess kullanıyor fakat %50 ye yakın bir yavaşlıkta çalışıyor
        //bellek açısından bulunan değeri head e almak daha mantıklıyken süre açısından ilk yöntem daha mantıklıdır


        //ödevin e kısmı
        //ben listeye sıralı bir şekilde ekleyip lineersearch yapmaya çalıştım fakat hem çalışma zamanı hem de bellek erişimi çok fazla oldu
        //Bir yöntem düşündüm fakat bulamadım ben de internetten bir yöntem araştırıp buldum (transposition yöntemi)
        //Bu yöntemde aranıp bulunan değeri bir sonraki değerle yer değiştirip aranma sıklığına göre daha verimli hale getiriyoruz



        //txt doyasında verilen değerleri arayıp bulduğu değerleri bir öncekiyle yer değiştirir.

        try(BufferedReader benimYontem = new BufferedReader(new FileReader("search.txt"))){
            String line;
            String[] degerler ;
            double toplamBellekErisimi = 0;
            long startTime = System.currentTimeMillis();
            while ((line = benimYontem.readLine()) != null) {
                degerler = line.split(",");
                for (String str : degerler) {
                    toplamBellekErisimi = toplamBellekErisimi + myList3.searchWithMemoryAcsessWithTransposition(Integer.parseInt(str));
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Üçüncü metodun çalışma süresi :" + elapsedTime + " milisaniyedir");
                System.out.println("Üçüncü metotta " + toplamBellekErisimi + " adet bellek erişimi olmuştur." );
                System.out.println("Üçüncü metotta " + toplamBellekErisimi / degerler.length + " adet ortalama bellek erişimi olmuştur.\n\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}