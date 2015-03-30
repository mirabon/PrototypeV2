package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.impl.*;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.*;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractNgram;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.*;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, сохраняющий статистику в БД.
 * Created by User on 13.12.2014.
 */
public class StatisticSaverToDBImpl implements StatisticSaverToDB {


    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(SingleWordRuStatisticImpl statistic, AbstractSUBD db) {
        //получить список из бд
        String label = "dict_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryRuDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, DictionaryRu.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }

    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(SingleWordRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<SingleWordRuImpl, Integer> mapDictionaryId = new HashMap<SingleWordRuImpl, Integer>();
        HashMap<SingleWordRuImpl, Integer> mapDictionaryCount = new HashMap<SingleWordRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            DictionaryRu dict = (DictionaryRu) ent;
            mapDictionaryCount.put(new SingleWordRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new SingleWordRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<SingleWordRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                DictionaryRu dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                DictionaryRu dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }

        return saveAndUpdateList;

    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(SingleWordEnStatisticImpl statistic, AbstractSUBD db) {
        String label = "dict_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryEnDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, DictionaryEn.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }


    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(SingleWordEnStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<SingleWordEnImpl, Integer> mapDictionaryId = new HashMap<SingleWordEnImpl, Integer>();
        HashMap<SingleWordEnImpl, Integer> mapDictionaryCount = new HashMap<SingleWordEnImpl, Integer>();

        for (Entity ent : listFromDb) {
            DictionaryEn dict = (DictionaryEn) ent;
            mapDictionaryCount.put(new SingleWordEnImpl(dict), dict.getCount());
            mapDictionaryId.put(new SingleWordEnImpl(dict), dict.getEnid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<SingleWordEnImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                DictionaryEn dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setEnid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                DictionaryEn dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(BigramRuStatisticImpl statistic, AbstractSUBD db) {
        String label = "bigram_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new BigramRuVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, BigramRuImpl.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(BigramRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<BigramRuImpl, Integer> mapDictionaryId = new HashMap<BigramRuImpl, Integer>();
        HashMap<BigramRuImpl, Integer> mapDictionaryCount = new HashMap<BigramRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            BigramRuVarOne dict = (BigramRuVarOne) ent;
            mapDictionaryCount.put(new BigramRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new BigramRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<BigramRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                BigramRuVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                BigramRuVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(BigramEnStatisticImpl statistic, AbstractSUBD db) {
        String label = "bigram_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new BigramEnVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, BigramEnImpl.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(BigramEnStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<BigramEnImpl, Integer> mapDictionaryId = new HashMap<BigramEnImpl, Integer>();
        HashMap<BigramEnImpl, Integer> mapDictionaryCount = new HashMap<BigramEnImpl, Integer>();

        for (Entity ent : listFromDb) {
            BigramEnVarOne dict = (BigramEnVarOne) ent;
            mapDictionaryCount.put(new BigramEnImpl(dict), dict.getCount());
            mapDictionaryId.put(new BigramEnImpl(dict), dict.getEnid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<BigramEnImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                BigramEnVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setEnid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                BigramEnVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(ThreegramRuStatisticImpl statistic, AbstractSUBD db) {
        String label = "threegram_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new ThreegramRuVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, ThreegramRuVarOne.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(ThreegramRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<ThreegramRuImpl, Integer> mapDictionaryId = new HashMap<ThreegramRuImpl, Integer>();
        HashMap<ThreegramRuImpl, Integer> mapDictionaryCount = new HashMap<ThreegramRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            ThreegramRuVarOne dict = (ThreegramRuVarOne) ent;
            mapDictionaryCount.put(new ThreegramRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new ThreegramRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<ThreegramRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                ThreegramRuVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                ThreegramRuVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(ThreegramEnStatisticImpl statistic, AbstractSUBD db) {
        String label = "threegram_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new ThreegramEnVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, ThreegramEnVarOne.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(ThreegramEnStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<ThreegramEnImpl, Integer> mapDictionaryId = new HashMap<ThreegramEnImpl, Integer>();
        HashMap<ThreegramEnImpl, Integer> mapDictionaryCount = new HashMap<ThreegramEnImpl, Integer>();

        for (Entity ent : listFromDb) {
            ThreegramEnVarOne dict = (ThreegramEnVarOne) ent;
            mapDictionaryCount.put(new ThreegramEnImpl(dict), dict.getCount());
            mapDictionaryId.put(new ThreegramEnImpl(dict), dict.getEnid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<ThreegramEnImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                ThreegramEnVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setEnid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                ThreegramEnVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(FourgramRuStatisticImpl statistic, AbstractSUBD db) {
        String label = "fourgram_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new FourgramRuVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, FourgramRuVarOne.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(FourgramRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<FourgramRuImpl, Integer> mapDictionaryId = new HashMap<FourgramRuImpl, Integer>();
        HashMap<FourgramRuImpl, Integer> mapDictionaryCount = new HashMap<FourgramRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            FourgramRuVarOne dict = (FourgramRuVarOne) ent;
            mapDictionaryCount.put(new FourgramRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new FourgramRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<FourgramRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                FourgramRuVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                FourgramRuVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    /**
     * Метод, сохраняющий статистику в БД.
     * При работе метода из БД подгружается список сущностей, затем на основании этого списка сущностей
     * и имеющейся статистики, создается список сущностей для обновления.
     * После чего этот список сохраняется в БД.
     * @param statistic
     * @param db
     */
    @Override
    public void saveStatisticToDB(FourgramEnStatisticImpl statistic, AbstractSUBD db) {
        String label = "fourgram_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new FourgramEnVarOneDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db, FourgramEnVarOne.class);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    /**
     * Вспомогательный метод, создающий список изменений на основании статистики и списка сущностей из БД.
     * При работе метода на основании списка сущностей создаются хэшкарты нграмма-количество и нграмма-id.
     * ПО каждой нграмме из статистики, проверяется, есть ли такая нграмма в хэшкарте.
     * Если есть, то в лист обновлений в количество записывается сумма того, что был и того, что есть в нашей статистике.
     * Если нет, то в листе обновлений количество берется из статистики.
     * @param statistic
     * @param listFromDb
     * @return
     */
    private List<Entity> makeListOfSaveAndUpdate(FourgramEnStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<FourgramEnImpl, Integer> mapDictionaryId = new HashMap<FourgramEnImpl, Integer>();
        HashMap<FourgramEnImpl, Integer> mapDictionaryCount = new HashMap<FourgramEnImpl, Integer>();

        for (Entity ent : listFromDb) {
            FourgramEnVarOne dict = (FourgramEnVarOne) ent;
            mapDictionaryCount.put(new FourgramEnImpl(dict), dict.getCount());
            mapDictionaryId.put(new FourgramEnImpl(dict), dict.getEnid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<FourgramEnImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                FourgramEnVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setEnid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                FourgramEnVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }
}