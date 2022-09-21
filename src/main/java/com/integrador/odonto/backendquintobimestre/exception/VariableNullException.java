package com.integrador.odonto.backendquintobimestre.exception;

import java.util.List;

public class VariableNullException extends Exception{
    private List<String> listVariable;

    public VariableNullException(String message, List<String> listVariable) {
        super(message);
        this.listVariable = listVariable;
    }

    public List<String> getListVariable() {
        return listVariable;
    }
}
