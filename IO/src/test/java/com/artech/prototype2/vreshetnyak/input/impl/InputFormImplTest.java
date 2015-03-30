/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.input.impl;

import com.artech.prototype2.vreshetnyak.input.Input;
import junit.framework.TestCase;

/**
 *
 * @author Василий
 */
public class InputFormImplTest extends TestCase {
    
    public InputFormImplTest(String testName) {
        super(testName);
    }

    public void testInputGUIForm() {
        System.out.println("InputGUIForm");
        Input instance = new InputFormImpl();
        instance.InputGUIForm();
        System.out.println("InputGUIForm - тест пройден!");
        
    }
    
}
