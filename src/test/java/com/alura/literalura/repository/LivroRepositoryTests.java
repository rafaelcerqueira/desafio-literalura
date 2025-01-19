package com.alura.literalura.repository;

import com.alura.literalura.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class LivroRepositoryTests {

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void testSaveAndFindLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Teste Livro");
        livro.setIsbn("123456789");
        livroRepository.save(livro);

        Optional<Livro> found = livroRepository.findById(livro.getId());
        assertTrue(found.isPresent());
    }
}
