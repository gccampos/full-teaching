package com.fullteaching.backend.Course;

import com.fullteaching.backend.course.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;

public class CourseTest {

    @Test
    @DisplayName("Teste de criação de curso vazio")
    public void criaCursoVazio() {
        Course curso = new Course();
        Assertions.assertEquals(0, curso.getId());
    }

    @Test
    @DisplayName("Teste de criação de curso com alguns atributos")
    public void criaCursoComAlgumasAtributos() {
        User professor = mock(User.class);
        Course curso = new Course("titulo do curso teste", "imagem.png", professor );
        Assertions.assertEquals("titulo do curso teste", curso.getTitle());
        Assertions.assertEquals("imagem.png", curso.getImage());
        Assertions.assertEquals(professor, curso.getTeacher());

    }

    @Test
    @DisplayName("Teste de criação de curso com todos atributos")
    public void criaCursoCompleto() {
        User professor = mock(User.class);
        CourseDetails courseDetails = mock(CourseDetails.class);
        Course curso = new Course("titulo do curso teste", "imagem.png", professor, courseDetails);
        Assertions.assertEquals("titulo do curso teste", curso.getTitle());
        Assertions.assertEquals("imagem.png", curso.getImage());
        Assertions.assertEquals(professor, curso.getTeacher());
        Assertions.assertEquals(courseDetails, curso.getCourseDetails());
    }

    @Test
    @DisplayName("Teste de equals com 2 cursos iguais")
    public void testaEqualsComCoursesIguais() {
        User professor = mock(User.class);
        Course curso = new Course("titulo do curso teste", "imagem.png", professor);
        curso.setId(1);
        assertTrue(curso.equals(curso));
    }

    @Test
    @DisplayName("Teste de equals de curso com null")
    public void testaEqualsComCoursesNull() {
        User professor = mock(User.class);
        Course curso = new Course("titulo do curso teste", "imagem.png", professor);
        assertFalse(curso.equals(null));
    }

    @Test
    @DisplayName("Teste de equals com 2 cursos diferentes")
    public void testeEqualsDiferentesCursos() {
        User professor = mock(User.class);
        Course curso = new Course("titulo do curso teste", "imagem.png", professor);
        curso.setId(1);
        Course curso1 = new Course("titulo do curso teste 2", "foto.png", professor);
        curso.setId(2);
        assertFalse(curso.equals(curso1));
    }

    @Test
    @DisplayName("Teste de criação de curso setando atributos")
    public void criaCursoSetandoAtributos() {
        long id = 1;
        User professor = mock(User.class);
        CourseDetails courseDetails = mock(CourseDetails.class);
        Set<Session> sessions =  new HashSet<Session>();
        sessions.add(mock(Session.class));
        Set<User> frequentadores =  new HashSet<User>();
        frequentadores.add(mock(User.class));
        //Setando os atributos
        Course curso = new Course();
        curso.setAttenders(frequentadores);
        curso.setCourseDetails(courseDetails);
        curso.setId(id);
        curso.setImage("imagem.png");
        curso.setSessions(sessions);
        curso.setTeacher(professor);
        curso.setTitle("titulo do curso teste");
        //Realiza Asserts
        Assertions.assertEquals("titulo do curso teste", curso.getTitle());
        Assertions.assertEquals("imagem.png", curso.getImage());
        Assertions.assertEquals(professor, curso.getTeacher());
        Assertions.assertEquals(courseDetails, curso.getCourseDetails());
        Assertions.assertEquals(frequentadores, curso.getAttenders());
        Assertions.assertEquals(sessions, curso.getSessions());
        Assertions.assertEquals(id, curso.getId());
    }

    @Test
    @DisplayName("Teste de toString da classe")
    public void testaToString() {
        User professor = new User("professor", "senha", "professor", "", "professor");
        Course curso = new Course("titulo do curso teste", "imagem.png", professor);
        String nomeCurso = "com.fullteaching.backend.Course[title: \"titulo do curso teste\", teacher: \"professor\", #attenders: 0, #sessions: 0]";
        Assertions.assertEquals(nomeCurso, curso.toString());
    }
}