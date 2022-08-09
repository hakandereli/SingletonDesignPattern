/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//Genelde singleton sınıfları 
import EagerInitialization.EagerInitialization;
import EnumSingleton.EnumSingleton;
import LazyInitialization.LazyInitialization;
import StaticBlockInitialization.StaticBlockInitialization;
import ThreadSafeDoubleCheck.ThreadSafeDoubleCheckInitialization;
import ThreadSafeInitialization.ThreadSafeInitialization;

//  DOSYA SISTEMLERINE ERIŞIM(config gibi),    LOGLAMA,    VERITABANI BAĞLANTILARI VS için kullanılır.
public class Main {

//Singleton pattern bir sınıftan birden fazla instance oluşmasını engeller ve sanal makinada oluşturulan tek instance’ın kullanılmasını garanti eder.
//Singleton sınıfı, sınıfa ait instance’a ulaşmak için global erişim sağlamalıdır.
//Singleton sınıfının constructor’ı PRIVATE olmalıdır. Böylece o sınınftan yeni instance oluşturmak engellenmiş olur.
//Singleton sınıfın instance’ı içeride PRIVATE STATIC olarak tutulmalıdır.
//Tutulan instance’ı döndüren bir public static metoda sahip olmalıdır.
    
//1 Sabırsız Gerçekleme (Eager Initialization)
//2 Statik Blok Yöntemi (Static Block Initialization)
//3 Tembel Gerçekleme (Lazy Initialization)
//4 Thread Safe Gerçekleme (Thread Safe Initialization)
//5 Bill Pugh Singleton Yöntemi (Bill Pugh Singleton Implementation)
    
//BreakSingleton da ise singleton u bozan yapılar incelenmiştir.
    
    //En garanti yöntemi enumdır.
    public static void main(String[] args) {
        //1 Sabırsız Gerçekleme (Eager Initialization)
        EagerInitialization eagerInitializationInstance1 = EagerInitialization.getInstance();
        EagerInitialization eagerInitializationInstance2 = EagerInitialization.getInstance();

        System.out.println("--------------------Eager Initialization------------------------------");
        System.out.println(eagerInitializationInstance1.hashCode());
        System.out.println(eagerInitializationInstance2.hashCode());

        //2 Statik Blok Yöntemi (Static Block Initialization)
        StaticBlockInitialization staticBlockInitializationInstance1 = StaticBlockInitialization.getInstance();
        StaticBlockInitialization staticBlockInitializationInstance2 = StaticBlockInitialization.getInstance();

        System.out.println("----------------------Static Block Initialization----------------------------");
        System.out.println(staticBlockInitializationInstance1.hashCode());
        System.out.println(staticBlockInitializationInstance2.hashCode());

        
        //3 Tembel Gerçekleme (Lazy Initialization)
        LazyInitialization lazyInitializationInstance1 = LazyInitialization.getInstance();
        LazyInitialization lazyInitializationInstance2 = LazyInitialization.getInstance();
        
        System.out.println("-------------------Lazy Initialization-------------------------------");
        System.out.println(lazyInitializationInstance1.hashCode());
        System.out.println(lazyInitializationInstance2.hashCode());

        
        //4 Thread Safe Gerçekleme (Thread Safe Initialization)
        ThreadSafeInitialization threadSafeInitializationInstance1 = ThreadSafeInitialization.getInstance();
        ThreadSafeInitialization threadSafeInitializationInstance2 = ThreadSafeInitialization.getInstance();
        
        System.out.println("-------------------Thread Safe Initialization-------------------------------");
        System.out.println(threadSafeInitializationInstance1.hashCode());
        System.out.println(threadSafeInitializationInstance2.hashCode());
        
        //4-A Thread Safe Double Check
        ThreadSafeDoubleCheckInitialization threadSafeDoubleCheckInitializationInstance1 = ThreadSafeDoubleCheckInitialization.getInstance();     
        ThreadSafeDoubleCheckInitialization threadSafeDoubleCheckInitializationInstance2 = ThreadSafeDoubleCheckInitialization.getInstance();
        
        System.out.println("-------------------Thread Safe Double Check Initialization-------------------------------");
        System.out.println(threadSafeDoubleCheckInitializationInstance1.hashCode());
        System.out.println(threadSafeDoubleCheckInitializationInstance2.hashCode());
        
        //5 Enum Singleton
        System.out.println("-------------------Enum Singleton Initialization-------------------------------");
        EnumSingleton object1 = EnumSingleton.INSTANCE;
        object1.i = 5;
        System.out.println(object1.i);
        
        EnumSingleton object2 = EnumSingleton.INSTANCE;
        object2.i = 6;
        System.out.println(object1.i);
        
        
        

    }

}
