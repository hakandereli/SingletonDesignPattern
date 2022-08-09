/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EagerInitialization;

//1.Sabırsız Gerçekleme (Eager Initialization)
//Bu yöntemde sınıfın instance’ı sınıfın yüklenme anında oluşur. 
//Ancak instance, sınıfın yükleme anında oluştuğundan sınıf kullanılmasa bile instance oluşacağından gereksiz yer kaplar.

//Eğer oluşturğunuz sınıf çok fazla kaynak tarafından kullanılmıyorsa bu yöntemi kullanabilirsiniz.
//Ancak genelde singleton sınıfları dosya sistemlerine erişim, loglama, veritabanı bağlantıları vs, kullanıldığı için sınıf çağrılmadan instance’ı oluşturmaktan kaçınmalıyız.
//Aşağıdaki yöntemde oluşacak bir exception’ı da ele almak imkansızdır.

public class EagerInitialization {
    
    private static EagerInitialization instance = new EagerInitialization();
    
    private EagerInitialization(){
    
    }
    
    public static EagerInitialization getInstance(){
        return instance;
    }
}
