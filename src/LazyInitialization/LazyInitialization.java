/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LazyInitialization;

//Bu yöntem sınıfın instance’ı o sınıfa erişmek istenildiği anda oluşturulur. 
//Eğer bu sınıfa birden fazla thread erişmiyorsa sorunsuz olarak çalışır. 
//Birden fazla thread instance’ın oluşturulduğu yere aynı anda girerse farklı instance lar oluşur bu da singleton ilkesine aykırıdır.
//Farklı threadler olmadığı zaman bu yöntemde instance sınıfın yüklenme anında değil çağırılma anında oluştuğu için faydalıdır.

public class LazyInitialization {
    
    private static LazyInitialization instance;
    
    private LazyInitialization(){}
    
    public static LazyInitialization getInstance(){
        
        //Bir den fazla thread de işlem yapılıyorsa ve aynı anda buradan obje oluşturmaya çalışırsa hepsi null olarak görür ve farklı objeler oluşur.
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
}
