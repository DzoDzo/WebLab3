package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.service.implementation.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorService authorService, AuthorServiceImpl authorServiceImpl) {
        this.authorService = authorService;
        this.authorServiceImpl = authorServiceImpl;
    }

    @GetMapping("/edit/{authorId}")
    public String formEditAuthor(@PathVariable Long authorId, Model model){
        model.addAttribute("author", authorServiceImpl.findAuthorById(authorId));
        model.addAttribute("agegroups", AGEGROUP.values());
        return "author-form";
    }

    @PostMapping("/edit/{authorId}")
    public String editAuthor(@PathVariable Long authorId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String biography ,
                             @RequestParam AGEGROUP agegroup){
        authorService.update(authorId, name, surname, biography, agegroup);
        return "redirect:/authors";
    }

    @GetMapping("/add")
    public String formSaveAuthor(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author-form";
    }

    @PostMapping("/add")
    public String saveAuthor(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String biography,
                           @RequestParam AGEGROUP agegroup){
        authorService.create(name, surname, biography, agegroup);
        return "redirect:/authors";
    }

    @PostMapping("/delete/{authorId}")
    public String deleteauthor(@PathVariable Long authorId){
        authorService.delete(authorId);
        return "redirect:/authors";
    }

    @GetMapping("")
    public String getAuthorsPage(
            @RequestParam(required = false) String error,
            Model model
    ){
        model.addAttribute("authors", authorService.findAll());
        return "listAuthors";
    }

}
