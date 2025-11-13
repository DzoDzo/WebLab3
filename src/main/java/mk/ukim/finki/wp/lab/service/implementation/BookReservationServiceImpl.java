package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;
    private final BookRepository bookRepository;
    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository, BookReservationRepository bookReservationRepository1, BookRepository bookRepository) {
        this.bookReservationRepository = bookReservationRepository1;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookReservation placeReservation(Long bookId, String readerName, String readerAddress, Long numberOfCopies) {
        return this.bookReservationRepository.save(new BookReservation(bookRepository.findBookById(bookId), readerName, readerAddress, numberOfCopies));
    }
}
