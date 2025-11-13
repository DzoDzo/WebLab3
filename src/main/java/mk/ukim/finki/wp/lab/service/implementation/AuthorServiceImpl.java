package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }

    @Override
    public Author update(Long authorId, String name, String surname, String biography, AGEGROUP agegroup) {
        return authorRepository.update(authorId, name, surname, biography, agegroup);
    }

    @Override
    public Author create(String name, String surname, String biography, AGEGROUP agegroup) {
        return authorRepository.create(name, surname, biography, agegroup);
    }

    @Override
    public Author delete(Long id) {
        return authorRepository.delete(id);
    }
}
