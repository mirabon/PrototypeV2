/*Создание таблицы англоязычных документов*/
CREATE TABLE IF NOT EXISTS DOCUMENTS_EN (
    DOCID INT(20) NOT NULL auto_increment,
    NAME VARCHAR(200) NOT NULL,
    FORMAT VARCHAR(10) NOT NULL,
    PRIMARY KEY (DOCID)
);