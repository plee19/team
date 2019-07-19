package us.plee19.team;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    public String name;
    public int year;

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Movie() {
        name = null;
        year = 0;
    }

    public String getName() {
        return name;
    }
}
