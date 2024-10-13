package org.example;

public class EcuacionPrimerGrado {

    private Parseador parseador = new Parseador();


    public void setParseador(Parseador parseador) {
        this.parseador = parseador;
    }


    public double obtenerResultado(final String ecuacion) {
        // Obtener las partes de la ecuación
        int parte1 = parseador.obtenerParte1(ecuacion);
        int parte2 = parseador.obtenerParte2(ecuacion);
        int parte3 = parseador.obtenerParte3(ecuacion);


        double resultado = (double) (parte3 - parte2) / parte1;


        return resultado;
    }

    public static void main(String[] args) {
        EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();


        String ecuacionEjemplo = "2x + 4 = 8";


        double resultado = ecuacion.obtenerResultado(ecuacionEjemplo);


        System.out.println("El resultado de la ecuación es: " + resultado);
    }
}
