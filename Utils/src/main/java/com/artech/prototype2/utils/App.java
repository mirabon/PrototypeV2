package com.artech.prototype2.utils;

import com.artech.prototype2.bardakov.utils.impl.MultiParserImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.impl.CreateDataBaseImpl;
import com.artech.prototype2.saver.dbo.impl.MySQL;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.utils.FileParser;
import com.artech.prototype2.tsaplin.utils.impl.FileParserImpl;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {

    public static void testPDF() throws IOException{
        String fileName = "D:\\33.pdf";
        FileParser parser = new MultiParserImpl();
        ArrayList<String> test = parser.getListOfWordsFromFile(fileName, "pdf");
        System.out.println(((MultiParserImpl)parser).getEncoding(fileName));
        OutputStreamWriter out = new OutputStreamWriter(System.out, "UTF-8");
        for(String t : test){
            out.write(t+"\n");
        }
    }
    
    public static void createDB(){
        AbstractSUBD db = new MySQL("dbconnect/dbconnect.properties");
        String label = "create_db";
        ManagerAPISaver.getInstance().registry(label, db, new CreateDataBaseImpl());
        ManagerAPISaver.getInstance().createDB(label, db);
    }
    
    public static void testDOC() throws IOException{
        String fileName = "D:\\33.docx";
        FileParser parser = new MultiParserImpl();
        ArrayList<String> test = parser.getListOfWordsFromFile(fileName, "docx");
        System.out.println(((MultiParserImpl)parser).getEncoding(fileName));
        OutputStreamWriter out = new OutputStreamWriter(System.out, "UTF-8");
        for(String t : test){
            out.write(t+"\n");
        }
    }
    
    public static void testFB2() throws IOException{
        String fileName = "E:\\33.fb2";
        FileParser parser = new MultiParserImpl();
        ArrayList<String> test = parser.getListOfWordsFromFile(fileName, "fb2");
        System.out.println(((MultiParserImpl)parser).getEncoding(fileName));
        OutputStreamWriter out = new OutputStreamWriter(System.out, "UTF-8");
        for(String t : test){
            out.write(t+"\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
//        createDB();
//        testPDF();
//        testDOC();
        testFB2();
        System.out.println("Hello World!");
    }
}
