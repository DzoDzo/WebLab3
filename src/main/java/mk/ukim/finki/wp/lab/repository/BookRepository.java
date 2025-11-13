package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    Book findBookById(Long id);
    Book update(Long bookId, String title, String genre, Double averageRating, Long authorId);
    Book create(String title, String genre, Double averageRating, Long authorId);
    Book delete(Long bookId);
}
