package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivroRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexClient gutendexClient;

    @PersistenceContext
    private EntityManager entityManager;

    public void buscarLivrosDaApi() {
        try {
            List<Livro> livros = gutendexClient.buscarLivros();
            for (Livro livro : livros) {
                for (Autor autor : livro.getAutores()) {
                    autorRepository.save(autor);
                }

                livroRepository.save(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarTodosOsLivros() {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("Livro.autores");
        return entityManager.createQuery("SELECT l FROM Livro l", Livro.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }

    public List<Livro> buscarLivrosPorAutor(String nomeAutor) {
        String[] partesNome = nomeAutor.split(" ");
        if (partesNome.length >= 2) {
            String nome = partesNome[0];
            String sobrenome = partesNome[partesNome.length - 1];
            String nomeFormatado = String.format("%s, %s", sobrenome, nome);
            return livroRepository.findByAutoresNomeContainingIgnoreCase(nomeFormatado);
        }

        return livroRepository.findByAutoresNomeContainingIgnoreCase(nomeAutor);
    }

}
