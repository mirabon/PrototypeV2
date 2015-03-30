package com.artech.prototype2.io;

import com.artech.prototype2.io.api.IOAPI;
import com.artech.prototype2.io.api.ManagerIOAPI;
import com.artech.prototype2.io.common.Common;
import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import com.artech.prototype2.vreshetnyak.output.Output;
import com.artech.prototype2.vreshetnyak.output.impl.DrawGraphImpl;
import com.artech.prototype2.vreshetnyak.output.impl.FormReportImpl;
import com.artech.prototype2.vreshetnyak.output.impl.InitOutputFormImpl;
import com.artech.prototype2.vreshetnyak.utils.GetDataFromInputForm;

/**
 * Главный класс модуля IO
 *
 */
public class App {

    public static void main(String[] args){
        Object t[][] = {
            {"я", 1, "сказал"},
            {"ты", 2, "сказал"},
            {"сказал", 3, "я"},
            {"я", 4, "ты"},
            {"ася", 5, "сказал"},
            {"ты", 6, "ася"},
            {"сказал", 7, "ася"},
            {"ася", 8, "показал"},
            {"ты", 9, "показал"},
            {"солнце", 10, "сказал"},
            {"ася", 11, "солнце"},
            {"показал", 12, "солнце"},
            {"астя", 13, "ася"},
            {"астя", 14, "солнце"},
            {"астя", 15, "я"},
            {"я", 16, "показал"}
        };
        DrawGraphImpl graph = new DrawGraphImpl(t);
//        String labelInputForm = "InputGUIForm";
//        ManagerIOAPI.getInstance().registery(labelInputForm, new InputFormImpl());
//        
//        ManagerIOAPI.getInstance().InputForm(labelInputForm);

//        /*
//         * Спим 10 сек 
//         */

//        
//        /*
//         * Возвращаем текст с формы
//         */
//        Common com = ManagerIOAPI.getInstance().getCommon(labelInputForm);
//        
//        GetDataFromInputForm d = new GetDataFromInputForm(com);
//        System.out.println(d.getData().toString());
//        
//        Output o = new InitOutputFormImpl();
//        o.OutputForm(args);
//
//        String[] arStrings = {"RUID", "WORLD", "COUNT"};
//        AbstractDao test = new DictionaryRuDaoImpl();
//
//        Output oForm = new FormReportImpl("Отчет по статистике", arStrings, test, "Название таблицы");
//        oForm.FormReportInit();
    }
}
