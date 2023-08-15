package click.touchit.springgraphql.controller;

import click.touchit.springgraphql.model.Book;
import click.touchit.springgraphql.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAll() {
        logger.info("Fetching All Books");
        return bookRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", value = "findOne")
    public Book findById(@Argument Integer id) {
        logger.info("Fetching Book with ID [ %s ]".formatted(id));
        return bookRepository.findById(id);
    }

}
