/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BreakSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        //Serialization
        try
        {
            SerializationSingletonTest instance1 = SerializationSingletonTest.instance;
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();
      
            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
              
            SerializationSingletonTest instance2 = (SerializationSingletonTest) in.readObject();
            in.close();
      
            System.out.println("instance1 hashCode: "+ instance1.hashCode());
            System.out.println("instance2 hashCode: "+ instance2.hashCode());
        } 
          
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        System.out.println("-----------------------------------------");
        
        
        //Cloning
        CloningClassTest instanceA = CloningClassTest.getInstance();
        CloningClassTest instanceB = (CloningClassTest)instanceA.clone();
        System.out.println("instanceA hashcode : " + instanceA.hashCode());    
        System.out.println("instanceB hashcode : " + instanceB.hashCode());

        
        
        
    }
}
