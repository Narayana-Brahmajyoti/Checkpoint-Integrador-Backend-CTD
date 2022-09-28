package com.integrador.odonto.backendquintobimestre.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;
import java.util.List;

public class ClinincaOdontologicaUtils {

    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

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
