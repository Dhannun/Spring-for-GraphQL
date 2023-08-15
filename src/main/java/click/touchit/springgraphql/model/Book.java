package click.touchit.springgraphql.model;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {
}
