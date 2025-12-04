//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Author;
//import mk.ukim.finki.wp.lab.model.Book;
//import mk.ukim.finki.wp.lab.repository.AuthorRepository;
//import mk.ukim.finki.wp.lab.repository.BookRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.xml.crypto.Data;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class InMemoryBookRepository implements BookRepository {
//    private final AuthorRepository authorRepository;
//
//    public InMemoryBookRepository(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }
//
//    @Override
//    public List<Book> findAll() {
//        return DataHolder.books;
//    }
//
//    @Override
//    public List<Book> searchBooks(String text, Double rating) {
//        return DataHolder.books.stream()
//                .filter(c -> c.getTitle().toLowerCase().contains(text.toLowerCase()))
//                .filter(c -> c.getAverageRating() >= rating)
//                .toList();
//    }
//
//    @Override
//    public Book findBookById(Long id) {
//        return DataHolder.books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    @Override
//    public Book update(Long bookId, String title, String genre, Double averageRating, Long authorId) {
//        Book toUpdate = DataHolder.books.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
//        if (toUpdate != null) {
//            toUpdate.setTitle(title);
//            toUpdate.setGenre(genre);
//            toUpdate.setAverageRating(averageRating);
//            toUpdate.setAuthor(authorRepository.findAuthorById(authorId));
//        }
//
//        return toUpdate;
//    }
//
//    @Override
//    public Book create(String title, String genre, Double averageRating, Long authorId) {
//        Book b = new Book(title, genre, averageRating, authorRepository.findAuthorById(authorId));
//        DataHolder.books.add(b);
//
//        return b;
//    }
//
//    @Override
//    public Book delete(Long bookId) {
//        Book b = findBookById(bookId);
//        DataHolder.books.remove(b);
//        return b;
//    }
//}
