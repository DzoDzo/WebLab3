package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String surname;
    private String biography;
    private AGEGROUP agegroup;

    public Author(String name, String surname, String biography, AGEGROUP agegroup){
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.agegroup = agegroup;
    }

}
