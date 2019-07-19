package us.plee19.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping("/movies/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    @RequestMapping(method= RequestMethod.POST,
            value="/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}
