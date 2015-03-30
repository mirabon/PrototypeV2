package com.artech.prototype2.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.impl.CreateDataBaseImpl;
import com.artech.prototype2.saver.dbo.impl.MySQL;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractSUBD db = new MySQL("dbconnect/dbconnect.properties");
        String label = "create_db";
        ManagerAPISaver.getInstance().registry(label, db, new CreateDataBaseImpl());
        ManagerAPISaver.getInstance().createDB(label, db);

        label = "dict_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryRuDaoImpl());
        Entity entity = new DictionaryRu();
        ((DictionaryRu) entity).setWord("example");
        ((DictionaryRu) entity).setCount(3);

        ManagerAPISaver.getInstance().save(label, db, entity);
        ((DictionaryRu) entity).setRuid(1);
  //      ManagerAPISaver.getInstance().delete(label, entity);
//        ((DictionaryRu) entity).setRuid(4);
       ((DictionaryRu) entity).setCount(10);
        ManagerAPISaver.getInstance().update(label, db, entity);
        
        List<Entity> dict = ManagerAPISaver.getInstance().getAll(label, db, DictionaryEn.class);
        for(Entity ent : dict){
            System.out.println(((DictionaryRu)ent).getWord());
        }


    }
}
