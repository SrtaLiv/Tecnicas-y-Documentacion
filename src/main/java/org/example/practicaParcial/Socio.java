package org.example.practicaParcial;

public class Socio {
    private String nombre;
    private String documento; // Por ejemplo, el número de documento como identificador único

    public Socio(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Socio)) return false;
        Socio socio = (Socio) obj;
        return documento.equals(socio.documento); // Comparamos por documento
    }

    @Override
    public int hashCode() {
        return documento.hashCode(); // Hash basado en documento
    }
}
