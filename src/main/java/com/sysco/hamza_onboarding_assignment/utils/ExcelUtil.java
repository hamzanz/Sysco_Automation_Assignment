package com.sysco.hamza_onboarding_assignment.utils;

import com.syscolab.qe.core.excelUtils.ReadExcel;
import com.sysco.hamza_onboarding_assignment.data.LoginData;

/**
 * Created by Rifad on 3/6/18.
 */
public class ExcelUtil {

    public static LoginData getLoginData(String key) {
        Object loginObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty("user.dir") + "/src/main/resources/testData/TestData.xls", 0, LoginData.class);
        LoginData loginData = (LoginData) loginObject;
        return loginData;
    }

    public static <T> T getData(String key, String filename, Class<T> cls) {
        Object object = ReadExcel.getDataFromExcelSheet(key, System.getProperty("user.dir") + "/src/main/resources/testData/" + filename, 0, cls);
        T data = (T) object;
        return data;
    }
}
