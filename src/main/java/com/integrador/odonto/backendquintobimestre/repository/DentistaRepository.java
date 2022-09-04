package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepository {

    private static Map<Integer, DentistaEntity> dentistaMap = new HashMap<>();

    private static int idDentista = 1;

    public DentistaEntity create(DentistaEntity dentistaEntity){
        dentistaEntity.setId(idDentista++);
        dentistaMap.put(dentistaEntity.getId(), dentistaEntity);
        return dentistaEntity;
    }

    public DentistaEntity getById(int id){
        return dentistaMap.get(id);
    }


    public int getByName(String nome){
        for (DentistaEntity dentistaEntity : dentistaMap.values()) {
            if (dentistaEntity.getNome().equalsIgnoreCase(nome))
                return dentistaEntity.getId();
        }

        return 0;
    }

    public DentistaEntity update(DentistaEntity dentistaEntity) {
        dentistaMap.put(dentistaEntity.getId(), dentistaEntity);
        return dentistaEntity;
    }

}
