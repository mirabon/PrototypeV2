﻿/*Создание таблицы IDF для русскоязычных слов*/
CREATE TABLE IF NOT EXISTS IDF_RU(
    RUID INT(20) NOT NULL,
    DOCS_COUNT INT(20) NOT NULL,
    IDF FLOAT(20) NOT NULL,
    PRIMARY KEY (RUID),
    CONSTRAINT FOREIGN KEY (RUID) REFERENCES DICTIONARY_RU (RUID) ON DELETE CASCADE ON UPDATE CASCADE
);