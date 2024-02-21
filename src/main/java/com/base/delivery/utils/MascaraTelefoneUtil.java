package com.base.delivery.utils;

public class MascaraTelefoneUtil {

    public static String aplicarMascaraTelefone(String numeroTelefone) {
        if (numeroTelefone != null && numeroTelefone.length() >= 10) {
            String numeroLimpo = numeroTelefone.replaceAll("[^0-9]", "");
            StringBuilder telefoneFormatado = new StringBuilder("(");
            telefoneFormatado.append(numeroLimpo.substring(0, 2)).append(") ");
            telefoneFormatado.append(numeroLimpo.substring(2, 6)).append("-");
            telefoneFormatado.append(numeroLimpo.substring(6, 10));

            return telefoneFormatado.toString();
        }
        return numeroTelefone;
    }
}
