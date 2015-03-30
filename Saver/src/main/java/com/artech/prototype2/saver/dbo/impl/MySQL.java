/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.dbo.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author artem
 */
public class MySQL extends AbstractSUBD{
    
    protected Map<String, String> params;
    private Resources res;
    
    public MySQL(String config){
        params = new HashMap<String, String>();
        res = new Resources();
        getParamConnect(config);
    }
    
    private void getParamConnect(String config){
        try {
            this.login = res.getPropValue(config, "mysql.jdbc.login");
            this.password = res.getPropValue(config, "mysql.jdbc.pass");
            this.scripts = res.getPropValue(config, "mysql.jdbc.scripts");
            this.url = res.getPropValue(config, "mysql.jdbc.url");
            this.driverName = res.getPropValue(config, "mysql.jdbc.driverName");
            this.prop = res.getPropValue(config, "common.prop.jdbc");
        } catch (IOException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
