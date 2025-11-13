package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/edit/{bookId}")
    public String formEditBook(@PathVariable Long bookId,
                               Model model){
        model.addAttribute("book", bookService.getBookById(bookId));
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.update(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String formSaveBook(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.create(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        bookService.delete(bookId);
        return "redirect:/books";
    }

    @GetMapping("")
    public String getBooksPage(
            @RequestParam(required = false) String error,
            Model model
    ){
        model.addAttribute("books", bookService.listAll());
        return "listBooks";
    }

}
