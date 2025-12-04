package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static List<Book> books;
    public static List<BookReservation> reservations;
    public static List<Author> authors;

    @PostConstruct
    public void init() {
        books = new ArrayList<>();
        reservations = new ArrayList<>();
        authors = new ArrayList<>();

        authors.add(new Author("ad", "d", "a", AGEGROUP.mlad));
        authors.add(new Author("Damjan", "Zimbakov", "b", AGEGROUP.mlad));
        authors.add(new Author("k", "l", "Jc", AGEGROUP.mlad));

        books.add(new Book("Lytyt", "yt", 4.3, authors.get(0)));
        books.add(new Book("yt", "Sci-ytfi", 5.0, authors.get(2)));

    }
}
