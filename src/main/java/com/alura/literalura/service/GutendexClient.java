package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexClient {
    private static final String API_URL = "https://gutendex.com/books";
    public final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public GutendexClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<Livro> buscarLivros() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = objectMapper.readTree(response.body());

        List<Livro> livros = new ArrayList<>();
        JsonNode results = jsonNode.get("results");
        if (results.isArray()) {
            for (JsonNode result : results) {
                Livro livro = new Livro();
                livro.setTitulo(result.get("title").asText());
                livro.setIsbn(result.has("isbn") ? result.get("isnb").asText() : null);

                JsonNode authorsNode = result.get("authors");
                if (authorsNode.isArray()) {
                    for (JsonNode authorNode : authorsNode) {
                        Autor autor = new Autor();
                        autor.setNome(authorNode.get("name").asText());
                        livro.getAutores().add(autor);
                    }
                }
                livros.add(livro);
            }
        }

        return livros;
    }


}
