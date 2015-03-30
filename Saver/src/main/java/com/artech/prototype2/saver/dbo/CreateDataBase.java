/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.dbo;

import com.artech.prototype2.saver.manager.CommonDB;

/**
 *
 * @author CANDY
 */
public interface CreateDataBase extends CommonDB{

    public void createDB(AbstractSUBD db);
    
}
