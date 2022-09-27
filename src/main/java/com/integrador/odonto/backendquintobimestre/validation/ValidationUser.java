package com.integrador.odonto.backendquintobimestre.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUser {
    private static final int userMinLength = 8;
    private static final int userMaxLength = 20;
    private static final String userAllowedCharacters = "^([A-Za-z0-9]){1,}$";

    private static final int pwdMinLength = 8;
    private static final int pwdMaxLength = 60;
    private static final String pwdRegexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$";

    public ValidationUser() {
    }

    public String validationNomeUsuario(String nomeUsuario){
        if (nomeUsuario.trim().isBlank()){
            return "O nome do usuário não pode ser vazio!";
        } else if (nomeUsuario.trim().length() < userMinLength ){
            return "O número de caracteres do usuário é inferior a " + userMinLength + "!";
        } else if (nomeUsuario.trim().length() > userMaxLength) {
            return "O número de caracteres do usuário é superior a " + userMaxLength + "!";
        } else if (!isValid(nomeUsuario, userAllowedCharacters)) {
            return "O nome do usuário não pode conter caracteres especiais!";
        }
        return null;
    }

    private String validationNomeSenha(String senha){
        if (senha.trim().isBlank()){
            return "A senha não pode ser vazia!";
        } else if (senha.trim().length() < pwdMinLength ){
            return "A senha é inferior a " + userMinLength + "!";
        } else if (senha.trim().length() > pwdMaxLength) {
            return "A senha é superior a " + pwdMaxLength + "!";
        } else if (!isValid(senha, pwdRegexp)) {
            return "Sua senha não é válida!";
        }
        return null;
    }

    public boolean isValid(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }
}
