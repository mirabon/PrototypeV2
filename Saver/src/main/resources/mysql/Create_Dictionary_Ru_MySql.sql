/*создание таблицы для русского словаря*/
CREATE TABLE IF NOT EXISTS DICTIONARY_RU (
	RUID INT(20) NOT NULL auto_increment,
    WORD VARCHAR(200) NOT NULL,
    COUNT INT(20) NOT NULL,
    PRIMARY KEY (RUID)
);
