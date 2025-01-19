//package com.alura.literalura.service;
//
//import com.alura.literalura.model.Autor;
//import com.alura.literalura.model.Livro;
//import com.alura.literalura.repository.AutorRepository;
//import com.alura.literalura.repository.LivroRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class LivroServiceTests {
//
//    @Mock
//    private LivroRepository livroRepository;
//
//    @Mock
//    private AutorRepository autorRepository;
//
//    @Mock
//    private GutendexClient gutendexClient;
//
//    @InjectMocks
//    private LivroService livroService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testBuscarLivrosDaApi() throws Exception {
//        Livro livro = new Livro();
//        Autor autor = new Autor();
//        autor.setNome("Autor Teste");
//        livro.setTitulo("Livro Teste");
//        livro.getAutores().add(autor);
//
//        when(gutendexClient.buscarLivros()).thenReturn(List.of(livro));
//
//        livroService.buscarLivrosDaApi();
//
//        verify(autorRepository, times(1)).save(autor);
//        verify(livroRepository, times(1)).save(livro);
//    }
//}
