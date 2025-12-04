package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.findByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(text, rating);
        //gospod da chuva i da brane

    }

    @Override
    public List<Book> booksByAuthor(String author) {
        return bookRepository.findByAuthor_NameContainingIgnoreCase(author);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book update(Long bookId, String title, String genre, Double averageRating, Long authorId) {
        Book bookac=bookRepository.findById(bookId).orElseThrow();
        return bookRepository.save(bookac);
    }

    @Override
    public Book create(String title, String genre, Double averageRating, Long authorId) {
        Author author=authorRepository.findById(authorId).orElseThrow();
            return bookRepository.save(new Book(title, genre, averageRating, author));
    }

    @Override
    public void delete(Long bookId) {
         bookRepository.deleteById(bookId);
    }
}
