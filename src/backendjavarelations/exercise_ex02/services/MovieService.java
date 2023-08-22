package backendjavarelations.exercise_ex02.services;

import backendjavarelations.exercise_ex02.Movie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    
    private static final int MOVIES_QUANTITY = 30;
    private final List<Movie> movies;

    public MovieService() {
        movies = new ArrayList<>();
    }
    
    public void loadMovies() {
        try (Scanner sc = new Scanner(
                new File("src/backendjavarelations/exercise_ex02/resources/movies"))) {
            for (int i = 0; i < MOVIES_QUANTITY; i++) {
                String[] movieData = sc.nextLine().split(";");
                movies.add(new Movie(movieData[0], Integer.parseInt(movieData[1]),
                        Integer.parseInt(movieData[2]), movieData[3]));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Movies files not found.");
        }
    }
    
    public List<Movie> getMovies() {
        return movies;
    }
    
    public Movie getRandomMovie() {
        return movies.get((int) ((Math.random() * MOVIES_QUANTITY)));
    }
    
}
