package org.example;

public class EcuacionPrimerGrado {

    // Instancia de Parseador para dividir la ecuación en sus partes correspondientes
    private Parseador parseador = new Parseador();

    /**
     * Establece el parseador a usar para procesar las ecuaciones.
     * @param parseador El objeto Parseador que se utilizará para analizar las ecuaciones.
     */
    public void setParseador(Parseador parseador) {
        this.parseador = parseador;
    }

    /**
     * Método que recibe una ecuación lineal en forma de cadena y calcula el valor de la variable 'x'.
     * La ecuación debe estar en el formato estándar 'ax + b = c'.
     *
     * @param ecuacion La ecuación lineal como una cadena de texto (ejemplo: "2x + 4 = 8").
     * @return El valor de la variable 'x' que satisface la ecuación.
     */
    public double obtenerResultado(final String ecuacion) {
        // Obtener las partes de la ecuación: coeficiente de 'x', término constante y el resultado.
        int parte1 = parseador.obtenerParte1(ecuacion); // Coeficiente de 'x' (ej. 2 en "2x + 4 = 8")
        int parte2 = parseador.obtenerParte2(ecuacion); // Término constante (ej. 4 en "2x + 4 = 8")
        int parte3 = parseador.obtenerParte3(ecuacion); // Resultado a la derecha del '=' (ej. 8 en "2x + 4 = 8")

        // Aplicar la fórmula para resolver 'x': x = (parte3 - parte2) / parte1
        double resultado = (double) (parte3 - parte2) / parte1;

        return resultado;
    }

    /**
     * Método principal para probar la funcionalidad de la clase EcuacionPrimerGrado.
     * Utiliza un ejemplo de ecuación para obtener el resultado e imprimirlo en consola.
     */
    public static void main(String[] args) {
        EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

        // Ejemplo de ecuación para resolver
        String ecuacionEjemplo = "2x + 4 = 8";

        // Calcular el resultado y mostrarlo en consola
        double resultado = ecuacion.obtenerResultado(ecuacionEjemplo);

        System.out.println("El resultado de la ecuación es: " + resultado);
    }
}
