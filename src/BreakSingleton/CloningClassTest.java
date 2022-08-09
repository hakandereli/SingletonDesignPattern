/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BreakSingleton;

public class CloningClassTest implements Cloneable {
    
    private static CloningClassTest instance;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private CloningClassTest() {

    }

    public static CloningClassTest getInstance() {
        if (instance == null) {
            instance = new CloningClassTest();
        }
        return instance;
    }

}
