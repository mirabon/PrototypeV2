/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.solutioncenter.controller.impl;

import com.artech.prototype2.solutioncenter.controller.SolutionController;

/**
 *
 * @author CANDY
 */
public class SolutionControllerImpl implements SolutionController{
    private static SolutionControllerImpl instance;
    
    private SolutionControllerImpl(){
        
    }

    public static SolutionControllerImpl getInstance() {
        if(instance == null)
            instance = new SolutionControllerImpl();
        return instance;
    }
    
    /**
     * Получить текст
     * Обработать и перенаправить 
     * ответ на Output
     * @param text 
     */
    public boolean getText(String text) {
        if(!text.equals("")){
            
            return true;
        }
        return false;
    }

    public void getOutput() {

    }
    
    
}
