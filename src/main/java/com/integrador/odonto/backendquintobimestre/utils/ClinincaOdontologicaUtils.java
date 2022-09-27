package com.integrador.odonto.backendquintobimestre.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

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
}