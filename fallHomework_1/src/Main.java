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
    public static float islemYap (String islem, float t, float k) throws Exception {

        switch (islem){
            case "+":
                return t + k;
            case "-":
                return t - k;
            case "*":
                return t * k;
            case "/":
                if (k == 0){
                    throw new Exception(new Exception("0 a bolunme"));
                }
                return t / k;
            case "^": //üs alma işlemini yapmadığını fark ettim
                return (float) Math.pow(t,k);

            case "%":
                return (float) t % k; //artık mod da alıyor

                default:throw new Exception(new Exception(" gecersiz islem"));
        } 
    }
    //burada hesaplamaya çalışıyorum
    public static float hesapla (String str) throws Exception {

        //algoritmasını yazmak için postfix ifadeyi anlamak zor oldu
        GenericStack<Float> stack = new GenericStack<>(Float.class, str.length());
        String[] dizi = str.split("_");

        for (String haneler : dizi){
            if (isRakam(haneler)){
                stack.push(Float.parseFloat(haneler));
            }
            else {

                //numaraları yazarken başta ters yazmışkm yanlış cevap veriyordu çünkü LIFO olduğunu unuttum
                float n2 = stack.pop();
                float n1 = stack.pop();
                float sonuc = islemYap(haneler, n1, n2);
                stack.push(sonuc);
            }
        }
        return stack.pop();
    }
}