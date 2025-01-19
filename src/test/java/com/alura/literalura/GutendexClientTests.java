package com.alura.literalura;

import com.alura.literalura.model.Livro;
import com.alura.literalura.service.GutendexClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

public class GutendexClientTests {

    @Mock
    private GutendexClient gutendexClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarLivros() throws Exception {
        when(gutendexClient.buscarLivros()).thenReturn(List.of(new Livro()));

        List<Livro> livros = gutendexClient.buscarLivros();
        assertFalse(livros.isEmpty());

    }
}
