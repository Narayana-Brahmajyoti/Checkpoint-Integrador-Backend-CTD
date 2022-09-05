package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PacienteRepository {
    private static Map<Integer, PacienteEntity> pacienteMap = new HashMap<>();

    private static int idPaciente = 1;

    public PacienteEntity create(PacienteEntity pacienteEntity) {
        pacienteEntity.setId(idPaciente++);
        pacienteMap.put(pacienteEntity.getId(), pacienteEntity);
        return pacienteEntity;
    }

    public PacienteEntity getById(int id) {
        return pacienteMap.get(id);
    }

    public String delete(int id) {
        pacienteMap.remove(id);
        return "Deletado";
    }

    public PacienteEntity update(PacienteEntity pacienteEntity) {
        pacienteMap.put(pacienteEntity.getId(), pacienteEntity);
        return pacienteEntity;
    }

    public List<PacienteEntity> getAll() {
        List<PacienteEntity> pacienteEntities = new ArrayList<>();
        return pacienteEntities;
    }

}
