/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticBlockInitialization;

//Statik blok yöntemi de aynı şekilde Eager yönteme benzer ancak aradaki fark oluşacak exceptionları ele alabiliriz.
//Yine sınıfın instance’ı sınıfın yüklenme anında oluşur.
//Ve bu az öncede söylediğimiz gibi çokta istediğimiz bir şey değil.
public class StaticBlockInitialization {

    private static StaticBlockInitialization instance;

    private StaticBlockInitialization() {

    }

    static {

        try {
            
            instance = new StaticBlockInitialization();
            
        } catch (Exception e) {
            
            throw new RuntimeException("Exceptions can be handled here." + e );
            
        }

    }
    
    public static StaticBlockInitialization getInstance(){
        return instance;
    }

}
