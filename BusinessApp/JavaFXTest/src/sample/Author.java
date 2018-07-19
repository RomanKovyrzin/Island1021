package sample;

import javafx.beans.property.*;
import javafx.fxml.FXML;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Author {

    private final ObjectProperty<Date> death;
    private final ObjectProperty<Date> born;
    private final StringProperty name;
    private final IntegerProperty id;

    public Author(model.Author author) {
        this.death = new SimpleObjectProperty<Date>(author.getDeath());
        this.born = new SimpleObjectProperty<Date>(author.getBorn());
        this.name = new SimpleStringProperty(author.getName());
        this.id = new SimpleIntegerProperty(author.getId());
    }

    public StringProperty Death() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String t = df.format(death.get());
        return new SimpleStringProperty(t);
    }
    public void setDeath(Date death) {
        this.death.set(death);
    }
    public Date getDeath() {
        return death.get();
    }

    public StringProperty Born() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String t = df.format(born.get());
        return new SimpleStringProperty(t);
    }
    public void setBorn(Date born) {
        this.born.set(born);
    }
    public Date getBorn() {
        return born.get();
    }

    public StringProperty Name() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getName() {
        return name.get();
    }

    public StringProperty Id() {
        return new SimpleStringProperty(String.valueOf(id.get()));
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public int getId() {
        return id.get();
    }

}
