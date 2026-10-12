package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PiezasTest {

    @Test
    void testPiezaDevuelveColorYMaterial() {
        Pieza pieza = new Pieza("rojo", "metal") {
            @Override
            public double getVolumen() {
                return 10.0;
            }

            @Override
            public double getSuperficie() {
                return 20.0;
            }
        };

        assertEquals("rojo", pieza.getColor());
        assertEquals("metal", pieza.getMaterial());
    }

    @Test
    void testEsferaCalculaVolumenYSuperficie() {
        Esfera esfera = new Esfera("azul", "vidrio", 2.0);

        assertEquals((4.0 / 3.0) * Math.PI * Math.pow(2.0, 3), esfera.getVolumen(), 0.0001);
        assertEquals(4 * Math.PI * Math.pow(2.0, 2), esfera.getSuperficie(), 0.0001);
    }

    @Test
    void testCilindroCalculaVolumenYSuperficie() {
        Cilindro cilindro = new Cilindro("verde", "metal", 3.0, 5.0);

        assertEquals(Math.PI * Math.pow(3.0, 2) * 5.0, cilindro.getVolumen(), 0.0001);
        assertEquals(2 * Math.PI * 3.0 * (3.0 + 5.0), cilindro.getSuperficie(), 0.0001);
    }

    @Test
    void testPrismaRectangularCalculaVolumenYSuperficie() {
        PrismaRectangular prisma = new PrismaRectangular("amarillo", "madera", 4.0, 2.0, 3.0);

        assertEquals(4.0 * 2.0 * 3.0, prisma.getVolumen(), 0.0001);
        assertEquals(2 * (4.0 * 2.0 + 4.0 * 3.0 + 2.0 * 3.0), prisma.getSuperficie(), 0.0001);
    }

    @Test
    void testReporteDeConstruccionSumaVolumenYSuperficiePorMaterial() throws Exception {
        Esfera esfera = new Esfera("azul", "madera", 2.0);
        Cilindro cilindro = new Cilindro("verde", "madera", 2.0, 3.0);
        PrismaRectangular prisma = new PrismaRectangular("rojo", "metal", 4.0, 2.0, 3.0);

        ReporteDeConstruccion reporte = new ReporteDeConstruccion();
        setPiezas(reporte, Arrays.asList(esfera, cilindro, prisma));

        assertEquals(esfera.getVolumen() + cilindro.getVolumen(), reporte.volumenDeMaterial("madera"), 0.0001);
        assertEquals(esfera.getSuperficie() + cilindro.getSuperficie(), reporte.superficieDeMaterial("madera"), 0.0001);
        assertEquals(prisma.getVolumen(), reporte.volumenDeMaterial("metal"), 0.0001);
        assertEquals(prisma.getSuperficie(), reporte.superficieDeMaterial("metal"), 0.0001);
        assertEquals(0.0, reporte.volumenDeMaterial("plastico"), 0.0001);
        assertEquals(0.0, reporte.superficieDeMaterial("plastico"), 0.0001);
    }

    private void setPiezas(ReporteDeConstruccion reporte, List<Pieza> piezas) throws Exception {
        Field field = ReporteDeConstruccion.class.getDeclaredField("piezas");
        field.setAccessible(true);
        field.set(reporte, piezas);
    }
}
