package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;

/**
 * Created by User on 22.12.2014.
 */
public interface DocumentSaverToDB {
    public void saveRuDocumentToDB(String fileName, String format, AbstractSUBD db);

    public void saveEnDocumentToDB(String fileName, String format, AbstractSUBD db);
}
