package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "Livro.autores", attributeNodes = @NamedAttributeNode("autores"))
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    //private int anoPublicacao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    public int getAnoPublicacao() {
//        return anoPublicacao;
//    }
//
//    public void setAnoPublicacao(int anoPublicacao) {
//        this.anoPublicacao = anoPublicacao;
//    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutors(Set<Autor> autores) {
        this.autores = autores;
    }

}
