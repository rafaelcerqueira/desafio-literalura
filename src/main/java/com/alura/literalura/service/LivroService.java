package com.alura.literalura.service;

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

}
