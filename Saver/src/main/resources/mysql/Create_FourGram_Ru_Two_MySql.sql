/*
Создание таблиц для фограм 2 вариант
*/
CREATE TABLE IF NOT EXISTS FOURGRAM_RU_VAR_TWO (
	RUID INT(20) NOT NULL auto_increment,
    WORD_ONE VARCHAR(200) NOT NULL,
    WORD_TWO VARCHAR(200) NOT NULL,
    WORD_THREE VARCHAR(200) NOT NULL,
    WORD_FOUR VARCHAR(200) NOT NULL,
    COUNT INT(20) NOT NULL,
    PRIMARY KEY (RUID)
);
