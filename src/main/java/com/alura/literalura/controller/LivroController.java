package com.alura.literalura.controller;

import com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/buscar-livros")
    public String buscarLivros() {
        livroService.buscarLivrosDaApi();
        return "Livros buscados e armazenados com sucesso!";
    }
}
