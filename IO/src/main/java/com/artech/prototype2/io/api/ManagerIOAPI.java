/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.io.api;

import com.artech.prototype2.io.common.Common;
import com.artech.prototype2.vreshetnyak.input.AbstractInput;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artem
 */
public class ManagerIOAPI implements IOAPI {

    private static ManagerIOAPI instance;
    protected Map<String, Common> ioContainer;

    public static ManagerIOAPI getInstance() {
        if (instance == null) {
            instance = new ManagerIOAPI();
        }
        return instance;
    }

    private ManagerIOAPI() {
        ioContainer = new HashMap<String, Common>();
    }

    public void registery(String label, Common test) {
        ioContainer.put(label, test);
    }

    public Common getCommon(String label) {
        return ioContainer.get(label);
    }

    public void InputForm(String label) {
        int i = 0;
        Common test = getCommon(label);
        if (test != null && i < 1) {
            ((AbstractInput) test).InputGUIForm();// метод InputGUIForm строит и отображает форму
            i++;
        }
    }
}
