package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService){
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String makeReservation(
            @RequestParam(required = true) Long bookId,
            @RequestParam(required = true) String readerName,
            @RequestParam(required = true) String readerAddress,
            @RequestParam(required = true) Integer numCopies,
            HttpServletRequest req,
            Model model
    ){

        model.addAttribute("address", req.getRemoteAddr());
        model.addAttribute("bookReservation", bookReservationService.placeReservation(bookId, readerName, readerAddress, numCopies.longValue()));
        return "reservationConfirmation";
    }
}
