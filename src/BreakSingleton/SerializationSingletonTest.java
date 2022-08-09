/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BreakSingleton;

import java.io.Serializable;

public class SerializationSingletonTest implements Serializable{
    
    public static SerializationSingletonTest instance = new SerializationSingletonTest();
    
    private SerializationSingletonTest(){
        
    }
    
    //Bu methodu ezersen eşleşir kalkar hata ortadan
//     protected Object readResolve()
//    {
//        return instance;
//    }
    
}
