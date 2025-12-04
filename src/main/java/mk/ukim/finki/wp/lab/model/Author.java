package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String biography;
    @Enumerated(EnumType.STRING)
    private AGEGROUP agegroup;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public AGEGROUP getAgegroup() {
        return agegroup;
    }

    public void setAgegroup(AGEGROUP agegroup) {
        this.agegroup = agegroup;
    }

    public Author(String name, String surname, String biography, AGEGROUP agegroup){
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.agegroup = agegroup;
    }

}
