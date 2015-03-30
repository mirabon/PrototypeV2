/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.dbo.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.CreateDataBase;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс занимается выполнением скриптов в очередности указанной в файле очереди
 *
 * @author CANDY
 */
public class CreateDataBaseImpl implements CreateDataBase {

    protected Resources res;


    public CreateDataBaseImpl() {
//        ManagerAPISaver.getInstance().registry("create_db", this);
        res = new Resources();
    }

    /**
     * Метод занимается созданием БД
     */
    public void createDB(AbstractSUBD db) {
        String script = db.getProp();
        List<String> scripts = res.getParseFileInLine(script);
        Connection conn = jdbcConnection(db);
        executeScripts(conn, scripts, db);
    }

    /**
     * Метод выполняет переданный массив скриптов
     * @param conn соединение с БД
     * @param scripts массив скриптов
     * @param db - класс инкапсулирует данные соединения
     */
    protected void executeScripts(Connection conn, List<String> scripts, AbstractSUBD db) {
        Statement stat = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder sql = new StringBuilder();
        try {
            stat = conn.createStatement();
            for (String script : scripts) {
                sb.append(db.getScripts());
                sb.append("/");
                sb.append(script);
                sql.append(res.getContentFile(sb.toString()));
                stat.executeUpdate(sql.toString());
                sql.setLength(0);
                sb.setLength(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateDataBaseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(stat!=null)
                    conn.close();
            }catch(SQLException sqlexp){
                sqlexp.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException sqlexp){
                sqlexp.printStackTrace();
            }
        }

    }

    /**
     * Установление соединения с CУБД
     */
    protected Connection jdbcConnection(AbstractSUBD db) {
        Connection conn = null;
        try {
            Class.forName(db.getDriverName());
            conn = (Connection) DriverManager.getConnection(db.getUrl(), db.getLogin(), db.getPassword());

        } catch (ClassNotFoundException cnfExp) {
            cnfExp.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDataBaseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

}
