/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadSafeInitialization;

//Şimdi lazy initialization yöntemini nasıl thread safe yapabileceğimize göz atalım.
//Bunun en kolay yolu sınıfın global erişim metoduna synchronized koymaktır.
//Böylece metod herhangi bir thread tarafından çağırıldığı anda diğer threadler bu sınıfa erişemez ve birden fazla instance oluşturmanın önüne geçilmiş olur.
public class ThreadSafeInitialization {

    private static ThreadSafeInitialization instance;

    private ThreadSafeInitialization() {

    }

    public synchronized static ThreadSafeInitialization getInstance() {

        if (instance == null) {
            instance = new ThreadSafeInitialization();
        }
        return instance;
    }

    public String sampleMethodA() {
        return "SampleMethodA";
    }

    public String sampleMethodB() {
        return "SampleMethodB";
    }

    //Yukarıdaki metodta birden fazla erişim engellenir ancak synchronized kelimesi sınıfın tamamını kitlediği için performans sorunu yaratır.
    //Örneğin aşağıdaki gibi bir kullanımda sampleMethodA() ve sampleMethodB() fonksiyonları farklı metodlar olmasına rağmen farklı threadler tarafından aynı anda çağırılamaz. 
    //Çünkü getInstance’a koyduğumuz synchronized anahtar kelimesi tüm sınıfı kitler ve tek threadin kullanımına sunar.
    //Bu da singleton yapısının bozulmamasını garantiler ancak performans sorunlarına sebep olur.
}
