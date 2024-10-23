package org.example.practicaParcial;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SistemaDeSociosTestNGTest {
    private SistemaDeSocios sistema;

    @BeforeMethod //debe ejecutarse antes de cada método de prueba
    public void setUp() {
        sistema = new SistemaDeSocios();
    }

    @Test
    public void testAgregarSocioUnico() {
        Socio socio = new Socio("Juan Perez", "12345678");
        assertTrue(sistema.agregarSocio(socio)); // Debe ser verdadero, se agrega con éxito
    }

    @Test
    public void testAgregarSocioRepetido() {
        Socio socio = new Socio("Juan Perez", "12345678");
        sistema.agregarSocio(socio);
        assertFalse(sistema.agregarSocio(socio)); // Debe ser falso, no se puede agregar el mismo socio
    }



}
