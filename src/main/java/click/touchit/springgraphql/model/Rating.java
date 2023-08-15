package click.touchit.springgraphql.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {
    FIVE_STAR("⭐⭐⭐⭐⭐"),
    FOUR_STAR("⭐⭐⭐⭐"),
    THREE_STAR("⭐⭐⭐"),
    TWO_STAR("⭐⭐"),
    ONE_STAR("⭐");

    private final String star;

    Rating(String star) {
        this.star = star;
    }

    @JsonValue
    public String getStar() {
        return star;
    }
}
