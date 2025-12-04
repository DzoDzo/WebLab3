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
        this.authorRepository.save(new Author("Vasil","Levski","Geroj",AGEGROUP.star));
        this.authorRepository.save(new Author("Dimitar","Miladinov","Gerojishche",AGEGROUP.star));
        this.authorRepository.save(new Author("pero","pero","pero",AGEGROUP.mlad));
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Author update(Long authorId, String name, String surname, String biography, AGEGROUP agegroup) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        return authorRepository.save(author);
    }

    @Override
    public Author create(String name, String surname, String biography, AGEGROUP agegroup) {
        return authorRepository.save(new Author(name, surname, biography, agegroup));
    }

    @Override
    public void delete(Long id) {
         authorRepository.deleteById(id);
    }
}
