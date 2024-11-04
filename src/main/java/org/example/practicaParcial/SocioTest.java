package org.example.practicaParcial;


import org.example.practicaParcial.Parcial2021.Actividad;
import org.example.practicaParcial.Parcial2021.NominaSocios;
import org.example.practicaParcial.Parcial2021.Socio;
import org.example.restautant.Ingrediente;
import org.example.test.AlmacenTestNG;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

//import java.util.Set;

public class SocioTest{
    Socio socio;

    ArrayList<Socio> socios = new ArrayList<>();
    //Comprobar que no pueden agregarse socios repetidos


    @BeforeMethod
    public void setUp(){
        socios.add(new Socio("Juanse", "Pereoz", "30223223323", 19));
        socios.add(new Socio("Delfina", "Ferreyra", "234234234", 19));
        socios.add(new Socio("Olivia", "Todesco", "5983924", 19));
        socios.add(new Socio("Santi", "Llaurado", "45435524", 19));
    }

    //Comprobar que no pueden agregarse socios repetidos
    @Test
    public void verificarSociosRepetidos() {
        Socio socioPrueba = new Socio("Juan", "Perez", "30223223323", 12);

        //Si da falso significa que no se agreegan socios repetidos, el test pasa.
        Assert.assertFalse("No se debe agregar socio con mismo DNI",  agregarSocio(socioPrueba));
    }

    public boolean agregarSocio(Socio socioPrueba) {
        for (Socio socio1 : this.socios) {
            if (socio1.getPersona().getDni().equals(socioPrueba.getPersona().getDni())) {
                return true;
            }
        }
        return false;
    }

    //Generar un script de prueba que permita parametrizar la cantidad de elementos Socios generados aleatoriamente
    @DataProvider
    public Object[] generarSocios(){
        List<Socio> result = new ArrayList<>();
        for (int i = 0; i < socios.size(); i++){
            result.add( socios.get( (int) Math.random() * socios.size()));
        }
        return new Iterator[]{socios.iterator()};
    }


    // DataProvider que genera diferentes instancias de Socios
    //Crear un generador de datos de Socios para comprobar que el método toString() devuelve una cadena en formato <Nombre><Apellido>
    @Test(dataProvider = "generarSocios")
    public void generadorSociosToString(){

        String expected = socio.getPersona().getNombre() + " " + socio.getPersona().getApellido();

        Assert.assertEquals(expected, this.socio.toString());
    }


}