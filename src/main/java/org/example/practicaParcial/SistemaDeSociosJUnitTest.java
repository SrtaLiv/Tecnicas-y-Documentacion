package org.example.practicaParcial;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SistemaDeSociosJUnitTest {
    private SistemaDeSocios sistema;

    private Set<String> actividades;
    public boolean addActivities(String ss){
        return actividades.add(ss);
    }

    @Before
    public void setUp() {
        sistema = new SistemaDeSocios();
        //actividades = new ArrayList<>(); //NO PUEDE SER ARRAYLIST PQ ARRAYLIST PERMITE DUPLICADOS
        actividades = new HashSet<>();
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

    @Test
    public void testAgregarActividadRepetida(){
        String actividad = "Hola";
        this.actividades.add(actividad);
        assertFalse(this.actividades.add(actividad)); //deberia dar falso, no se puede agregar la misma actividad
    } //assertFalse es como decirle, esto deberia dar falso ya q no puedo agregar actividades repetidas.

    //Comprobar que no es posible agregar actividades repetidas
    @Test
    public void testAgregarActividadUnica(){
        String actividad = new String(); //podria ser un objeto
        this.actividades.add(actividad);
        assertTrue(this.actividades.add(actividad));
    }

}
