package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.AGEGROUP;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAuthorRepositoryImpl implements AuthorRepository {
    @Override
    public List<Author> findAll(){
        return DataHolder.authors;
    }

    @Override
    public Author findAuthorById(Long id) {
        return DataHolder.authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public Author update(Long authorId, String name, String surname, String biography, AGEGROUP agegroup) {
        Author toUpdate = DataHolder.authors.stream().filter(b -> b.getId().equals(authorId)).findFirst().orElse(null);
        if (toUpdate != null) {
            toUpdate.setName(name);
            toUpdate.setSurname(surname);
            toUpdate.setBiography(biography);
            toUpdate.setAgegroup(agegroup);
        }
        return toUpdate;
    }
//edit delete add new author
    @Override
    public Author create(String name, String surname, String biography, AGEGROUP agegroup) {
        Author a = new Author(name, surname, biography, agegroup);
        DataHolder.authors.add(a);

        return a;
    }

    @Override
    public Author delete(Long id) {
        Author a = findAuthorById(id);
        DataHolder.authors.remove(a);
        return a;
    }
}
