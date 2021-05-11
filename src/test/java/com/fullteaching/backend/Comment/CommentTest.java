package com.fullteaching.backend.Comment;

import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import com.fullteaching.backend.comment.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fullteaching.backend.user.User;

public class CommentTest {
    @Test
    @DisplayName("Teste de Criação de Comentário")
    public void criaComentario() {
        Comment comentario = new Comment();
        Assertions.assertEquals(0, comentario.getId());
    }

    @Test
    @DisplayName("Teste de Criação de Comentário setando atributos")
    public void criaComentarioSetandoAtributos() {
        //Declaração dos objetos necessários
        User usuario = mock(User.class);
        String mensagem = "teste de mensagem";
        long data = 123;

        //instânciação de comentário vazio
        Comment comentario = new Comment();

        //atribuotos
        comentario.setDate(data);
        comentario.setMessage(mensagem);
        comentario.setUser(usuario);
        comentario.setId(10);

        //realiza o assert
        Assertions.assertEquals(mensagem, comentario.getMessage());
        Assertions.assertEquals(usuario, comentario.getUser());
        Assertions.assertEquals(data, comentario.getDate());
        Assertions.assertEquals(10, comentario.getId());
    }

    @Test
    @DisplayName("Teste de Criação de Comentário com mensagem")
    public void criaComentarioComMensagem() {
        User usuario = mock(User.class);
        Comment comentario = new Comment(
                "Mensagem do comentário",
                123,
                usuario
        );

        //realiza o assert da mensagem e data
        Assertions.assertEquals("Mensagem do comentário", comentario.getMessage());
        Assertions.assertEquals(123, comentario.getDate());
        Assertions.assertEquals(usuario, comentario.getUser());
    }

    @Test
    @DisplayName("Teste de Criação de Comentário com usuario e pai")
    public void criaComentarioComUsuarioEPai() {
        User usuario = mock(User.class);
        //Declaração de comentário filho e teste de mensagem e data
        String mensagem = "comentário filho";
        long data = 123;
        Comment comment = new Comment(mensagem, data, usuario);
        Assertions.assertEquals(mensagem, comment.getMessage());
        Assertions.assertEquals(data, comment.getDate());

        //Declaração de comentário pai e teste de mensagem e data
        User usuarioComentarioPai = mock(User.class);
        String mensagemComentarioPai = "comentário pai";
        long dataComentarioPai = 1234;
        Comment commentParent = new Comment(mensagemComentarioPai, dataComentarioPai, usuarioComentarioPai, comment);
        Assertions.assertEquals(mensagemComentarioPai, commentParent.getMessage());
        Assertions.assertEquals(dataComentarioPai, commentParent.getDate());

        //relaciona comentários pai e filho
        comment.setCommentParent(commentParent);
        Assertions.assertEquals(commentParent, comment.getCommentParent());
    }


    @Test
    @DisplayName("Teste de Criação de Comentário com resposta")
    public void testeComentarioComResposta() {
        //Criação do usuario e comentário
        User usuario = mock(User.class);
        String mensagem = "mensagem de teste de resposta";
        long data = 123;
        Comment comentario = new Comment(mensagem, data, usuario);

        //Criação do usuario1 e resposta
        User usuario1 = mock(User.class);
        String mensagemResposta = "mensagem de teste de resposta";
        long date2 = 1234;
        Comment comentarioResposta = new Comment(mensagemResposta, date2, usuario1);

        //Criação de lista de comentários com os 2 já criados
        List<Comment> comentarios = new ArrayList<Comment>();
        comentarios.add(comentarioResposta);

        //Seta a resposta no comentario a partir da lista  e assert
        comentario.setReplies(comentarios);
        Assertions.assertEquals(comentarios, comentario.getReplies());
    }

    @Test
    @DisplayName("Teste do toString da classe")
    public void testeToString() {
        //Criação de comentario com mensagem
        User usuario = new User();
        String mensagem = "teste";
        long data = 123;
        Comment comentario = new Comment(mensagem, data, usuario);

        //Texto de null
        String nullString = "null";

        //Realiza Assert
        Assertions.assertEquals(
                "com.fullteaching.backend.Comment[message: \"" +mensagem + "\", author: \"" + usuario + "\", parent: \"" + nullString + "\", #replies: " + 0 + "date: \"" + data + "\"]", comentario.toString());
    }
}