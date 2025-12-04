package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    List<Book> booksByAuthor(String author);
    Book getBookById(Long id);
    Book update(Long bookId, String title, String genre, Double averageRating, Long authorId);
    Book create(String title, String genre, Double averageRating, Long authorId);
    void delete(Long bookId);
}
