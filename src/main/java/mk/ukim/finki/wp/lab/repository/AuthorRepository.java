package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface AuthorRepository {
    List<Author> findAll();
    Author findAuthorById(Long id);
    Author update(Long authorId, String name, String surname, String biography, AGEGROUP agegroup);
    Author create(String name, String surname, String biography, AGEGROUP agegroup);
    Author delete(Long id);
}
