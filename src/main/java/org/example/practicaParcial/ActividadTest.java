package org.example.practicaParcial;


import org.example.practicaParcial.Parcial2021.*;
import org.example.restautant.Almacen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActividadTest {

    //Comprobar que no es posible agregar actividades repetidas
    Actividad actividad;
    ArrayList<Actividad> actividads = new ArrayList<>();

    @Before
    public void setUp(){
        Persona persona = new Persona("Ola", "Todes", "2",12);

        actividad = new Actividad("Fútbol", persona, 15, 12);

        ArrayList<Socio> inscriptos = new ArrayList<>();
        Socio s1 = new Socio("Juanse", "Pereoz", "30223223323", 19);
        Socio s2 = new Socio("Oli", "Pereoz", "30223223323", 19);
        Socio s3 = new Socio("Santi", "Pereoz", "30223223323", 19);
        inscriptos.add(s1);
        inscriptos.add(s3);
        inscriptos.add(s2);

        actividad.setInscriptos(inscriptos);

        actividads.add(new Actividad("Voley", persona, 2, 12));
        actividads.add(new Actividad("Yoga", persona, 20, 18));
        actividads.add(new Actividad("Fútbol", persona, 15, 12));

        actividad.setCupo(5);
    }

    @Test
    public void comprobarActividadesRepetidas(){
        Persona persona = new Persona("Ola", "Todes", "2",12);
        Actividad act = new Actividad("Fútbol", persona, 15, 12);

        boolean actividad = compararActividades(act);

        Assert.assertFalse("no deberias agregar actividades repetidas", actividad);
    }

    public boolean compararActividades(Actividad actividad){
        for (Actividad actividad2 : actividads){
            if (actividad.equals(actividad2))
                return true;
        }
        return false;
    }

    //Comprobar que el encargado de una actividad es un socio de la nómina
    @Test
    public void esSocioDeLaNomina(){
        ArrayList<Socio> inscriptos = actividad.getInscriptos();

        for (Socio socio : inscriptos){
            if (socio.getPersona().equals(actividad.getEncargado())){
                Assert.assertTrue("El encargado de la actividad es un socio", true);
            }

        }
    }

    //Comprobar que el método toString() de Actividad devuelve una cadena con el formato "<NombreActividad> a cargo de <Apellido>"
    @Test
    public void comprobarCadenaToString(){
        Persona persona = new Persona("Olivia", "Todes", "2",12);

        Actividad actividad = new Actividad("Matemáticas", persona, 10, 12  ); // Ejemplo de inicialización

        String expected = "Matemáticas a cargo de Olivia";

        assertEquals(expected, actividad.toString());
    }


    //Crear un test dinámico que pemita comprobar que todos los inscriptos de una actividad cumplen con la edad mínima
    @Test
    public void comprobarEdadMinimaNoDinamico(){
            for (int i = 0; i < actividad.getInscriptos().size(); i++){
                if (actividad.getInscriptos().get(i).getPersona().getEdad() < 18){
                    Assert.fail("Tienes menos de 18, adios!!");
                    break;
                }
            }
            Assert.assertTrue("Todos cumplen la edad minima!", true);

    }

    @TestFactory
    public void comprobarEdadMinimaDinamico(){
       //implementar

    }

    //Comprobar que al intentar inscribir más usuarios del cupo permitido, se dispara la excepción CupoExcedidoException
    @org.junit.Test
    public void inscribirUsuario(){
        try{
            while (true){
                actividad.inscribirSocio(new Socio("C", "c", "so", 23));

                if (actividad.getInscriptos().size() > actividad.getCupo()){
                    Assert.fail("Excepcion no disparada");
                    break;
                }
            }
        }
        catch (CupoExcedidoException e){
            Assert.assertTrue("Disparada", true);
        }
        catch (EdadInsuficienteException e) {

        }
    }

}