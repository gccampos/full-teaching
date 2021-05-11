
package com.fullteaching.backend.User;

import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fullteaching.backend.course.Course;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserTest {

    @Test
    @DisplayName("Teste de criação de usuario")
    public void criaUsuarioVazio() {
        User usuario = new User();
        Assertions.assertEquals(0, usuario.getId().longValue());
    }

    @Test
    @DisplayName("Teste de criação de usuario pelo construtor")
    public void criaUsuarioComConstrutor() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");

        Assertions.assertEquals("usuario", usuario.getName());
        Assertions.assertEquals("usuario", usuario.getNickName());
        Assertions.assertEquals("usuario.png", usuario.getPicture());
    }

    @Test
    @DisplayName("Teste de criação de usuario setando atributos")
    public void criaUsuarioSetandoAtributos() {
        long id = 1;
        long date = 123;

        List<String> roles = new ArrayList<>();
        roles.add("role");
        Set<Course> cursos =  new HashSet<Course>();
        cursos.add(mock(Course.class));

        User usuario = new User();
        usuario.setCourses(cursos);
        usuario.setId(id);
        usuario.setName("usuario");
        usuario.setNickName("usuario");
        usuario.setPasswordHash("usuario");
        usuario.setPicture("usuario.png");
        usuario.setRegistrationDate(date);
        usuario.setRoles(roles);

        Assertions.assertEquals("usuario", usuario.getName());
        Assertions.assertEquals("usuario", usuario.getNickName());
        Assertions.assertEquals("usuario.png", usuario.getPicture());
        Assertions.assertEquals("usuario", usuario.getPasswordHash());
        Assertions.assertEquals(id, usuario.getId().longValue());
        Assertions.assertEquals(date, usuario.getRegistrationDate());
        Assertions.assertEquals(cursos, usuario.getCourses());
        Assertions.assertEquals(roles, usuario.getRoles());
    }

    @Test
    @DisplayName("Teste de equals de usuario com 2 usuarios")
    public void testeEqualsComUsuariosDiferentes() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");
        User usuario1 = new User("usuario2", "1234", "usuario2", "usuario2.png");

        assertFalse(usuario.equals(usuario1));
    }

    @Test
    @DisplayName("Teste de equals com mesmo usuario")
    public void testeEqualsComMesmoUsuario() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");
        assertTrue(usuario.equals(usuario));
    }

    @Test
    @DisplayName("Teste de criação de usuario null")
    public void testeEqualsComUsuarioNull() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");
        assertFalse(usuario.equals(null));
    }

    @Test
    @DisplayName("Teste de hash code")
    public void testeHashCode() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");
        Assertions.assertEquals("usuario".hashCode(), usuario.hashCode());
    }

    @Test
    @DisplayName("Teste de toString da classe")
    public void testeToString() {
        User usuario = new User("usuario", "123", "usuario", "usuario.png");
        Assertions.assertEquals("usuario", usuario.toString());

    }

}