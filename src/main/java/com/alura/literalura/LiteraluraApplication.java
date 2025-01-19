package com.alura.literalura;

import com.alura.literalura.model.Livro;
import com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroService livroService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("Selecione uma opção: ");
			System.out.println("1 - Buscar Livros da API Gutendex");
			System.out.println("2 - Listar Todos os Livros");
			System.out.println("3 - Buscar Livros por Autor");
			System.out.println("0 - Sair");
			System.out.println(">>> ");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
                    try {
                        livroService.buscarLivrosDaApi();
                        System.out.println("Livros buscados e armazenados com sucesso!");
                    } catch (Exception e) {
						System.out.println("Erro ao buscar livros da API: " + e.getMessage());
                    }
					break;
				case 2:
                    try {
                        livroService.listarTodosOsLivros().forEach(this::exibirInformacoesLivro);

                    } catch (Exception e) {
						System.out.println("Erro ao listar livros: " + e.getMessage());
                    }
					break;
				case 3:
                    try {
                        System.out.println("Digite o nome do autor: ");
                        String nomeAutor = scanner.nextLine();
                        livroService.buscarLivrosPorAutor(nomeAutor).forEach(this::exibirInformacoesLivro);

                    } catch (Exception e) {
						System.out.println("Erro ao buscar livros por autor: " + e.getMessage());
                    }
					break;
				case 0:
					running = false;
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		}
		scanner.close();
		System.exit(0);
	}

	private void exibirInformacoesLivro(Livro livro) {
		StringBuilder sb = new StringBuilder();
		sb.append("Título: ").append(livro.getTitulo()).append("\n");
		sb.append("ISBN: ").append(livro.getTitulo()).append("\n");
		sb.append("Autores: ");
		livro.getAutores().forEach(autor -> sb.append(autor.getNome()).append(", "));
		System.out.println(sb.toString());
	}

}


