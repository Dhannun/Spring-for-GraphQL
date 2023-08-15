package click.touchit.springgraphql.repository;

import click.touchit.springgraphql.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(Integer id) {
        return  authors.stream()
                .filter(author -> Objects.equals(author.id(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author Not Found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> Objects.equals(author.fullName(), name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1, "Yunus", "Muhammad"));
        authors.add(new Author(2, "Husna", "Abubakar"));
        authors.add(new Author(3, "Maryam", "Abu-Dukhan"));
    }
}
