/*создание таблицы для англоязычного словаря*/
CREATE TABLE IF NOT EXISTS DICTIONARY_EN (
	ENID INT(20) NOT NULL auto_increment,
    WORD VARCHAR(200) NOT NULL,
    COUNT INT(20) NOT NULL,
    PRIMARY KEY (ENID)
);