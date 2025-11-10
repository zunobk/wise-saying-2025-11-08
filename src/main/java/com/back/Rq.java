package com.back;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    private final String actionName;
    private final Map<String, String> paramsMap;

    public Rq(String cmd) {
        paramsMap = new HashMap<>();
        String[] cmdBits = cmd.split("\\?",2);

        actionName = cmdBits[0];
        String queryString = cmdBits.length == 2 ? cmdBits[1] : "";

        String[] queryStringBits = queryString.split("&");

        for(String queryParam : queryStringBits){
            String[] queryParamBits = queryParam.split("=",2);

            String key = queryParamBits[0].trim();

            if(key.isEmpty()) continue;

            String value = queryParamBits[1].trim();

            paramsMap.put(key,value);
        }

    }

    public String getActionName() {
        return actionName;
    }


    public String getParam(String name, String defaultValue) {
        return paramsMap.getOrDefault(name, defaultValue);
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        String value = getParam(paramName, "");

        if (value.isEmpty()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}

// 1시간 15분