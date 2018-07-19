package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "publishes")
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "publishes")
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "author", referencedColumnName = "id", nullable = false)
    private Set<Author> author = new HashSet<Author> ();

    public Publish() {
    }

    public Publish(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.author.add(author);
    }
    public Set<Author> getAuthor() {
        return author;
    }

    public void setTile(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

}
