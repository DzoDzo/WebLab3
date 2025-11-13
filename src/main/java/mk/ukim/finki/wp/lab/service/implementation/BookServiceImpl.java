package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Book update(Long bookId, String title, String genre, Double averageRating, Long authorId) {
        return bookRepository.update(bookId, title, genre, averageRating, authorId);
    }

    @Override
    public Book create(String title, String genre, Double averageRating, Long authorId) {
        return bookRepository.create(title, genre, averageRating, authorId);
    }

    @Override
    public Book delete(Long bookId) {
        return bookRepository.delete(bookId);
    }
}
