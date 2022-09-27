package com.integrador.odonto.backendquintobimestre.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ClinincaOdontologicaUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String asJsonString(final Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch(Exception ex){
            throw  new RuntimeException();
        }
    }

    public static <T> T objectFromString(Class<T> aClass, String value){
        try {
            return mapper.readValue(value, aClass);
        } catch(Exception ex){
            throw  new RuntimeException();
        }
    }

    public <T> Object T (Class<T> aClass, String value){
        try {
            List<T> objectFromStringList = new ArrayList<>();
            for(Object objectlist: objectFromStringList) {
                objectFromStringList.add(mapper.readValue(value, aClass));
            }
            return objectFromStringList;
        } catch(Exception ex){
            throw  new RuntimeException();
        }
    }


}
