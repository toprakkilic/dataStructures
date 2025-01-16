import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //postfix bir ifadeyi hesaplayan kod

        //eğer gereğinden fazla işlem girersem stack boş hatası alırım

        //eğer işlemi eksik girersem sadece olan işlem kadar hesaplama yapar

        //yaptığım son düzenlemelere doğru kodu integer yerine float şekilde çalıştırmaya karar verdim

        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine();
        System.out.println(hesapla(postfix));
    }


      // girilen şeyin bir rakam mı olduğunu kontrol etmem gerekti bunun için parseint keşfettim.
    public static boolean isRakam (String str){
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //test ederken 0 a bölünmde hata olduğunu gördüm ve hata mesajı ekledim
    public static float islemYap (String islem, float num1, float num2) throws Exception {

        switch (islem){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0){
                    throw new Exception(new Exception("0'a bölünme hatası."));
                }
                return num1 / num2;
            case "^": //üs alma işlemini yapmadığını fark ettim
                return (float) Math.pow(num1,num2);

            case "%":
                return (float) num1 % num2; //artık mod da alıyor

                default:throw new Exception(new Exception("Geçersiz bir işlem girdiniz."));
        } 
    }
    //burada hesaplamaya çalışıyorum
    //Postfix ifadeyi hesaplayan metod
    //Son kontrollerinde programın hata vermemesi için 2 tane kontrol değişkeni ekledim .
    public static float hesapla (String str) throws Exception {

        //algoritmasını yazmak için postfix ifadeyi anlamak zor oldu
        GenericStack<Float> stack = new GenericStack<>(Float.class, str.length());
        String[] dizi = str.split("_");
        int islemSayisi = 0;
        int rakamSayisi = 0;

        for (String haneler : dizi){
            if (isRakam(haneler)){
                rakamSayisi = rakamSayisi+1;
            }
            else {
                islemSayisi = islemSayisi+1;
            }
            }


        if (rakamSayisi == islemSayisi+1 && rakamSayisi != 0 && islemSayisi !=0 ){
            for (String haneler : dizi){
                if (isRakam(haneler)){
                    stack.push(Float.parseFloat(haneler));
                    rakamSayisi = rakamSayisi+1;
                }
                else {

                    //numaraları yazarken başta ters yazmışkm yanlış cevap veriyordu çünkü LIFO olduğunu unuttum
                    float number2 = stack.pop();
                    float number1 = stack.pop();
                    float sonuc = islemYap(haneler, number1, number2);
                    stack.push(sonuc);
                }
            }
            return stack.pop();
        }

        else {
            throw new Exception(new Exception("Girdiğiniz ifade hatalı."));
        }

    }
}