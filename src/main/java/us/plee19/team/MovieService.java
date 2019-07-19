package us.plee19.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        if (movies.size() == 0) {
            movieRepository.save(new Movie("Star Wars", 1977));
            movieRepository.save(new Movie("Cars", 2006));
            movieRepository.save(new Movie("Aquaman", 2018));
            movieRepository.findAll().forEach(movies::add);
        }
        return movies;
    }

    public Movie getMovie(String id) {
        return (Movie) movieRepository.findById(id).orElse(new Movie("Missing Movie", 0));
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, String id) {
        movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.delete(getMovie(id));
    }
}
