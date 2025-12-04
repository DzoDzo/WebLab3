package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();
    Author findAuthorById(Long id);
    Author update(Long authorId, String name, String surname, String biography, AGEGROUP agegroup);
    Author create(String name, String surname, String biography, AGEGROUP agegroup);
    void delete(Long id);
}
