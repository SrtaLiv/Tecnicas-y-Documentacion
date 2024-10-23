package org.example.restautant;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class UsuarioTest {
    Usuario usuario;

    //a. No existen usuarios repetidos
    @Test
    public void unicoUsuario(){
        Usuario user = new Usuario("olivia",3, 3, "oli");
        assertNotSame(usuario, user);
    }

    //b. Todos los usuarios poseen un correo electrónico válido (contiene @)
    @Test
    public void correoValido(){
        Usuario user = new Usuario("olivia",3, 3, "oli@gmail");
         assertTrue(user.getEmail().contains("@"));
    }

}
