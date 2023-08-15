package click.touchit.springgraphql.repository;

import click.touchit.springgraphql.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static click.touchit.springgraphql.model.Rating.*;

@Repository
public class BookRepository {

    private final AuthorRepository authorRepository;

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Integer id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book Not Found"));
    }

    @PostConstruct
    public void init() {
        books.add(new Book(1, "Springboot", 100, FIVE_STAR, authorRepository.findById(2)));
        books.add(new Book(2, "GraphQL", 500, THREE_STAR, authorRepository.findById(1)));
        books.add(new Book(3, "Testing", 400, TWO_STAR, authorRepository.findById(3)));
    }
}
