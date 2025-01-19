package com.alura.literalura.repository;

import com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @EntityGraph(attributePaths = "autores")
    List<Livro> findByAutoresNomeContainingIgnoreCase(String nomeAutor);
}
