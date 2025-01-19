//package com.alura.literalura.repository;
//
//import com.alura.literalura.model.Autor;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//public class AutorRepositoryTests {
//
//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Test
//    public void testSaveAndFindAutor() {
//        Autor autor = new Autor();
//        autor.setNome("Teste Autor");
//        autorRepository.save(autor);
//
//        Optional<Autor> found = autorRepository.findById(autor.getId());
//        assertTrue(found.isPresent());
//    }
//}
