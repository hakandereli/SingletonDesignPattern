/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import EagerInitialization.EagerInitialization;
import LazyInitialization.LazyInitialization;
import StaticBlockInitialization.StaticBlockInitialization;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTest {

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //Genelde 1 saniye uyuttuğunda diğer thread ile aynı anda çağırır metodu.
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("HashCode of Lazy: " + LazyInitialization.getInstance().hashCode());
                System.out.println("HashCode of Eager: " + EagerInitialization.getInstance().hashCode());
                System.out.println("HashCode of StaticBlock: " + StaticBlockInitialization.getInstance().hashCode());
                System.out.println("HashCode of ThreadSafe: " + ThreadSafeInitialization.ThreadSafeInitialization.getInstance().hashCode());                
                System.out.println("HashCode of ThreadSafeDoubleCheck: " + ThreadSafeDoubleCheck.ThreadSafeDoubleCheckInitialization.getInstance().hashCode());

            }

        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("HashCode of Lazy: " + LazyInitialization.getInstance().hashCode());
                System.out.println("HashCode of Eager: " + EagerInitialization.getInstance().hashCode());
                System.out.println("HashCode of StaticBlock: " + StaticBlockInitialization.getInstance().hashCode());
                System.out.println("HashCode of ThreadSafe: " + ThreadSafeInitialization.ThreadSafeInitialization.getInstance().hashCode());
                System.out.println("HashCode of ThreadSafeDoubleCheck: " + ThreadSafeDoubleCheck.ThreadSafeDoubleCheckInitialization.getInstance().hashCode());
            }

        }).start();
        
         new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeInitialization.ThreadSafeInitialization.getInstance().sampleMethodA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeInitialization.ThreadSafeInitialization.getInstance().sampleMethodB();
            }
        }).start();
        
    }

}
