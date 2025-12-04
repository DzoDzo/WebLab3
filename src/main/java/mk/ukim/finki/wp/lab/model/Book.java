    package mk.ukim.finki.wp.lab.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;


    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTo mby
        private Long id;
        private String title;
        private String genre;
        private Double averageRating;
        @ManyToOne
        private Author author;

        public Book() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public Double getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(Double averageRating) {
            this.averageRating = averageRating;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public Book(String title, String genre, Double averageRating, Author author){
            this.title = title;
            this.genre = genre;
            this.averageRating = averageRating;
            this.author = author;
        }
    }
