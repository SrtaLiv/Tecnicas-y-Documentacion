package org.example.practicaParcial;

import java.util.HashSet;
import java.util.Set;

public class SistemaDeSocios {
    private Set<Socio> socios = new HashSet<>();
    private Set<String> actividades = new HashSet<>();

    public boolean agregarSocio(Socio socio) {
        return socios.add(socio);
    }

    // El método add devuelve true si la actividad fue añadida
    public boolean addActividad(String actividad) {
        return actividades.add(actividad);
    }
}