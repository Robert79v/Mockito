package org.example;

import java.util.regex.Pattern;

public class Parseador {

    public int obtenerParte1(final String ecuacion) {
        String[] partes1 = obtenerPartes12(ecuacion);
        String parte1 = partes1[0].trim();
        return Integer.valueOf(parte1.substring(0, parte1.length() - 1));
    }

    public int obtenerParte2(final String ecuacion) {
        String[] partes1 = obtenerPartes12(ecuacion);
        String parte2 = partes1[1].trim();

        // Verifica si el operador es un signo negativo y ajusta el valor de la parte2 en consecuencia
        String operador = obtenerOperador(ecuacion);
        if ("-".equals(operador)) {
            return Integer.valueOf(parte2) * (-1);  // Si el operador es "-", multiplica la parte por -1
        }

        return Integer.valueOf(parte2);  // Devuelve el valor de la segunda parte tal cual si el operador es "+"
    }

    public int obtenerParte3(final String ecuacion) {
        String[] partesEcuacion = ecuacion.split("=");
        return Integer.valueOf(partesEcuacion[1].trim());
    }

    private String[] obtenerPartes12(final String ecuacion) {
        String[] partesEcuacion = ecuacion.split("=");
        String operador = obtenerOperador(ecuacion);
        return partesEcuacion[0].split(Pattern.quote(operador));
    }

    public String obtenerOperador(final String ecuacion) {
        if (ecuacion.indexOf('+') > 0) {
            return "+";
        } else {
            return "-";
        }
    }
}
