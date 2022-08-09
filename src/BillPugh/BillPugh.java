package BillPugh;

//Java 5 ve öncesi bellek modelindeki problemden dolayı singleton sınıfına eş zamanlı erişilmeye çalışıldığında sorunlar ortaya çıkıyordu.
//Bu neden Bill Pugh yardımcı nested sınıf kullanarak singleton yapısı oluşturdu. 
//Böylece sınıfın instance’ı yardımcı sınıfta tutuluyor. 
//Sadece sınıf çağırıldığı zaman yardımcı sınıftan faydalanılarak instance çağrılıyordu.
//Böylece sınıfın yüklenme zamanında instance oluşmuyor sadece erişilmeye çalışıldığında oluşturuluyordu.
//Bu yöntemle geliştirilmiş singleton patterni aşağıdaki gibidir:

public class BillPugh {
    

    private BillPugh() {
    }

    private static class SingletonHelper {

        private static final BillPugh instance = new BillPugh();
    }

    public static BillPugh getInstance() {
        return SingletonHelper.instance;
    }
    
//    Singleton sınıfı belleğe yüklendiğinde yardımcı inner sınıf belleğe yüklenmez. 
//    Sadece birisi getInstance metodunu çağırdığında yüklenir.
//    Böylece senkronizasyon yapmaya da gerek kalmaz.
}
