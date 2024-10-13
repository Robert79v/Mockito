import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.example.EcuacionPrimerGrado;
import org.example.Parseador;

import static org.junit.Assert.*;

public class EcuacionPrimerGradoTest {

    private EcuacionPrimerGrado ecuacion;
    private Parseador parseadorMock;

    @Before
    public void setUp() {

        parseadorMock = mock(Parseador.class);

        ecuacion = new EcuacionPrimerGrado();

        ecuacion.setParseador(parseadorMock);
    }

    @Test
    public void testObtenerResultadoEcuacionSimple() {
        String ecuacionString = "2x + 4 = 8";


        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(2);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(4);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(8);


        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(2.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoEcuacionNegativa() {
        String ecuacionString = "3x - 6 = 9";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(3);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(-6);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(9);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(5.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConResultadoNegativo() {
        String ecuacionString = "4x + 3 = 1";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(4);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(3);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(1);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(-0.5, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConCero() {
        String ecuacionString = "5x = 0";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(5);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(0);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(0);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConParte1Negativa() {
        String ecuacionString = "-3x + 6 = 12";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(-3);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(6);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(12);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(-2.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConParte2Positiva() {
        String ecuacionString = "4x + 8 = 16";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(4);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(8);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(16);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(2.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConParte3Negativa() {
        String ecuacionString = "2x - 4 = -8";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(2);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(-4);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(-8);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(-2.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConFracciones() {
        String ecuacionString = "3x + 3 = 2";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(3);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(3);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(2);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(-0.333, resultado, 0.001); // Resultado esperado: -1/3
    }

    @Test
    public void testObtenerResultadoConGrandesValores() {
        String ecuacionString = "1000x - 2000 = 3000";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(1000);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(-2000);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(3000);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(5.0, resultado, 0.001);
    }

    @Test
    public void testObtenerResultadoConResultadoDecimal() {
        String ecuacionString = "7x + 2 = 3";

        when(parseadorMock.obtenerParte1(ecuacionString)).thenReturn(7);
        when(parseadorMock.obtenerParte2(ecuacionString)).thenReturn(2);
        when(parseadorMock.obtenerParte3(ecuacionString)).thenReturn(3);

        double resultado = ecuacion.obtenerResultado(ecuacionString);
        assertEquals(0.142857, resultado, 0.001); // Resultado esperado: 1/7
    }
}
