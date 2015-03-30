package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.impl.DocumentEnDaoImpl;
import com.artech.prototype2.saver.dao.impl.DocumentRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.DocumentEn;
import com.artech.prototype2.saver.entity.DocumentRu;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.statistics.DocumentSaverToDB;

/**
 * Created by User on 22.12.2014.
 */
public class DocumentSaverToDBImpl implements DocumentSaverToDB{
    @Override
    public void saveRuDocumentToDB(String fileName, String format, AbstractSUBD db) {
        String label = "document_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DocumentRuDaoImpl());

        DocumentRu doc = new DocumentRu();
        doc.setName(fileName);
        doc.setFormat(format);

        ManagerAPISaver.getInstance().saveOrUpdate(label, db, doc);
        new IndexesSaverToDBImpl().reCountRuIdf(db);
    }

    @Override
    public void saveEnDocumentToDB(String fileName, String format, AbstractSUBD db) {
        String label = "document_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DocumentEnDaoImpl());

        DocumentEn doc = new DocumentEn();
        doc.setName(fileName);
        doc.setFormat(format);

        ManagerAPISaver.getInstance().saveOrUpdate(label, db, doc);
        new IndexesSaverToDBImpl().reCountEnIdf(db);
    }
}
