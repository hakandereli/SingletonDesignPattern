/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BreakSingleton;

import EagerInitialization.EagerInitialization;
import LazyInitialization.LazyInitialization;
import java.lang.reflect.Constructor;


public class ReflectionSingletonTest {
    
    public static void main(String[] args) {
        LazyInitialization instanceOne = LazyInitialization.getInstance();
        LazyInitialization instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitialization.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitialization) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
